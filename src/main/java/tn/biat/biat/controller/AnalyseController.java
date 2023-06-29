package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<String> extractNumeroCompteFromPdf() {
        String information = analyseService.extractNumeroCompteFromPdf();
        return ResponseEntity.ok(information);
    }

    @GetMapping("/imgNC")
    public ResponseEntity<String> extractNumeroCompteFromImg() {
        String information = analyseService.extractNumeroCompteFromImg();
        return ResponseEntity.ok(information);
    }
    @GetMapping("/pdfSF")
    public ResponseEntity<String> extractSoldeFinValuesFromPdf() {
        String information = analyseService.extractSoldeFinValuesFromPdf();
        return ResponseEntity.ok(information);
    }
    @GetMapping("/imgSF")
    public ResponseEntity<String> extractSoldeFinValuesFromImg() {
        String information = analyseService.extractSoldeFinValuesFromImg();
        return ResponseEntity.ok(information);
    }
    @GetMapping("/pdfR")
    public ResponseEntity<List<String>> extractLinesWithReferenceFromPdf() {
        List<String> information = analyseService.extractLinesWithReferenceFromPdf();
        return ResponseEntity.ok(information);
    }
    @GetMapping("/imgR")
    public ResponseEntity<List<String>> extractLinesWithReferenceFromImg() {
        List<String> information = analyseService.extractLinesWithReferenceFromImg();
        return ResponseEntity.ok(information);
    }

}
