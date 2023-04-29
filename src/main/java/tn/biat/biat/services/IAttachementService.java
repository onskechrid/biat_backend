package tn.biat.biat.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IAttachementService {

    boolean delete(Long id);
    List<String> uploadFiles(List<MultipartFile> multipartFiles);
    List<String> listAllFiles();
    List<List<String>> getDataFromExcel(String fileName, Long iduser) throws IOException;
    Resource downloadFiles(String filename) throws IOException;
}
