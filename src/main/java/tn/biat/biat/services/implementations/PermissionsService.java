package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.Permissions;
import tn.biat.biat.repository.PermissionsRepository;
import tn.biat.biat.services.IPermissionsService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class PermissionsService implements IPermissionsService {

    @Autowired
    PermissionsRepository permissionsRepository;

    HistoryService historyService;


    @Autowired
    public PermissionsService( @Lazy HistoryService historyService){
        this.historyService = historyService;
    }

    @Value("${spring.datasource.url}")
    private String DBURL;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public Permissions get(Long id) {
        return permissionsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Permissions> getByMenuId(Long id){
        List<Permissions> list = permissionsRepository.getByMenuId(id);
        return list;
    }


    @Override
    public boolean delete(Long idmenu){
        List<Permissions> list = this.getByMenuId(idmenu);
        if(list.size() == 0){
            return false;
        }else{
            for(Permissions p : list) {
                String QUERY = "DELETE FROM \"Profile_permissions\" WHERE \"permissions_id\" =" + p.getId();
                try (Connection conn = DriverManager.getConnection(DBURL, user, password);) {
                    try (PreparedStatement st = conn.prepareStatement(QUERY)) {
                        int result = st.executeUpdate();
                        if (result == 0) {
                            System.out.println("No rows affected.");
                        } else {
                            System.out.println(result + " rows affected.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String QUERY1 = "DELETE FROM \"Permissions\" WHERE \"id\" =" + p.getId();
                try (Connection conn = DriverManager.getConnection(DBURL, user, password);) {
                    try (PreparedStatement st = conn.prepareStatement(QUERY1)) {
                        int result = st.executeUpdate();
                        if (result == 0) {
                            System.out.println("No rows affected.");
                        } else {
                            System.out.println(result + " rows affected.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            historyService.updateUserHistories("DELETE","Delete permission");
            return true;
        }
    }



}
