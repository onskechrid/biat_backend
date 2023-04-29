package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.entities.E_CUSTOMER;
import tn.biat.biat.services.IEcustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Slf4j
public class EcustomerController {

    @Autowired
    private IEcustomerService iecustomerService;

    @GetMapping("/showAll")
    public ResponseEntity<List<E_CUSTOMER>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iecustomerService.getAll()
        );
    }

}
