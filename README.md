public static List<Map<String, Object>> formatJson(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> formattedData = new ArrayList<>();

        try {
            formattedData = objectMapper.readValue(jsonString, List.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formattedData;
    }
