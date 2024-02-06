package tn.biat.biat.services;

import java.util.List;

public interface ITreeService {

    List<String> getAgenceByZone(Long idUser);
    List<String> getAgenceByRegion(Long idUser);
    List<String> getAgenceByPole(Long idUser);

    List<String> getAgenceByZoneAndLabel(String label);
    List<String> getAgenceByRegionAndLabel(String label);
    List<String> getAgenceByPoleAndLabel(String label);


    List<String> getAllAgences();
    List<String> getAllZones();
    List<String> getAllPoles();
    List<String> getAllRegions();

    List<String> getExtensions(String pt,String value);
}
