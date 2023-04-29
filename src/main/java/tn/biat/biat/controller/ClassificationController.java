package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.entities.otherDB.Classification;
import tn.biat.biat.entities.otherDB.Client;
import tn.biat.biat.services.IClassificationService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/classification")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ClassificationController {

    @Autowired
    IClassificationService iClassificationService;


    @GetMapping("/getClientByCompte/{cpte}")
    public ResponseEntity<Client> getClientByCompte(@PathVariable("cpte") String cpte){
        return ResponseEntity.status(HttpStatus.OK).body(
                iClassificationService.getClientByCompte(cpte)
        );
    }

    @PostMapping("/add/{cpte}")
    public ResponseEntity<Classification> add(@RequestBody Classification classification, @PathVariable("cpte") String cpte){
        return ResponseEntity.status(HttpStatus.OK).body(
                iClassificationService.add(classification,cpte)
        );
    }

    @GetMapping("/updateClassificationAttachements/{id}/{name}/{size}/{type}/{url}")
    public ResponseEntity<Boolean> updateReclamationAttachements(@PathVariable("id") Long id, @PathVariable("name") String name, @PathVariable("size") String size, @PathVariable("type") String type,@PathVariable("url") String url){
        return ResponseEntity.status(HttpStatus.OK).body(
                iClassificationService.updateClassificationAttachements(id,name,size,type,url)
        );
    }

    @GetMapping("/getClassificationByClientaccount/{account}")
    public ResponseEntity<Classification> getClassificationByClientaccount(@PathVariable("account") String account){
        return ResponseEntity.status(HttpStatus.OK).body(
                iClassificationService.getClassificationByClientaccount(account)
        );
    }

    @GetMapping("/isDeposited/{account}")
    public ResponseEntity<Boolean> isDeposited(@PathVariable("account") String account){
        return ResponseEntity.status(HttpStatus.OK).body(
                iClassificationService.isDeposited(account)
        );
    }

    @GetMapping("/getClient/{account}")
    public ResponseEntity<Client> getClient(@PathVariable("account") String account){
        return ResponseEntity.status(HttpStatus.OK).body(
                iClassificationService.getClient(account)
        );
    }

    @GetMapping("/updateClassification/{account}/{motif}/{decision}/{classe}")
    public ResponseEntity<Boolean> updateClassification(@PathVariable("account") String account,@PathVariable("motif") String motif,@PathVariable("decision") String decision,@PathVariable("classe") Integer classe){
        return ResponseEntity.status(HttpStatus.OK).body(
                iClassificationService.updateClassification(account,motif,decision,classe)
        );
    }

    @PostMapping("/getByIds")
    public ResponseEntity<Map<String, Integer>> getClassificationByIds(@RequestBody() List<String> list){
        return ResponseEntity.status(HttpStatus.OK).body(
                iClassificationService.getClassificationByIds(list)
        );
    }

}
