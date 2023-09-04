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
import tn.biat.biat.services.StringDto;

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

    @GetMapping("/valider/{id}")
    public ResponseEntity<Boolean> valider(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.valider(id)
        );
    }

    @GetMapping("/refuser/{id}")
    public ResponseEntity<Boolean> refuser(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.refuser(id)
        );
    }

    @GetMapping("/ci/{id}")
    public ResponseEntity<Boolean> ci(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.ci(id)
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



    @GetMapping("/getClassifiedClientsNumberRR/{libelle}")
    public ResponseEntity<Integer> getClassifiedClientsNumberRR(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getClassifiedClientsNumberRR(libelle)
        );
    }
    @GetMapping("/getClassifiedClientsNumberAgence/{libelle}")
    public ResponseEntity<Integer> getClassifiedClientsNumberAgence(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getClassifiedClientsNumberAgence(libelle)
        );
    }
    @GetMapping("/getClassifiedClientsNumberZone/{libelle}")
    public ResponseEntity<Integer> getClassifiedClientsNumberZone(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getClassifiedClientsNumberZone(libelle)
        );
    }
    @GetMapping("/getClassifiedClientsNumberPole/{libelle}")
    public ResponseEntity<Integer> getClassifiedClientsNumberPole(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getClassifiedClientsNumberPole(libelle)
        );
    }
    @GetMapping("/getClassifiedClientsNumberRegion/{libelle}")
    public ResponseEntity<Integer> getClassifiedClientsNumberRegion(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getClassifiedClientsNumberRegion(libelle)
        );
    }


    @GetMapping("/getEnattenteClientsNumberRR")
    public ResponseEntity<Integer> getEnattenteClientsNumberRR(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getEnattenteClientsNumberRR()
        );
    }
    @GetMapping("/getEnattenteClientsNumberR/{libelle}")
    public ResponseEntity<Integer> getEnattenteClientsNumberR(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getEnattenteClientsNumberR(libelle)
        );
    }
    @GetMapping("/getEnattenteClientsNumberZ/{libelle}")
    public ResponseEntity<Integer> getEnattenteClientsNumberZ(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getEnattenteClientsNumberZ(libelle)
        );
    }
    @GetMapping("/getEnattenteClientsNumberP/{libelle}")
    public ResponseEntity<Integer> getEnattenteClientsNumberP(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getEnattenteClientsNumberP(libelle)
        );
    }
    @GetMapping("/getEnattenteClientsNumberA/{libelle}")
    public ResponseEntity<Integer> getEnattenteClientsNumberA(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getEnattenteClientsNumberA(libelle)
        );
    }

    @GetMapping("/getDeposeClientsNumber")
    public ResponseEntity<Integer> getDeposeClientsNumber(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getDeposeClientsNumber()
        );
    }

    @GetMapping("/getPreValidationCLientsNumberRR")
    public ResponseEntity<Integer> getPreValidationCLientsNumberRR(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getPreValidationCLientsNumberRR()
        );
    }
    @GetMapping("/getPreValidationCLientsNumberA/{libelle}")
    public ResponseEntity<Integer> getPreValidationCLientsNumberA(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getPreValidationCLientsNumberA(libelle)
        );
    }
    @GetMapping("/getPreValidationCLientsNumberR/{libelle}")
    public ResponseEntity<Integer> getPreValidationCLientsNumberR(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getPreValidationCLientsNumberR(libelle)
        );
    }
    @GetMapping("/getPreValidationCLientsNumberZ/{libelle}")
    public ResponseEntity<Integer> getPreValidationCLientsNumberZ(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getPreValidationCLientsNumberZ(libelle)
        );
    }
    @GetMapping("/getPreValidationCLientsNumberP/{libelle}")
    public ResponseEntity<Integer> getPreValidationCLientsNumberP(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getPreValidationCLientsNumberP(libelle)
        );
    }




    @GetMapping("/getRefuseeClientsNumberRR")
    public ResponseEntity<Integer> getRefuseeClientsNumberRR(){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getRefuseeClientsNumberRR()
        );
    }
    @GetMapping("/getRefuseeClientsNumberZ/{libelle}")
    public ResponseEntity<Integer> getRefuseeClientsNumberZ(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getRefuseeClientsNumberZ(libelle)
        );
    }
    @GetMapping("/getRefuseeClientsNumberP/{pp}/{libelle}")
    public ResponseEntity<Integer> getRefuseeClientsNumberP(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getRefuseeClientsNumberP(libelle)
        );
    }
    @GetMapping("/getRefuseeClientsNumberR/{libelle}")
    public ResponseEntity<Integer> getRefuseeClientsNumberR(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getRefuseeClientsNumberR(libelle)
        );
    }
    @GetMapping("/getRefuseeClientsNumberA/{libelle}")
    public ResponseEntity<Integer> getRefuseeClientsNumberA(@PathVariable("libelle") String libelle){
        return ResponseEntity.status(HttpStatus.OK).body(
                iMessageService.getRefuseeClientsNumberA(libelle)
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

    @GetMapping("/totalAgios/{id}/{periode}")
    public ResponseEntity<Integer> getTotalAgios(@PathVariable("id") Long id,@PathVariable("periode") String periode){
        Integer ta = iMessageService.getTotalAgios(id,periode.replace("-","/"));
        return ResponseEntity.status(HttpStatus.OK).body(ta);
    }

    @GetMapping("/getSolde/{cpte}")
    public ResponseEntity<String> getSolde(@PathVariable("cpte") String cpte){
        String s = iMessageService.getSolde(cpte);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    @GetMapping("/getMvt/{solde}/{sf}")
    public ResponseEntity<Double> getMvt(@PathVariable("solde") String solde, @PathVariable("sf") String sf){
        Double s = iMessageService.getMvt(solde,sf);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    @GetMapping("/getGelTable/{cpte}")
    public ResponseEntity<JSONArray> getGelTable(@PathVariable("cpte") String cpte){
        JSONArray j = iMessageService.getGelTable(cpte);
        return ResponseEntity.status(HttpStatus.OK).body(j);
    }

    @GetMapping("/getListAgiosG/{cpte}")
    public ResponseEntity<List<String>> getListAgiosG(@PathVariable("cpte") String cpte){
        List<String> j = iMessageService.getListAgiosG(cpte);
        return ResponseEntity.status(HttpStatus.OK).body(j);
    }

    @GetMapping("/getAgiosByDate/{p}/{date}")
    public ResponseEntity<StringDto> getAgiosByDate(@PathVariable("p") String periode, @PathVariable("date") String date){
        StringDto qq = new StringDto();
        qq.string = iMessageService.getAgiosByDate(periode.replace("-","/"),date.replace("-","/"));
        return ResponseEntity.status(HttpStatus.OK).body(
                qq
        );
    }

    @GetMapping("/getmotif/{account}")
    public ResponseEntity<StringDto> getMotif(@PathVariable("account") String account){
        StringDto qq = new StringDto();
        qq.string = iMessageService.getMotif(account);
        return ResponseEntity.status(HttpStatus.OK).body(qq);
    }

    @GetMapping("/ancimptable/{cpte}")
    public ResponseEntity<JSONArray> getAncImpTable(@PathVariable("cpte") String cpte){
        JSONArray jsonArray = iMessageService.getAncImpTable(cpte);
        return ResponseEntity.status(HttpStatus.OK).body(jsonArray);
    }

    @GetMapping("/cla/{id}")
    public ResponseEntity<Boolean> classificationAutomatique(@PathVariable("id") Long id){
        boolean b = iMessageService.classificationAutomatique(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                b
        );
    }



}
