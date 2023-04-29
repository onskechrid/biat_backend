package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.Function;
import tn.biat.biat.repository.FunctionRepository;
import tn.biat.biat.services.IFunctionService;


import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class FunctionService implements IFunctionService {

    @Autowired
    FunctionRepository functionRepository;


    HistoryService historyService;


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

    @Override
    public JSONArray queryinput(String QUERY) {
        JSONArray json = new JSONArray();
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/biat", "postgres", "0000");) {
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
}
