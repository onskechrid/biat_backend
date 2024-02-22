import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonFormatter {

    public static void main(String[] args) {
        String json = "[{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":30,\"department\":\"IT\"},{\"firstName\":\"Jane\",\"lastName\":\"Smith\",\"age\":35,\"department\":\"HR\"},{\"firstName\":\"Mike\",\"lastName\":\"Johnson\",\"age\":40,\"department\":\"Finance\"}]";

        List<List<String>> formattedData = formatJson(json);

        // Print the formatted data
        for (List<String> row : formattedData) {
            System.out.println(row);
        }
    }

    public static List<List<String>> formatJson(String jsonString) {
        List<List<String>> formattedData = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON string into a JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonString);

            if (rootNode.isArray()) {
                // Add headers
                List<String> headers = new ArrayList<>();
                JsonNode firstObject = rootNode.get(0);
                Iterator<String> fieldNames = firstObject.fieldNames();
                while (fieldNames.hasNext()) {
                    headers.add(fieldNames.next());
                }
                formattedData.add(headers);

                // Add data rows
                for (JsonNode jsonObject : rootNode) {
                    List<String> row = new ArrayList<>();
                    for (String fieldName : headers) {
                        row.add(jsonObject.get(fieldName).asText());
                    }
                    formattedData.add(row);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formattedData;
    }
}
