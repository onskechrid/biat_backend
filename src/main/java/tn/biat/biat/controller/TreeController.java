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

    @GetMapping("/getExtensions/{pt}/{value}")
    public ResponseEntity<List<String>> getExtensions(@PathVariable("pt") String pt, @PathVariable("value") String value){
        return ResponseEntity.status(HttpStatus.OK).body(
                iTreeService.getExtensions(pt,value)
        );
    }

    @GetMapping("/agencesByZoneAndLabel/{label}")
    public ResponseEntity<List<String>> AgencesByZoneAndLabel(@PathVariable("label") String label){
        return ResponseEntity.status(HttpStatus.OK).body(
                iTreeService.getAgenceByZoneAndLabel(label)
        );
    }

    @GetMapping("/agencesByRegionAndLabel/{label}")
    public ResponseEntity<List<String>> agencesByRegionAndLabel(@PathVariable("label") String label){
        return ResponseEntity.status(HttpStatus.OK).body(
                iTreeService.getAgenceByRegionAndLabel(label)
        );
    }

    @GetMapping("/agencesByPoleAndLabel/{label}")
    public ResponseEntity<List<String>> agencesByPoleAndLabel(@PathVariable("label") String label){
        return ResponseEntity.status(HttpStatus.OK).body(
                iTreeService.getAgenceByPoleAndLabel(label)
        );
    }


    @GetMapping("/getAllAgences")
    public ResponseEntity<List<String>> getAllAgences(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iTreeService.getAllAgences()
        );
    }
    @GetMapping("/getAllZones")
    public ResponseEntity<List<String>> getAllZones(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iTreeService.getAllZones()
        );
    }
    @GetMapping("/getAllRegions")
    public ResponseEntity<List<String>> getAllRegions(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iTreeService.getAllRegions()
        );
    }
    @GetMapping("/getAllPoles")
    public ResponseEntity<List<String>> getAllPoles(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iTreeService.getAllPoles()
        );
    }

}
