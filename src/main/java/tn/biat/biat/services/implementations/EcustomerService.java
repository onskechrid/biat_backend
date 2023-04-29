package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.E_CUSTOMER;
import tn.biat.biat.repository.EcustomerRepository;
import tn.biat.biat.services.IEcustomerService;
import java.util.List;

@Service
@Slf4j
public class EcustomerService implements IEcustomerService {

    @Autowired
    EcustomerRepository ecustomerRepository;

    @Override
    public List<E_CUSTOMER> getAll(){
        return ecustomerRepository.findAll();
    }
}
