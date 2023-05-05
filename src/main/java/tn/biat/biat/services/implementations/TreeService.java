package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.Tree;
import tn.biat.biat.entities.otherDB.User;
import tn.biat.biat.repository.TreeRepository;
import tn.biat.biat.services.ITreeService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TreeService implements ITreeService {

    @Autowired
    TreeRepository treeRepository;
    @Autowired
    CustomUserDetailsService userService;

    public List<Tree> getAll(){return treeRepository.findAll();}

    @Override
    public List<String> getAgenceByZone(Long idUser) {
        User u = userService.getUserById(idUser);
        if (u == null) {
            return null;
        } else {
            List<String> list = treeRepository.getAgencesByZone(u.getLibelle());
            return list;
        }
    }

    @Override
    public List<String> getAgenceByZoneAndLabel(String label) {
        List<String> list = treeRepository.getAgencesByZone(label);
        return list;
    }

    @Override
    public List<String> getAgenceByRegion(Long idUser) {
        User u = userService.getUserById(idUser);
        if (u == null) {
            return null;
        } else {
            List<String> list = treeRepository.getAgencesByRegion(u.getLibelle());
            return list;
        }
    }

    @Override
    public List<String> getAgenceByRegionAndLabel(String label) {
        List<String> list = treeRepository.getAgencesByRegion(label);
        return list;
    }


    @Override
    public List<String> getAgenceByPole(Long idUser) {
        User u = userService.getUserById(idUser);
        if (u == null) {
            return null;
        } else {
            List<String> list = treeRepository.getAgencesByPole(u.getLibelle());
            return list;
        }
    }

    @Override
    public List<String> getAgenceByPoleAndLabel(String label) {
        List<String> list = treeRepository.getAgencesByPole(label);
        return list;
    }

    @Override
    public List<String> getAllAgences(){
        return treeRepository.getAllAgences();
    }
    @Override
    public List<String> getAllZones(){
        return treeRepository.getAllZones();
    }
    @Override
    public List<String> getAllPoles(){
        return treeRepository.getAllPoles();
    }
    @Override
    public List<String> getAllRegions(){
        return treeRepository.getAllRegions();
    }

    @Override
    public List<String> getExtensions(String pt,String value){
        List<String> allExtensions = new ArrayList<>();
        if(pt.equals("ZONE") || pt.equals("GROUPE")){
            allExtensions.addAll(getAgenceByZoneAndLabel(value));
            allExtensions.add(value);
        }else if(pt.equals("REGION")){
            allExtensions.addAll(getAgenceByRegionAndLabel(value));
            allExtensions.addAll(treeRepository.getAllZonesByRegion(value));
            allExtensions.add(value);
        }else if(pt.equals("PCB") || pt.equals("PBD")){
            allExtensions.addAll(getAgenceByPoleAndLabel(value));
            allExtensions.addAll(treeRepository.getAllZonesByPole(value));
            allExtensions.addAll(treeRepository.getAllRegionsByPole(value));
            allExtensions.add(value);
        }else if(pt.equals("RISQUE REPORTING") || pt.equals("RISQUE CREDIT")){
            allExtensions.addAll(treeRepository.getAllRegions());
            allExtensions.addAll(treeRepository.getAllPoles());
            allExtensions.addAll(treeRepository.getAllAgences());
            allExtensions.addAll(treeRepository.getAllZones());
        }
        return allExtensions;
    }

}
