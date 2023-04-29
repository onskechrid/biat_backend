package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.entities.otherDB.Menu;
import tn.biat.biat.entities.otherDB.Permissions;
import tn.biat.biat.entities.otherDB.Profile;
import tn.biat.biat.services.IProfilesService;

import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ProfilesController {

    @Autowired
    private IProfilesService iProfilesService;

    @GetMapping("/showAll")
    public ResponseEntity<List<Profile>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iProfilesService.getAll()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Profile> add(@RequestBody Profile profile){
        Profile p = iProfilesService.add(profile);
        return ResponseEntity.status(HttpStatus.OK).body(
                p
        );
    }

    @GetMapping("/getByProfileType/{pt}")
    public ResponseEntity<Profile> getByProfileType(@PathVariable("pt") String pt){
        return ResponseEntity.status(HttpStatus.OK).body(
                iProfilesService.getByProfileType(pt)
        );
    }

    @GetMapping("/getAllProfilePermissions/{id}")
    public ResponseEntity<List<Permissions>> getAllProfilePermissions(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(
                iProfilesService.getAllProfilePermissions(id)
        );
    }

    @GetMapping("/getAllProfilePermissionsByProfiletype/{pt}")
    public ResponseEntity<List<Permissions>> getAllProfilePermissionsByProfiletype(@PathVariable("pt") String pt){
        return ResponseEntity.status(HttpStatus.OK).body(
                iProfilesService.getAllProfilePermissionsByProfiletype(pt)
        );
    }

    @GetMapping("/getAllCheckedProfilePermissionsByProfiletype/{pt}")
    public ResponseEntity<List<Menu>> getAllCheckedProfilePermissionsByProfiletype(@PathVariable("pt") String pt){
        return ResponseEntity.status(HttpStatus.OK).body(
                iProfilesService.getAllCheckedProfilePermissionsByProfiletype(pt)
        );
    }


    @GetMapping("/updateProfilePermissions/{profileType}/{idmenu}")
    public ResponseEntity<Boolean> updateProfilePermissions(@PathVariable("profileType") String profileType, @PathVariable("idmenu") Long idmenu){
        return ResponseEntity.status(HttpStatus.OK).body(
                iProfilesService.updateProfilePermissions(profileType, idmenu)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
        boolean b = iProfilesService.delete(id);
        if(!b){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    false
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                true
        );
    }



    @GetMapping("/deletePermission/{pt}/{idmenu}")
    public ResponseEntity<Boolean> deletePermission(@PathVariable("pt") String pt, @PathVariable("idmenu") Long idmenu){
        boolean b = iProfilesService.deletePermission(pt,idmenu);
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }

}
