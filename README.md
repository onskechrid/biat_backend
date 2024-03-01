@Override
public String getNumberJoursTotal(){
    String q = "SELECT SUM(TO_DATE('31/03/2023', 'DD/MM/YYYY') - TO_DATE(date_ech, 'DD/MM/YYYY') + 1) AS days_between " +
               "FROM dwm_pd_payment_due_details " +
               "WHERE cpte = 'K320022877'";
    JSONArray x = iFunctionService.queryinput(q);
    String ss = x.toString().replace("[{\"days_between\":","");
    ss = ss.replace("}]","");
    return ss;
}

@Override
public String getPeriode(String cpte){
    String q = "SELECT periode FROM risk_cpte rc WHERE cpte = '"+cpte+"'";
    JSONArray j = iFunctionService.queryinput(q);
    String s = j.toString().replace("[{\"periode\":\"","");
    s = s.replace("\"}]","");
    s = s.replace("\\/","/");
    return s;
}

@Override
public String getAgiosByDate(String periode, String date){
    String q = "SELECT (TO_DATE('"+periode+"', 'MM/DD/YYYY') - TO_DATE(date_ech, 'DD/MM/YYYY') +1) AS days_between " +
               "FROM dwm_pd_payment_due_details " +
               "WHERE date_ech = '"+date+"' AND ROWNUM = 1";
    JSONArray x = iFunctionService.queryinput(q);
    String ss = x.toString().replace("[{\"days_between\":","");
    ss = ss.replace("}]","");
    return ss;
}

@Override
public JSONArray getAncImpTable(String cpte){
    String query = "SELECT cpte, periode, date_ech, imp_int, imp_pr " +
                   "FROM dwm_pd_payment_due_details dppdd " +
                   "WHERE cpte ='"+cpte+"'";
    JSONArray jsonArray = iFunctionService.queryinput(query);
    return jsonArray;
}

@Override
public List<String> getPaiementPrincipal(Long id){
    // Code inchangé
}

public String getDateEch(String montant){
    String s = "SELECT date_ech FROM dwm_pd_payment_due_details dppdd WHERE imp_pr = '"+montant+"' AND ROWNUM = 1";
    JSONArray j = iFunctionService.queryinput(s);
    String ss = j.toString().replace("[{\"date_ech\":\"","");
    ss = ss.replace("\"}]","");
    ss = ss.replace("\\/","/");
    return ss;
}

@Override
public String getMotif(String cpte){
    String s = "SELECT motif FROM risk_cpte WHERE cpte = '"+cpte+"'";
    JSONArray j = iFunctionService.queryinput(s);
    String ss = j.toString().replace("[{\"motif\":\"","");
    ss = ss.replace("\"}]","");
    return ss;
}

// Les autres méthodes restent inchangées pour leur compatibilité avec Oracle SQL
