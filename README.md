@Override
    public List<String> getCategories(String unite){
        String query = "SELECT CASE EXTRACT(MONTH FROM TO_DATE(periode, 'MM/DD/YYYY')) WHEN 1 THEN 'Jan' WHEN 2 THEN 'Fév' WHEN 3 THEN 'Mar' WHEN 4 THEN 'Avr' WHEN 5 THEN 'Mai' WHEN 6 THEN 'Juin' WHEN 7 THEN 'Juil' WHEN 8 THEN 'Aoû' WHEN 9 THEN 'Sep' WHEN 10 THEN 'Oct' WHEN 11 THEN 'Nov' WHEN 12 THEN 'Déc' END || ' ' || RIGHT(EXTRACT(YEAR FROM TO_DATE(periode, 'MM/DD/YYYY'))::text, 2) AS formatted_date FROM TB_FICHE_FINAL WHERE unite = '"+unite+"' ORDER BY TO_DATE(periode, 'MM/DD/YYYY')";
        JSONArray json = iFunctionService.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<String>();
        for (JsonNode jsonNode : jsonArray) {
            String formatted_date = jsonNode.get("formatted_date").toString();
            list.add(formatted_date);
        }
        System.out.println(list);
        return list;
    }





     @Override
    public JSONArray queryinput(String QUERY) {
        JSONArray json = new JSONArray();
        System.out.println("queryyyy1  ::: "+QUERY);
        try (Connection conn = DriverManager.getConnection(DBURL, user,  this.password);) {
            System.out.println("queryyyy2  ::: "+QUERY);
            try (PreparedStatement st = conn.prepareStatement(QUERY)) {
                System.out.println("queryyyy3  ::: "+QUERY);
                ResultSet resultSet = st.executeQuery();
                System.out.println("queryyyy4  ::: "+QUERY);
                /////////////
                ResultSetMetaData md = resultSet.getMetaData();
                int numCols = md.getColumnCount();
                List<String> colNames = IntStream.range(0, numCols)
                        .mapToObj(i -> {
                            try {
                                return md.getColumnName(i+1);
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
