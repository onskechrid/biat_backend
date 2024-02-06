package tn.biat.biat.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.*;
import tn.biat.biat.repository.ComposantRepository;
import tn.biat.biat.repository.MenuRepository;
import tn.biat.biat.services.*;
import tn.biat.biat.utils.QueryExecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MenuService implements IMenuService {

    @Autowired
    MenuRepository menuRepository;
    @Autowired
    FunctionService functionService;
    @Autowired
    IUrlService iUrlService;
    @Autowired
    IPermissionsService iPermissionsService;
    @Autowired
    ComposantRepository composantRepository;
    @Autowired
    QueryExecutor queryExecutor;

    HistoryService historyService;

    @Autowired
    public MenuService( @Lazy HistoryService historyService){
        this.historyService = historyService;
    }

    @Value("${spring.datasource.url}")
    private String DBURL;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;


    @Override
    public List<Menu> getAll() {
       return menuRepository.findAll();
    }

    @Override
    public Menu add(Menu menu) {
        menu.setName(menu.getName());
        menu.setIconcomponent(menu.getIconcomponent());
        menu.setUrl(menu.getUrl());
        menu.setChecked(menu.isChecked());
        menu.setLevel(menu.getLevel());
        menu.setIdparent(menu.getIdparent());
        menu.setActive(true);
        menu.setComposants(null);
        menuRepository.save(menu);
        historyService.updateUserHistories("ADD", "Add new menu");
        return menu;
    }

    @Override
    public Menu modify(Menu menu, Long id) {
        Menu m = this.get(id);
        if(m == null){
            return null;
        }
        m.setName(menu.getName());
        m.setUrl(menu.getUrl());
        m.setIconcomponent(menu.getIconcomponent());
        historyService.updateUserHistories("UPDATE", "Update menu");
        return menuRepository.save(m);
    }

    @Override
    public Menu updatecheckedstatus(Long id,boolean check) {
        Menu m = this.get(id);
        if(m == null){
            return null;
        }else{
            m.setChecked(check);
        }
        return menuRepository.save(m);
    }

    @Override
    public Menu updateactivestatus(Long id,boolean active) {
        Menu m = this.get(id);
        if(m == null){
            return null;
        }else{
            m.setActive(active);
        }
        return menuRepository.save(m);
    }

    @Override
    public Menu updatelevelandidp(Long id,Long newidparent) {
        Menu m = this.get(id);
        if(m == null){
            return null;
        }else{
            m.setLevel(m.getLevel() - 1);
            if (newidparent == 0){
                m.setIdparent(null);
            }else {
                m.setIdparent(newidparent);
            }
        }
        return menuRepository.save(m);
    }

    @Override
    public Menu updateicon(String icon, Long id){
        Menu m = this.get(id);
        m.setIconcomponent(icon);
        historyService.updateUserHistories("UPDATE", "Update menu icon");
        return menuRepository.save(m);
    }

    @Override
    public Menu updatename(String newname, Long id){
        Menu m = this.get(id);
        m.setName(newname);
        historyService.updateUserHistories("UPDATE", "Update menu name");
        return menuRepository.save(m);
    }

    @Override
    public Menu updateurl(Long idmenu, Long idnewurl){
        Menu m = this.get(idmenu);
        System.out.println(m);
        Url url = iUrlService.get(idnewurl);
        System.out.println(url);
        if(m==null || url==null){
            System.out.println("null");
            return null;
        }else{
            System.out.println("dkhall");
            m.setUrl(url.getUrl());
            menuRepository.save(m);
        }
        historyService.updateUserHistories("UPDATE", "Update menu url");
        return m;
    }

    @Override
    public Menu get(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long idmenu) {
        Menu menu = menuRepository.findById(idmenu).orElse(null);
        List<Permissions> list = iPermissionsService.getByMenuId(idmenu);
        List<Composant> listComposants = this.get(idmenu).getComposants();
        if(menu == null) {
            return false;
        }else if(list.size() == 0) {
            System.out.println("menu maw teba3 hatta permission");
            menuRepository.delete(menu);
        }else if(list.size() != 0 ){
            for(Permissions p : list){
                String QUERY ="DELETE FROM \"Profile_permissions\" WHERE \"permissions_id\" ="+p.getId();
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
                String QUERY1 ="DELETE FROM \"Permissions\" WHERE \"id\" ="+p.getId();
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

            for(Composant c : listComposants){
                String QUERY2 ="DELETE FROM \"Profile_permissions\" WHERE \"permissions_id\" ="+c.getId();
                try (Connection conn = DriverManager.getConnection(DBURL, user, password);) {
                    try (PreparedStatement st = conn.prepareStatement(QUERY2)) {
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
                String QUERY3 ="DELETE FROM public.\"Menu_composants\" WHERE composants_id="+c.getId();
                try (Connection conn = DriverManager.getConnection(DBURL, user, password);) {
                    try (PreparedStatement st = conn.prepareStatement(QUERY3)) {
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
            menuRepository.delete(menu);
        }
        historyService.updateUserHistories("DELETE", "Delete menu");
        return true;
    }

    @Override
    public List<Menu> getAllCheckedMenus(){
        List<Menu> list = menuRepository.getAllcheckedMenus();
        return list;
    }

    @Override
    public List<Menu> getAllFirstLevelMenus(){
        List<Menu> list = menuRepository.getAllFirstLevelMenus();
        return list;
    }

    @Override
    public List<Menu> getlistbyidandlevel(Long id, int level){
        return menuRepository.getlistbyidandlevel(id,level);
    }

    @Override
    public Long getidparent(Long id){
        return menuRepository.getidparent(id);
    }

    @Override
    public List<Menu> getid(Long idparent){
        return menuRepository.getid(idparent);
    }

    @Override
    public List gettreeminayylevel(Long idd) { //yaatyk tree ta3 ayy menu min ay level: exp: m8->m9->m10 sachant illi m9 submenu lil m8 w level de m8 egale a 2
        //String query = "select id, idparent||','||id as idd from \"Menu\" order by id";
        String query = "with recursive \"menus_tree\" as (select m.\"id\",m.\"level\",m.\"id\"::VARCHAR as \"menu_id\" from \"Menu\" m where id="+idd+" union all select m2.\"id\",m2.\"level\", \"menu_id\"::VARCHAR ||','||m2.id::VARCHAR from \"Menu\" m2 join \"menus_tree\" et on et.\"id\" = m2.\"idparent\") select \"id\" , \"menu_id\" from menus_tree";
        JSONArray json = queryExecutor.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for (JsonNode jsonNode : jsonArray) {
            Long id = jsonNode.get("id").asLong();
            String s = jsonNode.get("menu_id").toString();

            list.add(s);
            System.out.println(id +"--"+s);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List gettreeminlevel1() { //exemple m1->m2->m3->m4  sachant que m1 level 1, m2 submenu lil m1 , m3 submenu lil m2 ....
        //String query = "select id, idparent||','||id as idd from \"Menu\" order by id";
        String query = "with recursive \"menus_tree\" as (select m.\"id\",m.\"level\",m.\"id\"::VARCHAR as \"menu_id\" from \"Menu\" m union all select m2.\"id\",m2.\"level\", \"menu_id\"::VARCHAR ||','||m2.id::VARCHAR from \"Menu\" m2 join \"menus_tree\" et on et.\"id\" = m2.\"idparent\") select \"id\" , \"menu_id\" from menus_tree";
        JSONArray json = queryExecutor.queryinput(query);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonArray = null;
        try {
            jsonArray = mapper.readTree(String.valueOf(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for (JsonNode jsonNode : jsonArray) {
            Long id = jsonNode.get("id").asLong();
            String s = jsonNode.get("menu_id").toString();

            int level = get(id).getLevel();
            int x = level-1;
            int count = jsonNode.get("menu_id").toString().split(",").length-1;
            if(x == count){
                System.out.println(count);
                list.add(s);
            }
            System.out.println(id +"--"+s);
        }
        //System.out.println(list);
        return list;
    }

    @Override
    public Menu getMenuByName(String name){
        Menu menu = menuRepository.getMenuByName(name);
        return menu;
    }

    @Override
    public boolean updateMenuComposants(String menuname, String title, String description, String query){
        Menu m = this.getMenuByName(menuname);
        if(m==null){
            return false;
        }else{
            Composant composant = new Composant();
            composant.setDescription(description);
            composant.setTitle(title);
            composant.setQuery(query);
            composantRepository.save(composant);
            System.out.println(composant);
            String QUERY ="INSERT INTO public.\"Menu_composants\" (\"Menu_id\", composants_id) VALUES("+m.getId()+"," +composant.getId()+");\n";
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
        historyService.updateUserHistories("UPDATE", "Update menu composants");
        return true;
    }


    @Override
    public boolean deleteComposant(Long idcomposant){
        Composant composant = composantRepository.findById(idcomposant).orElse(null);
        if(composant == null){
            return false;
        }else{
            String QUERY = "DELETE FROM public.\"Menu_composants\" WHERE composants_id=" +composant.getId();
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
            String QUERY1 = "DELETE FROM public.\"Composant\" WHERE id = " + composant.getId();
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
            historyService.updateUserHistories("DELETE","Delete composant");
            return true;
        }
    }

}
