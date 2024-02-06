package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.entities.otherDB.Function;
import tn.biat.biat.services.IFunctionService;
import tn.biat.biat.utils.QueryExecutor;

import java.util.List;

@RestController
@RequestMapping("/functions")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class FunctionController {

    @Autowired
    private IFunctionService iFunctionService;
    @Autowired
    QueryExecutor queryExecutor;

    @GetMapping("/showAll")
    public ResponseEntity<List<Function>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iFunctionService.getAll()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Function> add(@RequestBody Function function){
        Function fun = iFunctionService.add(function);
        return ResponseEntity.status(HttpStatus.OK).body(
                fun
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Function> modify(@RequestBody Function function, @PathVariable("id") Long id){
        Function f = iFunctionService.modify(function, id);
        if(function == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                f
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Function> get(@PathVariable("id") Long id){
        Function function = iFunctionService.get(id);
        if(function == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                function
        );
    }

    @PostMapping("/query/{id}")
    public ResponseEntity<Boolean> get_query(@PathVariable("id") Long id){
        boolean b = iFunctionService.get_query(id);
        if(!b){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    false
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                true
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
        boolean b = iFunctionService.delete(id);
        if(!b){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    false
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                true
        );
    }

    @GetMapping("/nbrwrongfunctions")
    public ResponseEntity<Number> getNbrWrongFunctions(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iFunctionService.getNbrWrongFunctions()
        );
    }

    @GetMapping("/update_fn_status/{id}/{update}")
    public ResponseEntity<Boolean> updateFnStatus(@PathVariable("id") Long id,@PathVariable("update") int update){
        Boolean f = iFunctionService.updateFnStatus(id, update);
        return ResponseEntity.status(HttpStatus.OK).body(
                f
        );
    }

    @GetMapping("/query/{queryinput}")
    public ResponseEntity<JSONArray> queryinput(@PathVariable("queryinput") String QUERY){
        return ResponseEntity.status(HttpStatus.OK).body(
            queryExecutor.queryinput(QUERY)
        );
    }
    @GetMapping("/query/match/{syl}")
    public ResponseEntity<List<String>> matchword(@PathVariable("syl") String word){
        return ResponseEntity.status(HttpStatus.OK).body(
                iFunctionService.getTableAndColumnNames(word)
        );
    }
}
