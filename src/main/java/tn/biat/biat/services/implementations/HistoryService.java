package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.History;
import tn.biat.biat.entities.otherDB.User;
import tn.biat.biat.repository.HistoryRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
@Service
@Slf4j
public class HistoryService {


    CustomUserDetailsService userService;
    @Autowired
    HistoryRepository historyRepository;

    @Value("${spring.datasource.url}")
    private String DBURL;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    public HistoryService( CustomUserDetailsService customUserDetailsService){
        this.userService = customUserDetailsService;
    }
    public boolean updateUserHistories(String type, String text){
        User u = userService.getLoggedInUser();
        if(u == null){
            return false;
        }else {
            History history = new History();
            history.setActionType(type);
            history.setActionTime(LocalDateTime.now());
            history.setActionText("L'utilisateur "+u.getUserName()+" a "+text);
            historyRepository.save(history);
            String QUERY ="INSERT INTO public.\"Users_histories\" (\"User_id\", histories_id) VALUES("+u.getId()+","+history.getId()+");";
            try (Connection conn = DriverManager.getConnection(DBURL, user, password);) {
                try (PreparedStatement st = conn.prepareStatement(QUERY)) {
                    int result = st.executeUpdate(); // execute update query

                    // check if the query affected any rows
                    if (result == 0) {
                        System.out.println("No rows affected.");
                    } else {
                        System.out.println(result + " rows affected.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
