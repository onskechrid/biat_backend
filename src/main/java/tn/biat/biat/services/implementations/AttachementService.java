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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.biat.biat.entities.otherDB.Attachement;
import tn.biat.biat.entities.otherDB.DownloadPin;
import tn.biat.biat.entities.otherDB.User;
import tn.biat.biat.repository.AttachementRepository;
import tn.biat.biat.repository.DownloadPinRepository;
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
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    DownloadPinRepository downloadPinRepository;
    @Autowired
    JavaMailSender javaMailSender;

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


    public static String DIRECTORY =  Paths.get("").toAbsolutePath()+ File.separator + "target" + File.separator + "static" + File.separator + "files" + File.separator;

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


    //public static final String DIRECTORY2 = "/static/files/";

    public List<String> getLibelles(){
        List<User> users = userService.getAll();
        List<String> list = new ArrayList<>();
        for(User u : users){
            list.add(u.getLibelle());
        }
        return list;
    }

    @Override
    public List<String> listAllFiles() {

        // load the resource for the directory containing the files
        Resource resource = resourceLoader.getResource(DIRECTORY);
        // get the file path from the resource
        System.err.println(resource.toString());
        // list all the files in the directory
        File[] files = new File(DIRECTORY).listFiles();
        for (File f : files){
            String fileName = f.getName();
            String substring = fileName.substring(fileName.lastIndexOf("-") + 1, fileName.lastIndexOf("."));
            if(getLibelles().contains(substring)){
                f.delete();
            }
        }
        if (files != null) {
            // return a list of file names
            return Arrays.stream(files)
                    .map(File::getName)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Resource downloadFiles(String filename) throws IOException {
        Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
        if(!Files.exists(filePath)) {
            throw new FileNotFoundException(filename + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filename);
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name= " + filename);
        System.out.println(resource);
        return resource;
    }


    @Override
    public Resource getDataFromExcel(String fileName,Long iduser) throws IOException {
        List<List<String>> data = new ArrayList<>();
        User u = userService.getUserById(iduser);
        Resource res = null;
        FileInputStream fileInputStream = new FileInputStream(DIRECTORY+fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet worksheet = workbook.getSheetAt(0);
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
                                if (ss.equals("account")) {
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
                                if (ss.equals("account")) {
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
                                if (ss.equals("account")) {
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
                            if (ss.equals("account")) {
                                codes.add(data.get(y).get(j));
                            }
                            j++;
                        }
                        j=0;
                    }
                }
            }
            i++;
        }
        finaldata.add(data.get(0));
        String newFileName = fileName.replace(".xlsx", "")+"-"+u.getLibelle()+".xlsx";

        for(int l=1; l<= data.size()-1; l++) {
            for (String ss : data.get(0)) {
                if (ss.equals("account")) {
                    if (codes.contains(data.get(l).get(j))) {
                        finaldata.add(data.get(l));
                        writeToExcel(finaldata, newFileName, iduser);
                        res = downloadFiles(newFileName);
                    }
                }
                j++;
            }
            j = 0;
        }
        return res;
    }

    public void writeToExcel(List<List<String>> finaldata, String fileName ,Long iduser) throws IOException {
        // create a new workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        User u = userService.getUserById(iduser);
        // write data to sheet
        int rowNum = 0;
        for (List<String> row : finaldata){
            Row sheetRow = sheet.createRow(rowNum++);
            int colNum = 0;
            for (String cellValue : row) {
                Cell cell = sheetRow.createCell(colNum++);
                cell.setCellValue(cellValue);
            }
        }
        // save workbook to file
        File fil = new File(DIRECTORY+ fileName);
        if(fil.delete()) System.err.println("yes"); else System.err.println("no");
        FileOutputStream outputStream = new FileOutputStream(DIRECTORY+ fileName);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    private static char randomChar() {
        int rand = new Random().nextInt(52);
        char start = (rand < 26) ? 'A' : 'a';
        return (char) (start + rand % 26);
    }
    @Async
    public void sendEmail(String to, String sub, String msg){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(sub);
        mailMessage.setText(msg);
        mailMessage.setFrom("ons.kechrid@esprit.tn");
        javaMailSender.send(mailMessage);
    }
    @Transactional
    @Override
    public boolean checkCode(String pin){
        User u = userService.getLoggedInUser();
        List<DownloadPin> pins = downloadPinRepository.findCodeByUserId(u.getId());
        System.err.println(pins.toString());
        StringBuilder genpin = new StringBuilder();
        String alphabet = "0123456789";
        if(pins.size() == 0){
            //generate new pin
            for(int i=0; i<=5; i++){
                Random r = new Random();
                char c = alphabet.charAt(r.nextInt(alphabet.length()));
                genpin.append(c);
            }
            System.err.println(genpin);
            DownloadPin dp = new DownloadPin();
            dp.setCreatedAt(LocalDateTime.now());
            dp.setPin(genpin.toString());
            dp.setIsValidated(false);
            dp.setUser(u);
            downloadPinRepository.save(dp);
            //now we send the email
            this.sendEmail(u.getEmail(), "Your pin", "TO be able to download the file here is your pin : " + genpin + ". PLease note this is valid only for 15min");
            return false;
        }else{
            //check if its not more than 15min
            long noOfSeconds = ChronoUnit.SECONDS.between(pins.get(0).getCreatedAt(),LocalDateTime.now());
            if(noOfSeconds > 900){
                //15min fetet
                //fassa5 code 9dim
                downloadPinRepository.deleteByUserId(u.getId());
                //generate new pin
                for(int i=0; i<=5; i++){
                    Random r = new Random();
                    char c = alphabet.charAt(r.nextInt(alphabet.length()));
                    genpin.append(c);
                }
                System.err.println(genpin);
                DownloadPin dp = new DownloadPin();
                dp.setCreatedAt(LocalDateTime.now());
                dp.setPin(genpin.toString());
                dp.setIsValidated(false);
                dp.setUser(u);
                downloadPinRepository.save(dp);
                //now we send the email
                this.sendEmail(u.getEmail(), "Your pin", "TO be able to download the file here is your pin : " + genpin + ". PLease note this is valid only for 15min");
                return false;
            }else{
                //15min mazelet
                List<DownloadPin>dpd = downloadPinRepository.findCodeByUserId(u.getId());
                DownloadPin dow = dpd.get(0);
                System.err.println(dow.getPin());
                System.err.println(pin);
                if(dow.getIsValidated() == true){
                    return true;
                }
                if(pin.equals(dow.getPin())) {
                    dow.setIsValidated(true);
                    downloadPinRepository.save(dow);
                    return true;
                }else {
                    return false;
                }
            }
        }
    }
}
