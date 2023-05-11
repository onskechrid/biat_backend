package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.services.IChartService;

import java.util.List;

@RestController
@RequestMapping("/chart")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")

public class ChartController {

    @Autowired
    IChartService iChartService;

    @GetMapping("/getCategories/{unite}")
    public ResponseEntity<List<String>> getCategories(@PathVariable("unite") String unite){
        return ResponseEntity.status(HttpStatus.OK).body(
                iChartService.getCategories(unite)
        );
    }


    @GetMapping("/getSeries/{unite}")
    public ResponseEntity<List<Double>> getSeries(@PathVariable("unite") String unite){
        return ResponseEntity.status(HttpStatus.OK).body(
                iChartService.getSeries(unite)
        );
    }

    @GetMapping("/getDetails/{unite}/{engG}")
    public ResponseEntity<List<Double>> getDetails(@PathVariable("unite") String unite, @PathVariable("engG") String engGlobal){
        return ResponseEntity.status(HttpStatus.OK).body(
                iChartService.getDetails(unite, engGlobal)
        );
    }

    @GetMapping("/getEngGByPeriod/{unite}/{p}")
    public ResponseEntity<Double> getEngGByPeriod(@PathVariable("unite") String unite , @PathVariable("p") String p){
        return ResponseEntity.status(HttpStatus.OK).body(
                iChartService.getEngGByPeriod(unite,p)
        );
    }

    @GetMapping("/getTauxDeRenvPCG/{unite}")
    public ResponseEntity<List<Double>> getTauxDeRenvPCG(@PathVariable("unite") String unite){
        return ResponseEntity.status(HttpStatus.OK).body(
                iChartService.getTauxDeRenvPCG(unite)
        );
    }

    @GetMapping("/getTauxDeSaisieDeBilan/{unite}")
    public ResponseEntity<List<Double>> getTauxDeSaisieDeBilan(@PathVariable("unite") String unite){
        return ResponseEntity.status(HttpStatus.OK).body(
                iChartService.getTauxDeSaisieDeBilan(unite)
        );
    }

    @GetMapping("/getTauxCDL/{unite}")
    public ResponseEntity<List<Double>> getTauxCDL(@PathVariable("unite") String unite){
        return ResponseEntity.status(HttpStatus.OK).body(
                iChartService.getTauxCDL(unite)
        );
    }


    @GetMapping("/getTauxGenerationCDL/{unite}")
    public ResponseEntity<List<Double>> getTauxGenerationCDL(@PathVariable("unite") String unite){
        return ResponseEntity.status(HttpStatus.OK).body(
                iChartService.getTauxGenerationCDL(unite)
        );
    }

    @GetMapping("/getTauxGenerationCreditParticuliers/{unite}")
    public ResponseEntity<List<Double>> getTauxGenerationCreditParticuliers(@PathVariable("unite") String unite){
        return ResponseEntity.status(HttpStatus.OK).body(
                iChartService.getTauxGenerationCreditParticuliers(unite)
        );
    }

}
