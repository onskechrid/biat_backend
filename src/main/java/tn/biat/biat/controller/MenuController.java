package tn.biat.biat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;
import tn.biat.biat.entities.otherDB.Menu;
import tn.biat.biat.services.IMenuService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;

    @GetMapping("/showAll")
    public ResponseEntity<List<Menu>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMenuService.getAll()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Menu> add(@RequestBody Menu menu){
        Menu m = iMenuService.add(menu);
        return ResponseEntity.status(HttpStatus.OK).body(
                m
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> modify(@RequestBody Menu menu, @PathVariable("id") Long id){
        Menu s = iMenuService.modify(menu, id);
        if(menu == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Menu> get(@PathVariable("id") Long id){
        Menu menu = iMenuService.get(id);
        if(menu == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    null
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                menu
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
        boolean b = iMenuService.delete(id);
        if(!b){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    false
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                true
        );
    }

    @GetMapping("/AllCheckedMenus")
    public ResponseEntity<List<Menu>> getAllCheckedMenus(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMenuService.getAllCheckedMenus()
        );
    }

    @GetMapping("/getAllFirstLevelMenus")
    public ResponseEntity<List<Menu>> getAllFirstLevelMenus(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMenuService.getAllFirstLevelMenus()
        );
    }


    @GetMapping("/updatecheckedstatus/{id}/{check}")
    public ResponseEntity<Menu> updatecheckedstatus(@PathVariable("id") Long id , @PathVariable("check") boolean check){
        Menu s = iMenuService.updatecheckedstatus(id,check);
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }

    @GetMapping("/updateactivestatus/{id}/{active}")
    public ResponseEntity<Menu> updateactivestatus(@PathVariable("id") Long id,@PathVariable("active") boolean active){
        Menu s = iMenuService.updateactivestatus(id,active);
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }

    @GetMapping("/updatelevelandidp/{id}/{newidparent}")
    public ResponseEntity<Menu> updatelevel(@PathVariable("id") Long id, @PathVariable("newidparent") Long newidparent){
        Menu s = iMenuService.updatelevelandidp(id,newidparent);
        return ResponseEntity.status(HttpStatus.OK).body(
                s
        );
    }


    @GetMapping("/updateicon/{id}/{icon}")
    public ResponseEntity<Menu> updateicon(@PathVariable("id") Long id, @PathVariable("icon") String icon){
        Menu m = iMenuService.updateicon(icon,id);
        return ResponseEntity.status(HttpStatus.OK).body(
                m
        );
    }

    @GetMapping("/updatename/{id}/{newname}")
    public ResponseEntity<Menu> updatename(@PathVariable("id") Long id, @PathVariable("newname") String newname){
        Menu m = iMenuService.updatename(newname,id);
        return ResponseEntity.status(HttpStatus.OK).body(
                m
        );
    }

    @GetMapping("/updateurl/{idmenu}/{idnewurl}")
    public ResponseEntity<Menu> updateurl(@PathVariable("idmenu") Long idmenu, @PathVariable("idnewurl") Long idnewurl){
        Menu m = iMenuService.updateurl(idmenu,idnewurl);
        return ResponseEntity.status(HttpStatus.OK).body(
                m
        );
    }


    @GetMapping("/getlistbyidandlevel/{id}/{level}")
    public ResponseEntity<List<Menu>> getlistbyidandlevel (@PathVariable("id") Long id, @PathVariable("level") int level){
        List<Menu> list = iMenuService.getlistbyidandlevel(id,level);
        return ResponseEntity.status(HttpStatus.OK).body(
                list
        );
    }

    @GetMapping("/getidparent/{id}")
    public ResponseEntity<Long> getidparent (@PathVariable("id") Long id){
        Long l = iMenuService.getidparent(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                l
        );
    }

    @GetMapping("/getid/{idparent}")
    public ResponseEntity<List<Menu>> getid (@PathVariable("idparent") Long idparent){
        List<Menu> l = iMenuService.getid(idparent);
        return ResponseEntity.status(HttpStatus.OK).body(
                l
        );
    }

    @GetMapping("/gettreeminayylevel/{idd}")
    public ResponseEntity<List> gettreeminayylevel(@PathVariable("idd") Long idd){
        List list = iMenuService.gettreeminayylevel(idd);
        return ResponseEntity.status(HttpStatus.OK).body(
                list
        );
    }

    @GetMapping("/gettreeminlevel1")
    public ResponseEntity<List> gettreeminlevel1(){
        List list = iMenuService.gettreeminlevel1();
        return ResponseEntity.status(HttpStatus.OK).body(
                list
        );
    }

    @GetMapping("/getMenuByName/{name}")
    public ResponseEntity<Menu> getMenuByName(@PathVariable("name") String name){
        Menu menu = iMenuService.getMenuByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(
                menu
        );
    }

    @GetMapping("/updateMenuComposants/{menuname}/{title}/{description}/{query}")
    public ResponseEntity<Boolean> updateMenuComposants(@PathVariable("menuname") String menuname, @PathVariable("title") String title, @PathVariable("description") String description, @PathVariable("query") String query){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMenuService.updateMenuComposants(menuname,title,description,query)
        );
    }

    @GetMapping("/deleteComposant/{idcomposant}")
    public ResponseEntity<Boolean> deleteComposant(@PathVariable("idcomposant") Long idcomposant){
        boolean b = iMenuService.deleteComposant(idcomposant);
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }
}
