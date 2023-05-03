package tn.biat.biat.services;

import tn.biat.biat.entities.otherDB.Client;

public interface IClientService {

    Client getById(String account);
}
