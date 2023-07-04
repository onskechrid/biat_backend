package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.services.StringDto;
import tn.biat.biat.services.implementations.AnalyseService;

import java.util.List;

@RestController
@RequestMapping("/analyse")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class AnalyseController {

    @Autowired
    AnalyseService analyseService;
    @GetMapping("/pdfNC")
    public ResponseEntity<StringDto> extractNumeroCompteFromPdf(){
        StringDto s = new StringDto();
        s.string = analyseService.extractNumeroCompteFromPdf();
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }

    @GetMapping("/imgNC")
    public ResponseEntity<StringDto> extractNumeroCompteFromImg() {
        StringDto s = new StringDto();
        s.string = analyseService.extractNumeroCompteFromImg();
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/pdfSF")
    public ResponseEntity<StringDto> extractSoldeFinValuesFromPdf() {
        StringDto s = new StringDto();
        s.string = analyseService.extractSoldeFinValuesFromPdf();
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/imgSF")
    public ResponseEntity<StringDto> extractSoldeFinValuesFromImg() {
        StringDto s = new StringDto();
        s.string = analyseService.extractSoldeFinValuesFromImg();
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/pdfR")
    public ResponseEntity<List<String>> extractLinesWithReferenceFromPdf() {
        List<String> information = analyseService.extractLinesWithReferenceFromPdf();
        return ResponseEntity.status(HttpStatus.OK).body(
                information
        );
    }
    @GetMapping("/imgR")
    public ResponseEntity<List<String>> extractLinesWithReferenceFromImg() {
        List<String> information = analyseService.extractLinesWithReferenceFromImg();
        return ResponseEntity.status(HttpStatus.OK).body(
                information
        );
    }

}
