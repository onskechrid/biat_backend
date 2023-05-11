package tn.biat.biat.services;

import java.util.List;

public interface IChartService {

    List<String> getCategories(String unite);
    List<Double> getSeries(String unite);
    List<Double> getDetails(String unite,String engGlobal);
    Double getEngGByPeriod(String unite, String p);
    List<Double> getTauxDeRenvPCG(String unite);
    List<Double> getTauxDeSaisieDeBilan(String unite);
    List<Double> getTauxCDL(String unite);
    List<Double> getTauxGenerationCDL(String unite);
    List<Double> getTauxGenerationCreditParticuliers(String unite);
}
