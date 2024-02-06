package tn.biat.biat.utils;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component // Add this annotation to make it a Spring-managed bean
public class QueryExecutor {

    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String DBURL;

    public JSONArray queryinput(String QUERY) {
        JSONArray json = new JSONArray();
        try (Connection conn = DriverManager.getConnection(DBURL, user,  this.password);) {
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
