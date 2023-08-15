package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.biat.biat.BiatApplication;
import tn.biat.biat.entities.otherDB.Function;
import tn.biat.biat.repository.FunctionRepository;
import tn.biat.biat.services.IFunctionService;


import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class FunctionService implements IFunctionService {

    @Autowired
    FunctionRepository functionRepository;

    @Autowired
    JavaMailSender javaMailSender;
    HistoryService historyService;

    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    public FunctionService( @Lazy HistoryService historyService){
        this.historyService = historyService;
    }
    @Override
    public List<Function> getAll(){
        return functionRepository.findAll();
    }

    @Override
    public Function add(Function function){
        function.setName(function.getName());
        function.setQuery(function.getQuery());
        function.setQueryexcel(function.getQueryexcel());
        function.setStatus(function.getStatus());
        function.setCreator(function.getCreator());
        functionRepository.save(function);
        historyService.updateUserHistories("ADD", "Add new function");
        return function;
    }

    @Override
    public Function modify(Function function , Long id){
        Function f = this.get(id);
        if(f == null){
            return null;
        }
        f.setName(function.getName());
        f.setQueryexcel(function.getQueryexcel());
        f.setQuery(function.getQuery());
        historyService.updateUserHistories("UPDATE", "Update function");
        return functionRepository.save(f);
    }

    @Override
    public Function get(Long id){
        return functionRepository.findById(id).orElse(null);
    }

    @Override
    public boolean get_query(Long id){
        Function f = functionRepository.findById(id).orElse(null);
        return true;
    }

    @Override
    public  boolean delete(Long id){
        Function f = functionRepository.findById(id).orElse(null);
        if(f != null){
            functionRepository.delete(f);
            return true;
        }
        historyService.updateUserHistories("DELETE", "Delete function");
        return false;
    }

    @Override
    public Number getNbrWrongFunctions(){
        Number num = functionRepository.getNbrWrongFunctions();
        return num;
    }

    @Override
    public Boolean updateFnStatus(Long id, int update){
        return functionRepository.updateFnStatus(id,update);
    }

    public Map<String, List<String>> getDatabaseSchema(){
        JSONArray json = new JSONArray();
        Map<String, List<String>> map = new HashMap<>();
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/biat", user,  this.password);) {
            try (PreparedStatement st = conn.prepareStatement("SELECt table_name as d, column_name as n FROM information_schema.columns WHERE table_schema='public' order by d;\n")) { // d hiya table name
                ResultSet resultSet = st.executeQuery();
                ResultSetMetaData md = resultSet.getMetaData();
                int numCols = md.getColumnCount();
                List<String> colNames = IntStream.range(0, numCols)
                        .mapToObj(i -> {
                            try {
                                return md.getColumnName(i + 1);
                            } catch (SQLException e) {
                                e.printStackTrace();
                                return "?";
                            }
                        })
                        .collect(Collectors.toList());

                JSONArray result = new JSONArray();
                while (resultSet.next()) {
                    JSONObject row = new JSONObject();
                    colNames.forEach(cn -> {
                        try {
                            Object c = resultSet.getObject(cn);
                            row.put(cn, c);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
                    result.add(row);
                }
                System.out.println(result);
                json.add(result);

                for (int i = 0; i < result.size(); i++) {
                    JSONObject jsonobject = (JSONObject) result.get(i);
                    String tab = (String) jsonobject.get("d");
                    String col = (String) jsonobject.get("n");
                    List<String> ll = map.get(tab);
                    if(ll != null) {
                        ll.add(col);
                        map.put(tab, ll);
                    }else{
                        map.put(tab, new ArrayList<>());
                        List<String> f = map.get(tab);
                        f.add(col);
                    }
                }
                return map;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //@Scheduled(cron = "* * */1 * * *")
    public void cronCheckFunctions(){

        System.err.println("Starting cron job");
        List<Function> fns = functionRepository.findAll();
        List<String> fn_names = new ArrayList<>();
        for(Function f : fns){
            JSONArray js = queryinput(f.getQuery());
            if(!js.isEmpty()){
                fn_names.add(f.getName());
            }
        }
        //sendmail
        if(!fn_names.isEmpty()){
            this.sendEmail("RR@gmail.com", "Une incohérence des données a été détectée", "Des incohérences des données ont été détectées par les fonction : "+fn_names.toString());
        }else{
            //mayabaaathech
        }
    }
    @Async
    public void sendEmail(String to, String sub, String msg){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(sub);
        mailMessage.setText(msg);
        mailMessage.setFrom("ons.kechrid@esprit.tn");
        javaMailSender.send(mailMessage);
    }
    @Override
    public JSONArray queryinput(String QUERY) {
        JSONArray json = new JSONArray();
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/biat", user,  this.password);) {
            try (PreparedStatement st = conn.prepareStatement(QUERY)) {
                ResultSet resultSet = st.executeQuery();

                /////////////
                ResultSetMetaData md = resultSet.getMetaData();
                int numCols = md.getColumnCount();
                List<String> colNames = IntStream.range(0, numCols)
                        .mapToObj(i -> {
                            try {
                                return md.getColumnName(i + 1);
                            } catch (SQLException e) {
                                e.printStackTrace();
                                return "?";
                            }
                        })
                        .collect(Collectors.toList());

                JSONArray result = new JSONArray();
                while (resultSet.next()) {
                    JSONObject row = new JSONObject();
                    colNames.forEach(cn -> {
                        try {
                            Object c = resultSet.getObject(cn);
                                row.put(cn, c);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
                    result.add(row);
                }
                //////////////
                System.out.println(result);
                json.add(result);
                return result;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public List<String> getTableAndColumnNames(String word) {
        System.out.println("enetering getTablesAndColumnNames");
        System.err.println(BiatApplication.dbSchemeMap);
        List<String> result = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry : BiatApplication.dbSchemeMap.entrySet()){
            if(entry.getKey().toLowerCase().startsWith(word.toLowerCase())){
                result.add(entry.getKey());
            }
            for(int i=0; i<=entry.getValue().size()-1; i++){
                if(entry.getValue().get(i).toLowerCase().startsWith(word.toLowerCase())){
                    result.add(entry.getValue().get(i));
                }
            }
        }
        return result;
    }


}
