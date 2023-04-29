package tn.biat.biat.services;

import tn.biat.biat.entities.otherDB.Permissions;

import java.util.List;

public interface IPermissionsService {

    Permissions get(Long id);
    List<Permissions> getByMenuId(Long id);
    boolean delete (Long idmenu);
}
