package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.formula.*;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.*;
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

import tn.biat.biat.services.ITreeService;

import static java.nio.file.Paths.get;


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
                        List<List<String>> d = new ArrayList<>();
                        for (int y = 1; y <= finaldata.size() - 1; y++) {
                            List<String> innerList = finaldata.get(y);
                            List<String> filteredList = new ArrayList<>();

                            for (String item : innerList) {
                                item = item.replaceAll("\\.0$", ""); // Remove ".0" at the end of the string
                                filteredList.add(item);
                            }

                            d.add(filteredList);
                        }
                        writeToExcel(d, newFileName,iduser);
                        System.err.println(newFileName);
                        res = downloadFiles(newFileName);
                    }
                }
                j++;
            }
            j = 0;
        }
        return res;
    }

    public void writeToExcel(List<List<String>> data, String newFileName, Long iduser) throws IOException {
        FileInputStream templateFile = new FileInputStream(DIRECTORY + "template.xlsx");
        Workbook workbook = new XSSFWorkbook(templateFile);
        Sheet sheet = workbook.getSheetAt(0);

        int rowIndex = 10; // Start writing data from the 11th row
        int columnIndex = 3; // Start writing data from the 4th column

        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        for (List<String> rowData : data) {
            Row row1 = sheet.createRow(rowIndex);
            Row row2 = sheet.createRow(rowIndex+1);
            boolean isFirstIteration = true;

            for (String cellData : rowData) {
                Cell cell1 = row1.createCell(columnIndex);
                Cell cell2 = row2.createCell(columnIndex);
                cell1.setCellValue(cellData);
                if (!isFirstIteration) {
                    cell2.setCellValue(cellData);
                }

                CellRangeAddress mergedRegion = new CellRangeAddress(rowIndex, rowIndex + 1, columnIndex, columnIndex + 2);
                sheet.addMergedRegion(mergedRegion);

                columnIndex += 3;
                isFirstIteration = false;
            }
            rowIndex += 2; // Increment the rowIndex by 2 for the merged rows
            columnIndex = 3; // Reset the columnIndex for the next row
        }


        FileOutputStream outputFile = new FileOutputStream(DIRECTORY + newFileName);
        workbook.write(outputFile);

        templateFile.close();
        outputFile.close();
        workbook.close();
    }



    /*public void writeToExcel(List<List<String>> finaldata, String fileName, Long iduser) throws IOException {
        // create a new workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Liste des clients à noter");
        User u = userService.getUserById(iduser);

        // Center the table horizontally and vertically
        sheet.setHorizontallyCenter(true);
        sheet.setVerticallyCenter(true);

        // Set the column widths
        sheet.setColumnWidth(2, 10000);
        sheet.setColumnWidth(3, 10000);
        sheet.setColumnWidth(4, 10000);
        sheet.setColumnWidth(5, 10000);

        // Create the cell style
        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        // Add the logo to the sheet
        Drawing<?> drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 2, 1, 3, 2); // Set the anchor coordinates to cover the first cell
        anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE); // Set the anchor type
        InputStream logoInputStream = new ClassPathResource("logo.png").getInputStream();
        byte[] logoBytes = IOUtils.toByteArray(logoInputStream);
        int logoIndex = workbook.addPicture(logoBytes, Workbook.PICTURE_TYPE_PNG);
        Picture picture = drawing.createPicture(anchor, logoIndex);
        picture.resize(0.5, 1);

        // Create the title cell
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Liste des clients à noter");
        CellStyle titleStyle = workbook.createCellStyle();
        Font titleFont = workbook.createFont();
        titleFont.setBold(true);
        titleFont.setFontName("Arial Black");
        titleFont.setColor(IndexedColors.BLUE.getIndex());
        titleFont.setFontHeightInPoints((short) 26);
        titleStyle.setFont(titleFont);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleCell.setCellStyle(titleStyle);

        // Set the height of the first row
        titleRow.setHeightInPoints(100);

        // Set the background color for the first row
        titleStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Merge the cells in the first row
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

        // Write data to sheet
        int rowNum = 2;
        for (List<String> row : finaldata) {
            Row sheetRow = sheet.createRow(rowNum++);
            int colNum = 3;
            for (String cellValue : row) {
                Cell cell = sheetRow.createCell(colNum++);
                cell.setCellValue(cellValue);
                cell.setCellStyle(cellStyle);
            }
        }

        // Save workbook to file
        File fil = new File(DIRECTORY + fileName);
        if (fil.delete()) {
            System.err.println("yes");
        } else {
            System.err.println("no");
        }

        FileOutputStream outputStream = new FileOutputStream(DIRECTORY + fileName);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }*/


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
            //this.sendEmail(u.getEmail(), "Your pin", "TO be able to download the file here is your pin : " + genpin + ". PLease note this is valid only for 15min");
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



    @Override
    public Resource generateExcelTemplate() throws IOException {
        // Créez un nouveau classeur Excel
        Workbook workbook = new XSSFWorkbook();

        // Créez une feuille dans le classeur
        Sheet sheet = workbook.createSheet("Template");

        // Créez des cellules et ajoutez des valeurs
        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Nom");

        // ...

        // Convertissez le classeur en tableau de bytes
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        // Créez une ressource ByteArrayResource à partir du tableau de bytes
        byte[] bytes = outputStream.toByteArray();
        Resource resource = new ByteArrayResource(bytes);

        return resource;
    }
}
