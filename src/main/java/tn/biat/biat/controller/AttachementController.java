package tn.biat.biat.controller;

import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.biat.biat.entities.otherDB.DownloadPin;
import tn.biat.biat.services.IAttachementService;

import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public void getDataFromExcel(HttpServletResponse response, @PathVariable("filename") String filename, @PathVariable("iduser") Long iduser) throws IOException {

        Resource  resource = iAttachementService.getDataFromExcel(filename,iduser);
        response.setContentType("file/csv");
        response.setHeader("Content-Disposition",
                String.format("attachment; filename=" + filename));

        response.setContentLength((int) resource.contentLength());
        InputStream inputStream = resource.getInputStream();
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }



}
