package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.entities.otherDB.Permissions;
import tn.biat.biat.services.IPermissionsService;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class PermissionsController {

    @Autowired
    IPermissionsService iPermissionsService;


    @GetMapping("/getPermissionsByMenuId/{idmenu}")
    public ResponseEntity<List<Permissions>> getByMenuId(@PathVariable("idmenu") Long idmenu){
        List<Permissions> b = iPermissionsService.getByMenuId(idmenu);
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }


    @GetMapping("/delete/{idmenu}")
    public ResponseEntity<Boolean> delete(@PathVariable("idmenu") Long idmenu){
        Boolean b = iPermissionsService.delete(idmenu);
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }

}
