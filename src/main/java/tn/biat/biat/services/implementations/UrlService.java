package tn.biat.biat.services.implementations;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.biat.biat.entities.otherDB.Url;
import tn.biat.biat.repository.UrlRepository;
import tn.biat.biat.services.IUrlService;

import java.util.List;

@Service
@Slf4j
public class UrlService implements IUrlService {

    @Autowired
    UrlRepository urlRepository;

    @Override
    public List<Url> getAll() {
        return urlRepository.findAll();
    }

    @Override
    public Url add(Url url) {
        url.setUrl(url.getUrl());
        url.setComponent(url.getComponent());
        urlRepository.save(url);
        return url;
    }

    @Override
    public Url modify(Url url, Long id) {
        Url u = this.get(id);
        if(u == null){
            return null;
        }
        u.setComponent(u.getComponent());
        u.setUrl(u.getUrl());
        return urlRepository.save(u);
    }

    @Override
    public Url get(Long id) {
        return urlRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        Url url = urlRepository.findById(id).orElse(null);
        if(url != null){
            urlRepository.delete(url);
            return true;
        }
        return false;
    }

    @Override
    public boolean getUrlByUrl(String url){
        if(urlRepository.getUrlByUrl(url) != null){
            return false;
        }else{
            return true;
        }
    }
}
