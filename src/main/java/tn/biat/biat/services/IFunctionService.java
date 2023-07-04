package tn.biat.biat.services;

import net.minidev.json.JSONArray;
import tn.biat.biat.entities.otherDB.Function;

import java.util.List;
import java.util.Map;

public interface    IFunctionService {
    List<Function> getAll();
    Number getNbrWrongFunctions();
    Function add(Function function);
    Function modify(Function function, Long id);
    Function get(Long id);
    boolean get_query(Long id);
    boolean delete(Long id);
    Boolean updateFnStatus(Long id, int update);
    JSONArray queryinput(String QUERY);

    List<String> getTableAndColumnNames(String word);
    Map<String, List<String>> getDatabaseSchema();
}
