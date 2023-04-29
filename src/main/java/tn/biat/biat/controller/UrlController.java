package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.entities.otherDB.Menu;
import tn.biat.biat.entities.otherDB.Url;
import tn.biat.biat.services.IUrlService;

import java.util.List;

@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class UrlController {

    @Autowired
    private IUrlService iUrlService;

    @GetMapping("/showAll")
    public ResponseEntity<List<Url>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iUrlService.getAll()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Url> add(@RequestBody Url url){
        Url u = iUrlService.add(url);
        return ResponseEntity.status(HttpStatus.OK).body(
                u
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Url> modify(@RequestBody Url url, @PathVariable("id") Long id){
        Url u = iUrlService.modify(url, id);
        if(url == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                u
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Url> get(@PathVariable("id") Long id){
        Url url = iUrlService.get(id);
        if(url == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                url
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
        boolean b = iUrlService.delete(id);
        if(!b){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    false
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                true
        );
    }

    @GetMapping("/getUrlByUrl/{url}")
    public ResponseEntity<Boolean> getUrlByUrl(@PathVariable("url") String url){
        boolean b = iUrlService.getUrlByUrl(url);
        if(!b){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    false
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                true
        );
    }
}
