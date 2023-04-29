package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.services.IFilterService;

import java.util.List;

@RestController
@RequestMapping("/filter")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class FilterController {

    @Autowired
    private IFilterService iFilterService;


    @GetMapping("/alldatsit")
    public ResponseEntity<List> alldatsit(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iFilterService.alldatsit()
        );
    }

    @GetMapping("/total/{id}/{datsit}")
    public ResponseEntity<String> total(@PathVariable("id") String id, @PathVariable("datsit") Number datsit){
        String total = iFilterService.total(id,datsit);
        if(total == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                total
        );
    }

    //idcustomer

    @GetMapping("/nameidcustomer/{idcustomer}")
    public ResponseEntity<String> nameidcustomer(@PathVariable("idcustomer") String idcustomer){
        String s = iFilterService.NAMEidcustomer(idcustomer);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/idbctidcustomer/{idcustomer}")
    public ResponseEntity<String> IDBCTidcustomer(@PathVariable("idcustomer") String idcustomer){
        String s = iFilterService.IDBCTidcustomer(idcustomer);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/liblidcustomer/{idcustomer}")
    public ResponseEntity<String> LIBLidcustomer(@PathVariable("idcustomer") String idcustomer){
        String s = iFilterService.LIBLidcustomer(idcustomer);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }

    //idbct

    @GetMapping("/liblidbct/{idbct}")
    public ResponseEntity<String> LIBLidbct(@PathVariable("idbct") String idbct){
        String s = iFilterService.LIBLidbct(idbct);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/nameidbct/{idbct}")
    public ResponseEntity<String> NAMEidbct(@PathVariable("idbct") String idbct){
        String s = iFilterService.NAMEidbct(idbct);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/ididbct/{idbct}")
    public ResponseEntity<String> IDidbct(@PathVariable("idbct") String idbct){
        String s = iFilterService.IDidbct(idbct);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }

    //comp
    @GetMapping("/idcomp/{comp}")
    public ResponseEntity<String> IDcomp(@PathVariable("comp") String comp){
        String s = iFilterService.IDcomp(comp);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/idbctcomp/{comp}")
    public ResponseEntity<String> IDBCTcomp(@PathVariable("comp") String comp){
        String s = iFilterService.IDBCTcomp(comp);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/namecomp/{comp}")
    public ResponseEntity<String> NAMEcomp(@PathVariable("comp") String comp){
        String s = iFilterService.NAMEcomp(comp);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/liblcomp/{comp}")
    public ResponseEntity<String> LIBLcomp(@PathVariable("comp") String comp){
        String s = iFilterService.LIBLcomp(comp);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }

    //refcrdt
    @GetMapping("/idrefcrdt/{refcrdt}")
    public ResponseEntity<String> IDrefcrdt(@PathVariable("refcrdt") String refcrdt){
        String s = iFilterService.IDrefcrdt(refcrdt);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/idbctrefcrdt/{refcrdt}")
    public ResponseEntity<String> IDBCTrefcrdt(@PathVariable("refcrdt") String refcrdt){
        String s = iFilterService.IDBCTrefcrdt(refcrdt);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/NAMErefcrdt/{refcrdt}")
    public ResponseEntity<String> NAMErefcrdt(@PathVariable("refcrdt") String refcrdt){
        String s = iFilterService.NAMErefcrdt(refcrdt);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/LIBLrefcrdt/{refcrdt}")
    public ResponseEntity<String> LIBLrefcrdt(@PathVariable("refcrdt") String refcrdt){
        String s = iFilterService.LIBLrefcrdt(refcrdt);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }

}
