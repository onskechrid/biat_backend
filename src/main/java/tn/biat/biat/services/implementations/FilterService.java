package tn.biat.biat.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.biat.biat.repository.FilterRepository;
import tn.biat.biat.repository.FunctionRepository;
import tn.biat.biat.services.IFilterService;

import java.util.List;

@Service
@Slf4j
public class FilterService implements IFilterService {

    @Autowired
    FilterRepository filterRepository;


    @Override
    public List alldatsit(){
        return filterRepository.alldatsit();
    }

    @Override
    public String total(String id,Number datsit){ return filterRepository.total(id,datsit);}

    //idcustomer
    @Override
    public String NAMEidcustomer(String idcustomer){ return filterRepository.NAMEidcustomer(idcustomer);}

    @Override
    public String IDBCTidcustomer(String idcustomer){ return filterRepository.IDBCTidcustomer(idcustomer);}

    @Override
    public String LIBLidcustomer(String idcustomer){ return filterRepository.LIBLidcustomer(idcustomer);}

    //idbct
    @Override
    public String NAMEidbct(String idbct){ return filterRepository.NAMEidbct(idbct);}

    @Override
    public String IDidbct(String idbct){ return filterRepository.IDidbct(idbct);}

    @Override
    public String LIBLidbct(String idbct){ return filterRepository.LIBLidbct(idbct);}

    //comp
    @Override
    public String NAMEcomp(String comp){ return filterRepository.NAMEcomp(comp);}

    @Override
    public String IDcomp(String comp){ return filterRepository.IDcomp(comp);}

    @Override
    public String IDBCTcomp(String comp){ return filterRepository.IDBCTcomp(comp);}

    @Override
    public String LIBLcomp(String comp){ return filterRepository.LIBLcomp(comp);}

    //refcrdt
    @Override
    public String NAMErefcrdt(String refcrdt){ return filterRepository.NAMErefcrdt(refcrdt);}

    @Override
    public String IDrefcrdt(String refcrdt){ return filterRepository.IDrefcrdt(refcrdt);}

    @Override
    public String IDBCTrefcrdt(String refcrdt){ return filterRepository.IDBCTrefcrdt(refcrdt);}

    @Override
    public String LIBLrefcrdt(String refcrdt){ return filterRepository.LIBLrefcrdt(refcrdt);}


}
