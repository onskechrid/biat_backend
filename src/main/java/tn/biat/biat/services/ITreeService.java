package tn.biat.biat.services;

import tn.biat.biat.entities.otherDB.User;

import java.util.List;

public interface ITreeService {

    List<String> getAgenceByZone(Long idUser);
    List<String> getAgenceByRegion(Long idUser);
    List<String> getAgenceByPole(Long idUser);

    List<String> getAgenceByZoneAndLabel(String label);
    List<String> getAgenceByRegionAndLabel(String label);
    List<String> getAgenceByPoleAndLabel(String label);
}
