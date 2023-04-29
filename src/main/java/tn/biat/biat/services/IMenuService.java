package tn.biat.biat.services;

import tn.biat.biat.entities.otherDB.Composant;
import tn.biat.biat.entities.otherDB.Menu;

import java.util.List;

public interface IMenuService {


    List<Menu> getAll();
    Menu add(Menu menu);
    Menu modify(Menu menu, Long id);
    Menu get(Long id);
    boolean delete(Long id);
    List<Menu> getAllCheckedMenus();
    List<Menu> getAllFirstLevelMenus();
    Menu updatecheckedstatus(Long id, boolean check);
    Menu updateactivestatus(Long id,boolean active);
    List<Menu> getlistbyidandlevel (Long id, int level);
    Long getidparent (Long id);
    List<Menu> getid(Long idparent);
    List gettreeminlevel1();
    List gettreeminayylevel(Long idd);
    Menu updateicon(String icon, Long id);
    Menu updateurl(Long idmenu, Long idnewurl);
    Menu updatename(String newname, Long id);
    Menu updatelevelandidp(Long id,Long newidparent);
    Menu getMenuByName(String name);
    boolean updateMenuComposants(String menuname, String title, String description, String query);
    boolean deleteComposant(Long idcomposant);
}
