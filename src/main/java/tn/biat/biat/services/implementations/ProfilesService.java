package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.Menu;
import tn.biat.biat.entities.otherDB.Permissions;
import tn.biat.biat.entities.otherDB.Profile;
import tn.biat.biat.entities.otherDB.User;
import tn.biat.biat.repository.PermissionsRepository;
import tn.biat.biat.repository.ProfilesRepository;
import tn.biat.biat.services.IMenuService;
import tn.biat.biat.services.IPermissionsService;
import tn.biat.biat.services.IProfilesService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@Slf4j
public class ProfilesService implements IProfilesService {
    @Autowired
    ProfilesRepository profileRepository;
    @Autowired
    PermissionsRepository permissionsRepository;
    @Autowired
    IMenuService iMenuService;


    HistoryService historyService;


    @Autowired
    public ProfilesService( @Lazy HistoryService historyService){
        this.historyService = historyService;
    }

    @Value("${spring.datasource.url}")
    private String DBURL;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile get(Long id) {
        return profileRepository.findById(id).orElse(null);
    }


    @Override
    public boolean delete(String name) {
        Profile profile = this.getByProfileType(name);
        System.err.println(profile);
        if(profile == null){
            return false;
        }else {
            String QUERY = "UPDATE public.\"Users\" SET profile='NewUser' WHERE profile = '" + name + "';";
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
            profileRepository.delete(profile);
        }
        historyService.updateUserHistories("DELETE", "Delete profile");
        return true;
    }

    @Override
    public Profile add(Profile profile) {
        profile.setProfileType(profile.getProfileType());
        profileRepository.save(profile);
        historyService.updateUserHistories("ADD", "Add profile");
        return profile;
    }

    @Override
    public Profile getByProfileType(String pt) {
        List<Profile> l = this.getAll();
        for (Profile profile : l) {
            if (profile.getProfileType().equals(pt)) {
                return profile;
            }
        }
        return null;
    }


    @Override
    public List<Permissions> getAllProfilePermissions(Long id){
        Profile p = this.get(id);
        if(p == null){
            return null;
        }else {
            List l = p.getPermissions();
            return l;
        }
    }

    @Override
    public List<Permissions> getAllProfilePermissionsByProfiletype(String pt){
        Profile profile = this.getByProfileType(pt);
        if(profile == null){
            return null;
        }else {
            List<Permissions> l = profile.getPermissions();
            return l;
        }
    }

    @Override
    public List<Menu> getAllCheckedProfilePermissionsByProfiletype(String pt){
        Profile profile = this.getByProfileType(pt);
        if(profile == null){
            return null;
        }else {
            List<Permissions> per = profile.getPermissions();
            List<Menu> checkedPermittedMenus = new ArrayList<>();
            for (Permissions p : per) {
                if (p.getMenu().isChecked()==true) {
                    checkedPermittedMenus.add(p.getMenu());
                }
            }
            return checkedPermittedMenus;
        }
    }

    @Override
    public boolean updateProfilePermissions(String profileType, Long idmenu){
        Menu m = iMenuService.get(idmenu);
        Profile p = this.getByProfileType(profileType);
        if(p==null || m==null){
            return false;
        }else{
            Permissions permissions = new Permissions();
            permissions.setMenu(m);
            permissionsRepository.save(permissions);
            String QUERY ="INSERT INTO public.\"Profile_permissions\" (\"Profile_id\", permissions_id) VALUES("+p.getId()+","+permissions.getId()+");";
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

        }
        historyService.updateUserHistories("UPDATE", "Update profile permissions");
        return true;
    }

    @Override
    public boolean deletePermission(String pt,Long idmenu) {
        Profile profile = this.getByProfileType(pt);
        Menu menu = iMenuService.get(idmenu);
        if (profile == null || menu == null) {
            return false;
        }else{
            for (Permissions p : profile.getPermissions()) {
                if (Objects.equals(p.getMenu().getId(), idmenu)){
                    String QUERY ="DELETE FROM \"Profile_permissions\" WHERE \"permissions_id\" ="+p.getId();
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
                    String QUERY1 ="DELETE FROM \"Permissions\" WHERE \"id\" ="+p.getId();
                    try (Connection conn = DriverManager.getConnection(DBURL, user, password);) {
                        try (PreparedStatement st = conn.prepareStatement(QUERY1)) {
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
                }
            }
        }
        historyService.updateUserHistories("DELETE", "Delete permission");
        return true;
    }




}
