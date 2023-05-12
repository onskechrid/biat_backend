package tn.biat.biat.controller;

import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.biat.biat.entities.otherDB.DownloadPin;
import tn.biat.biat.services.IAttachementService;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.Paths.get;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

@RestController
@RequestMapping("/attachement")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class AttachementController {

    @Autowired
    IAttachementService iAttachementService;

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
        Boolean b = iAttachementService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }



    // define a location
    public static final String DIRECTORY = "C:\\Users\\onske\\Desktop\\biat2\\src\\main\\resources\\static\\files";

    // Define a method to upload files
    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException {
        List<String> filenames = iAttachementService.uploadFiles(multipartFiles);
        return ResponseEntity.ok().body(filenames);
    }

    @PostMapping("/code/{pin}")
    public ResponseEntity<Boolean> check_code(@PathVariable("pin") String pin){
        return ResponseEntity.ok(iAttachementService.checkCode(pin));
    }
    // Define a method to download files
    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("filename") String filename) throws IOException {
        Resource resource = iAttachementService.downloadFiles(filename);
        HttpHeaders headers = new HttpHeaders();
        headers.add("File-Name", filename);
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }


    @GetMapping("/{filename}")
    public ResponseEntity<Resource> downloadFileFromResources(@PathVariable String filename) throws IOException {
        Path path = Paths.get("src/main/resources/static/files/" + filename);
        Resource resource = new UrlResource(path.toUri());

        String contentType = null;
        try {
            contentType = Files.probeContentType(path);
        } catch (IOException e) {
            // handle the exception as necessary
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/allFiles")
    public ResponseEntity<List<String>> listAllFiles(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iAttachementService.listAllFiles()
        );
    }

    @GetMapping("/data/{filename}/{iduser}")
    public ResponseEntity<Resource> getDataFromExcel(HttpServletResponse response, @PathVariable("filename") String filename, @PathVariable("iduser") Long iduser) throws IOException {
        Resource resource = iAttachementService.getDataFromExcel(filename, iduser);
        /*response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + filename + "\"");
        System.out.println("*** " + resource.getFilename());
        response.setContentLength((int) resource.contentLength());
        InputStream inputStream = resource.getInputStream();
        FileCopyUtils.copy(inputStream, response.getOutputStream());*/
        System.err.println(resource);
        HttpHeaders headers = new HttpHeaders();
        headers.add("File-Name", filename);
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }


    @GetMapping("/excel/template")
    public void downloadExcelTemplate(HttpServletResponse response) throws IOException {
        // Générer le modèle de fichier Excel
        Resource excelTemplate = generateExcelTemplate();

        // Définir les en-têtes de la réponse
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=template.xlsx");

        // Copier le contenu de la ressource dans le flux de sortie de la réponse
        excelTemplate.getInputStream().transferTo(response.getOutputStream());
    }


    private Resource generateExcelTemplate() throws IOException {
        // Créer un nouveau classeur Excel
        Workbook workbook = new XSSFWorkbook();

        // Créer une feuille de calcul
        Sheet sheet = workbook.createSheet("Liste des clients à noter");

        // Créer une ligne pour les en-têtes
        Row headerRow = sheet.createRow(1);

        // Ajouter des en-têtes avec une mise en forme personnalisée
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex()); // Set the background color to red
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


        Cell cell1 = headerRow.createCell(2);
        cell1.setCellValue("Colonne 1");
        cell1.setCellStyle(headerCellStyle);

        Cell cell2 = headerRow.createCell(3);
        cell2.setCellValue("Colonne 2");
        cell2.setCellStyle(headerCellStyle);


        // Ajouter le logo
        Drawing<?> drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 2, 2, 4);
        InputStream logoInputStream = new ClassPathResource("logo.png").getInputStream();
        byte[] logoBytes = IOUtils.toByteArray(logoInputStream);
        int logoIndex = workbook.addPicture(logoBytes, Workbook.PICTURE_TYPE_PNG);
        Picture picture = drawing.createPicture(anchor, logoIndex);
        picture.resize();

        // Remplir les données dans le modèle de fichier Excel
        // ...

        // Ajuster automatiquement la largeur des colonnes
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);

        // Convertir le classeur Excel en tableau d'octets
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        byte[] excelData = outputStream.toByteArray();
        outputStream.close();

        // Créer une ressource à partir du tableau d'octets
        ByteArrayInputStream inputStream = new ByteArrayInputStream(excelData);
        Resource resource = new InputStreamResource(inputStream);

        return resource;
    }


}
