package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.entities.otherDB.Composant;
import tn.biat.biat.services.IComposantService;

import java.util.List;

@RestController
@RequestMapping("/composant")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ComposantController {

    @Autowired
    private IComposantService iComposantService;

    @GetMapping("/showAll")
    public ResponseEntity<List<Composant>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iComposantService.getAll()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Composant> add(@RequestBody Composant composant){
        Composant c = iComposantService.add(composant);
        return ResponseEntity.status(HttpStatus.OK).body(
                c
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Composant> get(@PathVariable("id") Long id){
        Composant composant = iComposantService.get(id);
        if(composant == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                composant
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
        boolean b = iComposantService.delete(id);
        if(!b){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    false
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                true
        );
    }

    @GetMapping("/apply/{query}")
    public ResponseEntity<JSONArray> apply(@PathVariable("query") String query){
        return ResponseEntity.status(HttpStatus.OK).body(
                iComposantService.apply(query)
        );
    }

    @GetMapping("/applycomposantquery/{query}/{iduser}")
    public ResponseEntity<JSONArray> applycomposantquery(@PathVariable("query") String query,@PathVariable("iduser") Long iduser){
        return ResponseEntity.status(HttpStatus.OK).body(
                iComposantService.applycomposantquery(query,iduser)
        );
    }

}
