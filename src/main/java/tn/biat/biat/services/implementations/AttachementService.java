package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.biat.biat.entities.otherDB.Attachement;
import tn.biat.biat.entities.otherDB.User;
import tn.biat.biat.repository.AttachementRepository;
import tn.biat.biat.services.IAttachementService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tn.biat.biat.services.ITreeService;

import static java.nio.file.Paths.get;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;


@Service
@Slf4j
public class AttachementService implements IAttachementService {


    private final ResourceLoader resourceLoader = new DefaultResourceLoader();

    @Autowired
    AttachementRepository attachementRepository;
    @Autowired
    CustomUserDetailsService userService;
    @Autowired
    ITreeService iTreeService;

    HistoryService historyService;


    @Autowired
    public AttachementService( @Lazy HistoryService historyService){
        this.historyService = historyService;
    }

    @Value("${spring.datasource.url}")
    private String DBURL;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public boolean delete(Long id){
        Attachement att = attachementRepository.findById(id).orElse(null);
        if(att == null){
            return false;
        }else{
            String QUERY = "DELETE FROM public.\"Message_attachements\" WHERE attachements_id = " + id;
            try (Connection conn = DriverManager.getConnection(DBURL, user, password);) {
                try (PreparedStatement st = conn.prepareStatement(QUERY)) {
                    int result = st.executeUpdate();
                    if (result == 0) {
                        System.out.println("No rows affected.");
                    } else {
                        System.out.println(result + " rows affected.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String QUERY1 = "DELETE FROM public.\"Attachement\" WHERE \"id\" =" + id;
            try (Connection conn = DriverManager.getConnection(DBURL, user, password);) {
                try (PreparedStatement st = conn.prepareStatement(QUERY1)) {
                    int result = st.executeUpdate();
                    if (result == 0) {
                        System.out.println("No rows affected.");
                    } else {
                        System.out.println(result + " rows affected.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            historyService.updateUserHistories("DELETE","Delete attachement");
            return true;
        }
    }


    public static final String DIRECTORY = "C:\\Users\\onske\\Desktop\\biat2\\src\\main\\resources\\static\\files";

    @Override
    public List<String> uploadFiles(List<MultipartFile> multipartFiles){
        List<String> filenames = new ArrayList<>();
        try {
            for(MultipartFile file : multipartFiles) {
                System.out.println(multipartFiles);
                String filename = StringUtils.cleanPath(file.getOriginalFilename());
                filenames.add(filename);
                Files.copy(file.getInputStream(), Paths.get(DIRECTORY+ file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return filenames;
    }


    public static final String DIRECTORY2 = "/static/files/";

    @Override
    public List<String> listAllFiles() {
        try {
            // load the resource for the directory containing the files
            Resource resource = resourceLoader.getResource(DIRECTORY2);
            // get the file path from the resource
            String path = resource.getFile().getAbsolutePath();
            // list all the files in the directory
            File[] files = new File(path).listFiles();
            if (files != null) {
                // return a list of file names
                return Arrays.stream(files)
                        .map(File::getName)
                        .collect(Collectors.toList());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Resource downloadFiles(String filename) throws IOException {
        System.out.println(filename);
        Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
        if(!Files.exists(filePath)) {
            throw new FileNotFoundException(filename + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filename);
        System.out.println("hhhhhhhhhhh "+resource.getFilename());
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name= " + resource.getFilename());
        System.out.println(resource);
        return resource;
    }



    @Override
    public List<List<String>> getDataFromExcel(String fileName,Long iduser) throws IOException {
        List<List<String>> data = new ArrayList<>();
        System.out.println("hhhhhhhhhhh "+ fileName);
        User u = userService.getUserById(iduser);
        System.out.println("userr "+u);
/*        for(String name: this.listAllFiles()) {
            if (name.equals(fileName.replace(".xlsx", "")+"-"+u.getLibelle()+".xlsx")) {
                System.out.println("famma " + fileName+" *** " + name);
                return data;
            }
        }*/

        Resource resource = resourceLoader.getResource(DIRECTORY2+fileName);
        FileInputStream fileInputStream = new FileInputStream(resource.getFile());
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        System.out.println("ons");
        for (Row row : worksheet) {
            List<String> rowData = new ArrayList<>();
            for (Cell cell : row) {
                rowData.add(cell.toString());
            }
            data.add(rowData);
        }
        workbook.close();
        int i=0;
        int j=0;
        List<String> codes = new ArrayList<>();
        List<List<String>> finaldata = new ArrayList<>();
        for( String s : data.get(0)){
            if(s.equals("code")){
                if(Objects.equals(u.getProfile().getProfileType(), "AGENCE") || Objects.equals(u.getProfile().getProfileType(), "CA")){
                    for (int y=1; y<=data.size()-1; y++) {
                        if (data.get(y).get(i).replaceAll("\\.0", "").equals(u.getLibelle())) {
                            for (String ss : data.get(0)) {
                                System.out.println("9ball "+j);
                                if (ss.equals("account")) {
                                    System.out.println("j = "+j);
                                    codes.add(data.get(y).get(j));
                                }
                                j++;
                            }
                            j=0;
                        }
                    }
                }else if(Objects.equals(u.getProfile().getProfileType(), "ZONE") || Objects.equals(u.getProfile().getProfileType(), "GROUPE")){
                    List<String> AgenceByZone = iTreeService.getAgenceByZone(u.getId());
                    codes.clear();
                    for (int y=1; y<=data.size()-1; y++) {
                        if (AgenceByZone.contains(data.get(y).get(i).replaceAll("\\.0", ""))) {
                            for (String ss : data.get(0)) {
                                System.out.println("9ball "+j);
                                if (ss.equals("account")) {
                                    System.out.println("j = "+j);
                                    codes.add(data.get(y).get(j));
                                }
                                j++;
                            }
                            j=0;
                        }
                    }
                }else if(Objects.equals(u.getProfile().getProfileType(), "REGION")) {
                    List<String> AgenceByRegion = iTreeService.getAgenceByRegion(u.getId());
                    codes.clear();
                    for (int y=1; y<=data.size()-1; y++) {
                        if (AgenceByRegion.contains(data.get(y).get(i).replaceAll("\\.0", ""))) {
                            for (String ss : data.get(0)) {
                                System.out.println("9ball "+j);
                                if (ss.equals("account")) {
                                    System.out.println("j = "+j);
                                    codes.add(data.get(y).get(j));
                                }
                                j++;
                            }
                            j=0;
                        }
                    }
                }else if(Objects.equals(u.getProfile().getProfileType(), "PCB") || Objects.equals(u.getProfile().getProfileType(), "PBD")) {
                    List<String> AgenceByPole = iTreeService.getAgenceByPole(iduser);
                    codes.clear();
                    for (int y=1; y<=data.size()-1; y++) {
                        if (AgenceByPole.contains(data.get(y).get(i).replaceAll("\\.0", ""))) {
                            for (String ss : data.get(0)) {
                                System.out.println("9ball "+j);
                                if (ss.equals("account")) {
                                    System.out.println("j = "+j);
                                    codes.add(data.get(y).get(j));
                                }
                                j++;
                            }
                            j=0;
                        }
                    }
                }else {
                    codes.clear();
                    for (int y=1; y<=data.size()-1; y++){
                        for (String ss : data.get(0)) {
                            System.out.println("9ball "+j);
                            if (ss.equals("account")) {
                                System.out.println("j = "+j);
                                codes.add(data.get(y).get(j));
                            }
                            j++;
                        }
                        j=0;
                    }
                    System.out.println("okhrojj");
                }
                System.out.println("codes "+codes);
            }
            i++;
        }
        finaldata.add(data.get(0));
        String newFileName = fileName.replace(".xlsx", "")+"-"+u.getLibelle()+".xlsx";
        for(int l=1; l<= data.size()-1; l++){
            for (String ss : data.get(0)) {
                System.out.println("9ball "+j);
                if (ss.equals("account")){
                    if(codes.contains(data.get(l).get(j))){
                        finaldata.add(data.get(l));
                        System.out.println(finaldata);
                        writeToExcel(finaldata, newFileName, iduser);
                        System.out.println("new excel file "+newFileName+" : done");
                    }
                }
                j++;
            }j=0;
        }
        this.downloadFiles(newFileName);
        return data;
    }

    public void writeToExcel(List<List<String>> finaldata, String fileName ,Long iduser) throws IOException {
        // create a new workbook and sheet
        System.out.println("dkhall li write to excel");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        User u = userService.getUserById(iduser);

        // write data to sheet
        int rowNum = 0;
        for (List<String> row : finaldata) {
            Row sheetRow = sheet.createRow(rowNum++);
            int colNum = 0;
            for (String cellValue : row) {
                Cell cell = sheetRow.createCell(colNum++);
                cell.setCellValue(cellValue);
            }
        }
        System.out.println("mmmmmmmmmmmmmmmmmm");
        // save workbook to file
        FileOutputStream outputStream = new FileOutputStream(DIRECTORY+"/"+ fileName);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }


}
