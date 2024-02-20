@Override
public List<String> getCategories(String unite) {
    String query = "SELECT TO_CHAR(periode, 'MON YY') AS formatted_date " +
                   "FROM TB_FICHE_FINAL " +
                   "WHERE unite = ? " +
                   "ORDER BY periode DESC FETCH FIRST 4 ROWS ONLY";

    JSONArray json = iFunctionService.queryinput(query, unite);

    List<String> list = new ArrayList<>();
    for (Object obj : json) {
        JSONObject jsonObject = (JSONObject) obj;
        String formattedDate = jsonObject.get("formatted_date").toString();
        list.add(formattedDate);
    }
    System.out.println(list);
    return list;
}
