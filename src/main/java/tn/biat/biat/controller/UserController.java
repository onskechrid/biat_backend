package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.entities.otherDB.History;
import tn.biat.biat.entities.otherDB.Menu;
import tn.biat.biat.entities.otherDB.User;
import tn.biat.biat.services.implementations.CustomUserDetailsService;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private CustomUserDetailsService userService;

    @GetMapping("/loggedInUser")
    public ResponseEntity<User> getLoggedInUser(){
        User u = userService.getLoggedInUser();
        if(u == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(u);
        }
        return ResponseEntity.ok(u);
    }

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signup(@RequestBody User user){
        boolean r = userService.newUser(user);
        if(r){
            return ResponseEntity.ok(
             true
            );
        }
        return ResponseEntity.ok(
                false
        );
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.getAll()
        );
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.getUserById(id)
        );
    }

    @GetMapping("/updateAfterLogout/{username}")
    public ResponseEntity<User> updateAfterLogout(@PathVariable("username") String username){
        User s = userService.updateAfterLogout(username);
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }

    @GetMapping("/updatelibelle/{id}/{newlibelle}")
    public ResponseEntity<User> updatelibelle(@PathVariable("id") Long id, @PathVariable("newlibelle") String newlibelle){
        User u = userService.updatelibelle(id,newlibelle);
        return ResponseEntity.status(HttpStatus.OK).body(
                u
        );
    }


    @GetMapping("/updateAfterLogin/{username}")
    public ResponseEntity<User> updateAfterLogin(@PathVariable("username") String username){
        User s = userService.updateAfterLogin(username);
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }

    @GetMapping("/updateProfile/{idUser}/{profileType}")
    public ResponseEntity<User> updateProfile(@PathVariable("idUser") Long idUser, @PathVariable("profileType") String profileType){
        User s = userService.updateProfile(idUser,profileType);
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }

    @GetMapping("/getNumberUsers")
    public ResponseEntity<Integer> getNumberUsers(){
        Integer nbU = userService.getNumberUsers();
        return ResponseEntity.status(HttpStatus.OK).body(
                nbU
        );
    }

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.getUserByEmail(email)
        );
    }

    @GetMapping("/updateInitials/{iduser}")
    public ResponseEntity<User> updateInitials(@PathVariable("iduser") Long iduser){
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.updateInitials(iduser)
        );
    }

    @GetMapping("/getUserHistories/{iduser}")
    public ResponseEntity<List<History>> getUserHistories(@PathVariable("iduser") Long iduser){
        List<History> list = userService.getAllUserHistories(iduser);
        return ResponseEntity.status(HttpStatus.OK).body(
                list
        );
    }


}
