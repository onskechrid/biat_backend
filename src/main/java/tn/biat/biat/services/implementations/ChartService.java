package tn.biat.biat.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.biat.biat.services.IChartService;
import tn.biat.biat.services.IFunctionService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ChartService implements IChartService {

    @Autowired
    IFunctionService iFunctionService;

    @Override
    public List<String> getCategories(String unite){
        String query = "SELECT\n" +
                "  CASE EXTRACT(MONTH FROM TO_DATE(l.periode, 'MM/DD/YYYY'))\n" +
                "    WHEN 1 THEN 'Jan'\n" +
                "    WHEN 2 THEN 'Fév'\n" +
                "    WHEN 3 THEN 'Mar'\n" +
                "    WHEN 4 THEN 'Avr'\n" +
                "    WHEN 5 THEN 'Mai'\n" +
                "    WHEN 6 THEN 'Juin'\n" +
                "    WHEN 7 THEN 'Juil'\n" +
                "    WHEN 8 THEN 'Aoû'\n" +
                "    WHEN 9 THEN 'Sep'\n" +
                "    WHEN 10 THEN 'Oct'\n" +
                "    WHEN 11 THEN 'Nov'\n" +
                "    WHEN 12 THEN 'Déc'\n" +
                "  END || ' ' || RIGHT(EXTRACT(YEAR FROM TO_DATE(l.periode, 'MM/DD/YYYY'))::text, 2) AS formatted_date\n" +
                "FROM \"LST\" l\n" +
                "WHERE l.unite = '"+unite+"'\n" +
                "ORDER BY TO_DATE(l.periode, 'MM/DD/YYYY');";
        JSONArray json = iFunctionService.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for (JsonNode jsonNode : jsonArray) {
            String formatted_date = jsonNode.get("formatted_date").toString();
            list.add(formatted_date);
        }
        System.out.println(list);
        return list;
    }



    @Override
    public List<Double> getSeries(String unite){
        String query = "SELECT CAST(ROUND(eng_global::numeric / 1000000 , 1) AS TEXT) FROM \"LST\" l WHERE l.unite = '"+unite+"' ORDER BY TO_DATE(l.periode, 'MM/DD/YYYY')\n";
        JSONArray json = iFunctionService.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for (JsonNode jsonNode : jsonArray) {
            Double round = jsonNode.get("round").asDouble();
            list.add(round);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Double> getDetails(String unite, String engGlobal){
        String query = "select CAST(ROUND(pme_eng ::numeric / 1000000 , 1) AS text) as pme_eng , CAST(ROUND(prf_eng ::numeric / 1000000 , 1) AS text) as prf_eng , CAST(ROUND(par_eng ::numeric / 1000000 , 1) AS text) as par_eng from \"LST\" l WHERE l.unite = '"+unite+"' and CAST(ROUND(eng_global::numeric / 1000000 , 1) AS text) = '"+engGlobal+"'\n";
        JSONArray json = iFunctionService.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for (JsonNode jsonNode : jsonArray) {
            Double pme = jsonNode.get("pme_eng").asDouble();
            list.add(pme);
            Double prf = jsonNode.get("prf_eng").asDouble();
            list.add(prf);
            Double par = jsonNode.get("par_eng").asDouble();
            list.add(par);

        }
        System.out.println(list);
        return list;

    }

    @Override
    public Double getEngGByPeriod(String unite, String p){
        String query = "SELECT CAST(ROUND(eng_global::numeric / 1000000 , 1) AS TEXT) as eng_g FROM \"LST\" l WHERE l.unite = '"+unite+"' and  CASE EXTRACT(MONTH FROM TO_DATE(l.periode, 'MM/DD/YYYY')) WHEN 1 THEN 'janvier' WHEN 2 THEN 'février' WHEN 3 THEN 'mars'\n" +
                "WHEN 4 THEN 'avril' WHEN 5 THEN 'mai' WHEN 6 THEN 'juin'  WHEN 7 THEN 'juillet' WHEN 8 THEN 'août' WHEN 9 THEN 'septembre'\n" +
                "WHEN 10 THEN 'octobre' WHEN 11 THEN 'novembre' WHEN 12 THEN 'décembre' END || ' ' || RIGHT(EXTRACT(YEAR FROM TO_DATE(l.periode, 'MM/DD/YYYY'))::text, 2) = '"+p+"';";
        JSONArray json = iFunctionService.queryinput(query);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Double eng_g = 0.0;
        for (JsonNode jsonNode : jsonArray) {
            eng_g = jsonNode.get("eng_g").asDouble();
        }
        return eng_g;
    }


    @Override
    public List<Double> getTauxDeRenvPCG(String unite){
        String query = "SELECT ROUND((nbr_renouv::numeric / nbr_total::numeric) * 100, 1) AS taux_renv FROM \"LST\" l WHERE l.unite = '"+unite+"' ORDER BY TO_DATE(l.periode, 'MM/DD/YYYY');";
        JSONArray json = iFunctionService.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for (JsonNode jsonNode : jsonArray) {
            Double taux_renv = jsonNode.get("taux_renv").asDouble();
            list.add(taux_renv);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Double> getTauxDeSaisieDeBilan(String unite) {
        String query = "SELECT ROUND((nbr_bilan_saisie ::numeric / nbr_relation ::numeric) * 100, 1) AS taux_sb FROM \"LST\" l WHERE l.unite = '"+unite+"' ORDER BY TO_DATE(l.periode, 'MM/DD/YYYY');";
        JSONArray json = iFunctionService.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for (JsonNode jsonNode : jsonArray) {
            Double taux_sb = jsonNode.get("taux_sb").asDouble();
            list.add(taux_sb);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Double> getTauxCDL(String unite) {
        String query = "SELECT ROUND((cdl_mnt ::numeric / eng_global ::numeric) * 100, 1) AS taux_cdl FROM \"LST\" l WHERE l.unite = '"+unite+"' ORDER BY TO_DATE(l.periode, 'MM/DD/YYYY');";
        JSONArray json = iFunctionService.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for (JsonNode jsonNode : jsonArray) {
            Double taux_cdl = jsonNode.get("taux_cdl").asDouble();
            list.add(taux_cdl);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Double> getTauxGenerationCDL(String unite) {
        String query = "SELECT ROUND((total_gen ::numeric / ref_saine_mnt ::numeric) * 100, 1) AS taux_gcdl FROM \"LST\" l WHERE l.unite = '"+unite+"' ORDER BY TO_DATE(l.periode, 'MM/DD/YYYY');";
        JSONArray json = iFunctionService.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for (JsonNode jsonNode : jsonArray) {
            Double taux_gcdl = jsonNode.get("taux_gcdl").asDouble();
            list.add(taux_gcdl);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Double> getTauxGenerationCreditParticuliers(String unite) {
        String query = "SELECT ROUND((par_gen ::numeric / par_ref_saine_mnt ::numeric) * 100, 1) AS taux_gcp FROM \"LST\" l WHERE l.unite = '"+unite+"' ORDER BY TO_DATE(l.periode, 'MM/DD/YYYY');\n";
        JSONArray json = iFunctionService.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for (JsonNode jsonNode : jsonArray) {
            Double taux_gcp = jsonNode.get("taux_gcp").asDouble();
            list.add(taux_gcp);
        }
        System.out.println(list);
        return list;
    }
}
