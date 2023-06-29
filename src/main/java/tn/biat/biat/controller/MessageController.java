package tn.biat.biat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.biat.biat.entities.otherDB.Client;
import tn.biat.biat.entities.otherDB.Message;
import tn.biat.biat.services.IMessageService;
import tn.biat.biat.services.QueryDto;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    @Autowired
    private IMessageService iMessageService;

    @GetMapping("/showAll")
    public ResponseEntity<List<Message>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getAll()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Message> add(@RequestBody Message message){
        Message m = iMessageService.add(message);
        return ResponseEntity.status(HttpStatus.OK).body(
                m
        );
    }

    @GetMapping("/updateReclamationAttachements/{id}/{name}/{size}/{type}/{url}")
    public ResponseEntity<Boolean> updateReclamationAttachements(@PathVariable("id") Long id, @PathVariable("name") String name, @PathVariable("size") String size, @PathVariable("type") String type,@PathVariable("url") String url){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.updateReclamationAttachements(id,name,size,type,url)
        );
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(
          iMessageService.getById(id)
        );
    }

    @GetMapping("/updateProcessStatus/{id}/{newStatus}")
    public ResponseEntity<Boolean> updateProcessStatus(@PathVariable("id") Long id, @PathVariable("newStatus") String newStatus){
        boolean b = iMessageService.updateProcessStatus(id,newStatus);
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }

    @GetMapping("/updateStatus/{id}/{newStatus}")
    public ResponseEntity<Boolean> updateStatus(@PathVariable("id") Long id, @PathVariable("newStatus") String newStatus){
        boolean b = iMessageService.updateStatus(id,newStatus);
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }

    @GetMapping("/updateMotifAndClasse/{id}/{motif}/{classe}")
    public ResponseEntity<Boolean> updateMotifAndClasse(@PathVariable("id") Long id, @PathVariable("motif") String motif, @PathVariable("classe") Integer classe){
        boolean b = iMessageService.updateMotifAndClasse(id,motif,classe);
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }

    @GetMapping("/updateText/{id}/{newText}")
    public ResponseEntity<Boolean> updateText(@PathVariable("id") Long id, @PathVariable("newText") String newText){
        boolean b = iMessageService.updateText(id,newText);
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }

    @GetMapping("/numberUntreatedMessages")
    public ResponseEntity<Integer> numberUntreatedMessages(){
        return ResponseEntity.status(HttpStatus.OK).body(
          iMessageService.numberUntreatedMessages()
        );
    }

    @GetMapping("/numberTreatedMessages")
    public ResponseEntity<Integer> numberTreatedMessages(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.numberTreatedMessages()
        );
    }

    @GetMapping("/numberRefusedReclamations")
    public ResponseEntity<Integer> numberRefusedReclamations(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.numberRefusedReclamations()
        );
    }

    @GetMapping("/numberMIReclamations")
    public ResponseEntity<Integer> numberMIReclamations(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.numberMIReclamations()
        );
    }

    @GetMapping("/untreatedReclamations")
    public ResponseEntity<List<Message>> untreatedReclamations(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.untreatedReclamations()
        );
    }

    @GetMapping("/treatedReclamations")
    public ResponseEntity<List<Message>> treatedReclamations(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.treatedReclamations()
        );
    }

    @GetMapping("/refusedReclamations")
    public ResponseEntity<List<Message>> refusedReclamations(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.refusedReclamations()
        );
    }

    @GetMapping("/miReclamations")
    public ResponseEntity<List<Message>> miReclamations(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.miReclamations()
        );
    }


    @GetMapping("/getMessagesForChat/{id}")
    public ResponseEntity<List<Long>> getMessagesForChat(@PathVariable("id") Long id){
        List<Long> list = iMessageService.getMessagesForChat(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                list
        );
    }

    @GetMapping("/getResponseMessage/{id}")
    public ResponseEntity<Message> getResponseMessage(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getResponseMessage(id)
        );
    }

    @GetMapping("/getTopLevelMessages")
    public ResponseEntity<List<Message>> getTopLevelMessages(){
        List<Message> list = iMessageService.getTopLevelMessages();
        return ResponseEntity.status(HttpStatus.OK).body(
                list
        );
    }

    @GetMapping("/getMessageChain/{id}")
    public ResponseEntity<List<Long>> getMessageChain(@PathVariable("id") Long id){
        List<Long> list = iMessageService.getMessageChain(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                list
        );
    }

    ////////////////////////////////////// CLASSIFICATION

    @PostMapping("/getByIds")
    public ResponseEntity<Map<String, Integer>> getClassificationByIds(@RequestBody() List<String> list){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getClassificationByIds(list)
        );
    }

    @PostMapping("/getByIds2")
    public ResponseEntity<Map<String, String>> getClassificationByIds2(@RequestBody() List<String> list){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getClassificationByIds2(list)
        );
    }

    @PostMapping("/getByIds3")
    public ResponseEntity<Map<String, String>> getClassificationByIds3(@RequestBody() List<String> list){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getClassificationByIds3(list)
        );
    }



    @GetMapping("/getClassifiedClientsNumber")
    public ResponseEntity<Integer> getClassifiedClientsNumber(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getClassifiedClientsNumber()
        );
    }

    @GetMapping("/getEnattenteClientsNumber")
    public ResponseEntity<Integer> getEnattenteClientsNumber(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getEnattenteClientsNumber()
        );
    }

    @GetMapping("/getDeposeClientsNumber")
    public ResponseEntity<Integer> getDeposeClientsNumber(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getDeposeClientsNumber()
        );
    }


    @GetMapping("/getRefuseeClientsNumber")
    public ResponseEntity<Integer> getRefuseeClientsNumber(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getRefuseeClientsNumber()
        );
    }

    @GetMapping("/getMessageBYCompteClient/{account}")
    public ResponseEntity<Message> getMessageBYCompteClient(@PathVariable("account") String account){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getMessageBYCompteClient(account)
        );
    }

    @GetMapping("/getClientByAccount/{account}")
    public ResponseEntity<Client> getClientByAccount(@PathVariable("account") String account){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getClientByAccount(account)
        );
    }

    @GetMapping("/getFilteredQuery/{iduser}/{p}/{s}/{all}")
    public ResponseEntity<QueryDto> getFilteredQuery(@PathVariable("iduser") Long iduser, @PathVariable("p") String processStatus, @PathVariable("s") String status , @PathVariable("all") String all){

        QueryDto qq = new QueryDto();
        qq.query = iMessageService.getFilteredQuery(iduser,processStatus,status,all);
        return ResponseEntity.status(HttpStatus.OK).body(
                qq
        );
    }

    @GetMapping("/getFilteredQuery2/{iduser}/{a}/{z}/{r}/{p}")
    public ResponseEntity<QueryDto> getFilteredQuery2(@PathVariable("iduser") Long iduser,@PathVariable("a") String agence, @PathVariable("z") String zone, @PathVariable("r") String region, @PathVariable("p") String pole){
        QueryDto qq = new QueryDto();
        qq.query = iMessageService.getFilteredQuery2(iduser, agence,zone, region, pole);
        return ResponseEntity.status(HttpStatus.OK).body(
                qq
        );
    }

    @GetMapping("/getPeriode/{cpte}")
    public ResponseEntity<String> getPeriode(@PathVariable("cpte") String cpte){
        String j = iMessageService.getPeriode(cpte);
        return ResponseEntity.status(HttpStatus.OK).body(
                j
        );
    }

    @GetMapping("/getNumberJoursTotal")
    public ResponseEntity<String> getNumberJoursTotal(){
        String j = iMessageService.getNumberJoursTotal();
        return ResponseEntity.status(HttpStatus.OK).body(
                j
        );
    }

    @GetMapping("/pp/{id}")
    public ResponseEntity<List<String>> pp(@PathVariable("id") Long id){
        List<String> j = iMessageService.getPaiementPrincipal(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                j
        );
    }

    @GetMapping("/getAgiosByDate/{p}/{date}")
    public ResponseEntity<String> getAgiosByDate(@PathVariable("p") String periode, @PathVariable("date") String date){
        String j = iMessageService.getAgiosByDate(periode,date);
        return ResponseEntity.status(HttpStatus.OK).body(
                j
        );
    }

    @GetMapping("/cla/{id}")
    public ResponseEntity<Boolean> classificationAutomatique(@PathVariable("id") Long id){
        boolean b = iMessageService.classificationAutomatique(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }



}
