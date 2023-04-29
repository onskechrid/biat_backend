package tn.biat.biat.services.implementations;


import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.History;
import tn.biat.biat.entities.otherDB.Profile;
import tn.biat.biat.entities.otherDB.User;
import tn.biat.biat.repository.UserRepository;
import tn.biat.biat.services.IFunctionService;
import tn.biat.biat.services.IProfilesService;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IProfilesService iProfilesService;
    @Autowired
    private IFunctionService iFunctionService;

    HistoryService historyService;


    @Autowired
    public CustomUserDetailsService( @Lazy HistoryService historyService){
        this.historyService = historyService;
    }


    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(usernameOrEmail);
        if(user == null){
            throw new UsernameNotFoundException("User not found in database!");
        }
        Collection<SimpleGrantedAuthority> auths = new ArrayList<>();
        SimpleGrantedAuthority gauth = new SimpleGrantedAuthority("USER");
        auths.add(gauth);

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getUserPassword(), auths);
    }

    public boolean newUser(User u){
        u.setUserName(u.getUserName());
        u.setUserFirstName(u.getUserFirstName());
        u.setUserLastName(u.getUserLastName());
        u.setEmail(u.getEmail());
        u.setUserPassword(passwordEncoder.encode(u.getUserPassword()));
        u.setStatus("INACTIVE");
        u.setLastlogout(null);
        u.setRegisterdate(LocalDateTime.now());
        u.setInitials(null);
        String pt = "NewUser";
        Profile p = iProfilesService.getByProfileType(pt);
        if(p==null){
            return false;
        }else{
            u.setProfile(p);
        }

        System.err.println(u);
        userRepo.save(u);
        return true;
    }

    public User updateInitials(Long iduser){
        User user = getUserById(iduser);
        if(user == null){
            return null;
        }else {
            String initials = "";
            if (user.getUserFirstName() != null && !user.getUserFirstName().isEmpty()) {
                initials += user.getUserFirstName().substring(0, 1).toUpperCase();
            }
            if (user.getUserLastName() != null && !user.getUserLastName().isEmpty()) {
                initials += user.getUserLastName().substring(0, 1).toUpperCase();
            }
            user.setInitials(initials);
            userRepo.save(user);
            return user;
        }
    }

    public User getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String logged_email = (String) auth.getPrincipal();
        User logged_in_user = userRepo.findByEmail(logged_email);
        return logged_in_user;
    }

    public User getUserById(Long id){
        User user = userRepo.findById(id).orElse(null);
        return user;
    }

    /*public JSONArray getUserByEmail(String email){
        String s = "select * from \"Users\" u where \"email\" = '"+email+"';";
        JSONArray json = iFunctionService.queryinput(s);
        System.out.println(json);
        return json;
    }*/

    public User getUserByEmail(String email){
        User user = userRepo.findByEmail(email);
        System.out.println(user);
        return user;
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public void delete(Long id){
        userRepo.deleteById(id);
    }

    public User updateAfterLogout(String username){
        User u = userRepo.findByUserName(username);
        System.err.println(u);
        if(u == null){
            return null;
        }else{
            System.err.println("eieiieie");
            u.setLastlogout(LocalDateTime.now());
            u.setStatus("INACTIVE");
            userRepo.save(u);
        }
        return u;
    }

    public User updateAfterLogin(String username){
        User u = userRepo.findByUserName(username);
        if(u == null){
            return null;
        }else{
            u.setLastlogout(null);
            u.setStatus("ACTIVE");
            userRepo.save(u);
        }
        return u;
    }

    public User updateProfile(Long iduser, String profileType){
        User u = this.getUserById(iduser);
        if(u == null){
            return null;
        }else{
            Profile p = iProfilesService.getByProfileType(profileType);
            if(p == null){
                return null;
            }else {
                u.setProfile(p);
                if(Objects.equals(profileType, "PCB")){
                    u.setLibelle("PCB");
                }else if(Objects.equals(profileType, "PBD")){
                    u.setLibelle("PBD");
                }else if(Objects.equals(profileType, "Risque Reporting")){
                    u.setLibelle("RR");
                }else if(Objects.equals(profileType, "Risque Credit")){
                    u.setLibelle("RC");
                }
                userRepo.save(u);
            }
        }
        historyService.updateUserHistories("UPDATE", "Update user profile");
        return u;
    }

    public Integer getNumberUsers(){
        return userRepo.getNumberUsers();
    }

    public User updatelibelle(Long id, String newlibelle){
        User u = this.getUserById(id);
        if(u == null){
            return null;
        }else{
            u.setLibelle(newlibelle);
            userRepo.save(u);
        }
        historyService.updateUserHistories("UPDATE", "Update user libelle");
        return u;
    }

    public List<History> getAllUserHistories(Long iduser){
        User user = this.getUserById(iduser);
        if(user == null){
            return null;
        }else{
            List list = user.getHistories();
            return list;
        }
    }

}