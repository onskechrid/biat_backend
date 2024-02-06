package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.Attachement;
import tn.biat.biat.entities.otherDB.Composant;
import tn.biat.biat.entities.otherDB.Message;
import tn.biat.biat.entities.otherDB.User;
import tn.biat.biat.repository.ComposantRepository;
import tn.biat.biat.services.IComposantService;
import tn.biat.biat.services.ITreeService;
import tn.biat.biat.utils.QueryExecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ComposantService implements IComposantService {

    @Autowired
    ComposantRepository composantRepository;
    @Autowired
    QueryExecutor queryExecutor;
    @Autowired
    CustomUserDetailsService userService;
    @Autowired
    ITreeService iTreeService;
    @Autowired
    HistoryService historyService;


    @Override
    public List<Composant> getAll() {
        return composantRepository.findAll();
    }

    @Override
    public Composant add(Composant composant) {
        composant.setTitle(composant.getTitle());
        composant.setQuery(composant.getQuery());
        composant.setDescription(composant.getDescription());
        composant.setCreatedBy(composant.getCreatedBy());
        composant.setTimestamp(LocalDateTime.now());
        composantRepository.save(composant);
        historyService.updateUserHistories("ADD", "Add new composant");
        return composant;
    }


    @Override
    public Composant get(Long id) {
        return composantRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        Composant composant = composantRepository.findById(id).orElse(null);
        if(composant != null){
            composantRepository.delete(composant);
            return true;
        }
        historyService.updateUserHistories("DELETE", "Delete composant");
        return false;
    }

    @Override
    public JSONArray apply(String query){
        JSONArray json = queryExecutor.queryinput(query);
        System.out.println(json);
        return json;
    }

    @Override
    public JSONArray applycomposantquery(String query,Long iduser) {
        System.out.println("hello");
        User u = userService.getUserById(iduser);
        String queryWithFilter = "";
        if(u==null){
            return null;
        }else{
            if(Objects.equals(u.getProfile().getProfileType(), "AGENCE") || Objects.equals(u.getProfile().getProfileType(), "CA")){
                queryWithFilter = query+" WHERE code ='"+u.getLibelle()+"';";
            }else if(Objects.equals(u.getProfile().getProfileType(), "ZONE") || Objects.equals(u.getProfile().getProfileType(), "GROUPE")){
                List<String> AgenceByZone = iTreeService.getAgenceByZone(u.getId());
                String codes = AgenceByZone.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
                queryWithFilter = query + " WHERE code IN (" + codes + ")";
            }else if(Objects.equals(u.getProfile().getProfileType(), "REGION")) {
                List<String> AgenceByRegion = iTreeService.getAgenceByRegion(u.getId());
                String codes = AgenceByRegion.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
                queryWithFilter = query + " WHERE code IN (" + codes + ")";
            }else if(Objects.equals(u.getProfile().getProfileType(), "PCB") || Objects.equals(u.getProfile().getProfileType(), "PBD")) {
                List<String> AgenceByPole = iTreeService.getAgenceByPole(u.getId());
                System.out.println(AgenceByPole);
                String codes = AgenceByPole.stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
                queryWithFilter = query + " WHERE code IN (" + codes + ")";
            }else{
                queryWithFilter = query;
            }
        }
        System.out.println(queryWithFilter);
        JSONArray json = queryExecutor.queryinput(queryWithFilter);
        System.out.println(json);
        return json;
    }
}
