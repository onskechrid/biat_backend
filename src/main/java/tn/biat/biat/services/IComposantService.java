package tn.biat.biat.services;

import net.minidev.json.JSONArray;
import tn.biat.biat.entities.otherDB.Composant;

import java.util.List;

public interface IComposantService {

    List<Composant> getAll();
    Composant add(Composant composant);
    Composant get(Long id);
    boolean delete(Long id);
    JSONArray apply(String query);
    JSONArray applycomposantquery(String query, Long iduser);
}
