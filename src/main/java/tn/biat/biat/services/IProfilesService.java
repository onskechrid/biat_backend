package tn.biat.biat.services;

import tn.biat.biat.entities.otherDB.Menu;
import tn.biat.biat.entities.otherDB.Permissions;
import tn.biat.biat.entities.otherDB.Profile;

import java.util.List;

public interface IProfilesService {

    List<Profile> getAll();
    Profile get(Long id);
    Profile add(Profile profile);
    boolean delete(Long id);
    Profile getByProfileType(String pt);
    List<Permissions> getAllProfilePermissions(Long id);
    List<Permissions> getAllProfilePermissionsByProfiletype(String pt);
    List<Menu> getAllCheckedProfilePermissionsByProfiletype(String pt);
    boolean updateProfilePermissions(String profileType, Long idmenu);
    boolean deletePermission(String pt ,Long idmenu);

}
