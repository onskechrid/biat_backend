package tn.biat.biat.services;

import java.util.List;

public interface IFilterService {

    List alldatsit();
    String total(String id,Number datsit);
    String NAMEidcustomer(String idcustomer);
    String IDBCTidcustomer(String idcustomer);
    String LIBLidcustomer(String idcustomer);

    String NAMEidbct(String idbct);
    String IDidbct(String idbct);
    String LIBLidbct(String idbct);

    String NAMEcomp(String comp);
    String IDcomp(String comp);
    String IDBCTcomp(String comp);
    String LIBLcomp(String comp);

    String NAMErefcrdt(String refcrdt);
    String IDrefcrdt(String refcrdt);
    String IDBCTrefcrdt(String refcrdt);
    String LIBLrefcrdt(String refcrdt);






}
