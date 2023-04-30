package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.Tree;
import tn.biat.biat.entities.otherDB.User;
import tn.biat.biat.repository.TreeRepository;
import tn.biat.biat.services.ITreeService;

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

}
