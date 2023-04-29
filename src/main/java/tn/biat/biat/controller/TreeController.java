package tn.biat.biat.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.entities.otherDB.Menu;
import tn.biat.biat.entities.otherDB.Tree;
import tn.biat.biat.services.ITreeService;

import java.util.List;

@RestController
@RequestMapping("/tree")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class TreeController {

    @Autowired
    ITreeService iTreeService;


    @GetMapping("/agencesByZone/{idUser}")
    public ResponseEntity<List<String>> AgencesByZone(@PathVariable("idUser") Long idUser){
        return ResponseEntity.status(HttpStatus.OK).body(
                iTreeService.getAgenceByZone(idUser)
        );
    }

    @GetMapping("/agencesByRegion/{idUser}")
    public ResponseEntity<List<String>> agencesByRegion(@PathVariable("idUser") Long idUser){
        return ResponseEntity.status(HttpStatus.OK).body(
                iTreeService.getAgenceByRegion(idUser)
        );
    }

    @GetMapping("/agencesByPole/{idUser}")
    public ResponseEntity<List<String>> agencesByPole(@PathVariable("idUser") Long idUser){
        return ResponseEntity.status(HttpStatus.OK).body(
                iTreeService.getAgenceByPole(idUser)
        );
    }
}
