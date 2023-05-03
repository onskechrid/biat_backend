package tn.biat.biat.services.implementations;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.Client;
import tn.biat.biat.repository.ClientRepository;
import tn.biat.biat.services.IClientService;

@Service
@Slf4j
public class ClientService implements IClientService {

    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client getById(String account) {
        Client c = clientRepository.findById(account).orElse(null);
        return c;
    }
}
