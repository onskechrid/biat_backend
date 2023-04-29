package tn.biat.biat.services;

import tn.biat.biat.entities.otherDB.Url;

import java.util.List;

public interface IUrlService {

    List<Url> getAll();
    Url add(Url url);
    Url modify(Url url, Long id);
    Url get(Long id);
    boolean delete(Long id);
    boolean getUrlByUrl(String url);
}
