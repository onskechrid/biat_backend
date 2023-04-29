package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.Function;

import java.util.List;

@Repository
public interface FilterRepository extends JpaRepository<Function, Long> {

    @Query(value = "select \"DAT_SIT\" from public.\"E_ENCOURS\" order by \"DAT_SIT\" DESC;" , nativeQuery = true)
    List alldatsit();


    @Query(value = "select sum(  \"MONT_ENCR_REDR_TND\") from ( select a.\"CUST\" , \"COMP\" ,\"Comp_CTOS\", \"REF_CONT\"  ,\"LIB_LONG\" , a.\"CATG\" , \"TYPE_ENG\" , \"CODE_TYP_ENCR\" , a.\"STATUT\", \"MONT_ENCR_REDR_TND\" from ( select a.* ,c.\"CUST\" , \"LIB_LONG\"  , \"CATG\", \"TYPE_ENG\", \"REF_CRDT\", \"COMP\" fROM (select * from \"E_ENCOURS\" ee  where \"DAT_SIT\" =:datsit and \"DERSIT\" =1 and \"STATUT\" ='A' /*and substring(\"REF_CONT\",1,2) not in ('CX') */) A ,\"R_TYPE_ENCOUR\" B , (select * from \"E_CONTRAT\" ec where \"DERSIT\" =1) C where A.\"CODE_TYP_ENCR\"= B.\"ID\" and A.\"REF_CONT\" = C.\"REF_CONT\") a , ( select * from \"E_ACCOUNT\" ea where \"DERSIT\" =1 ) b where a.\"COMP\" = B.\"ID\") aa ,  \"R_CODE_ENG\" b where \"CUST\" =':id' and aa.\"TYPE_ENG\"=B.\"ID\";" , nativeQuery = true)
    String total(@Param("id") String id, @Param("datsit") Number datsit);

    //filtre selon ID_CUSTOMER

    @Query(value = "select \"NAME_1\" from public.\"E_CUSTOMER\" where \"ID\"= ':idcustomer' ;" , nativeQuery = true)
    String NAMEidcustomer(@Param("idcustomer") String idcustomer);

    @Query(value = "select ra.\"LIBL\" from \"R_ACTIVITE\" ra inner join \"E_CUSTOMER\" ec on ra.\"ID\" = ec.\"CU_ACTV\" where ec.\"ID\" =':idcustomer';" , nativeQuery = true)
    String LIBLidcustomer(@Param("idcustomer") String idcustomer);

    @Query(value = "select \"ID_BCT\" from \"E_CUSTOMER\" ec where \"ID\" =':idcuctomer';" , nativeQuery = true)
    String IDBCTidcustomer(@Param("idcustomer") String idcustomer);

    //filtre selon ID_BCT

    @Query(value = "select \"NAME_1\" from public.\"E_CUSTOMER\" where \"ID_BCT\"=':idbct';" , nativeQuery = true)
    String NAMEidbct(@Param("idbct") String idbct);

    @Query(value = "select \"ID\" from public.\"E_CUSTOMER\" where \"ID_BCT\"=':idbct';" , nativeQuery = true)
    String IDidbct(@Param("idbct") String idbct);

    @Query(value = "select ra.\"LIBL\" from \"R_ACTIVITE\" ra inner join \"E_CUSTOMER\" ec on ra.\"ID\" = ec.\"CU_ACTV\" where ec.\"ID_BCT\" =':idbct';" , nativeQuery = true)
    String LIBLidbct(@Param("idbct") String idbct);

    //filtre selon COMP

    @Query(value = "select ec.\"NAME_1\" from \"E_CUSTOMER\" ec inner join \"E_CONTRAT\" econ on ec.\"ID\" = econ.\"CUST\" where econ.\"COMP\"=':comp' limit 1;" , nativeQuery = true)
    String NAMEcomp(@Param("comp") String comp);

    @Query(value = "select \"CUST\" from \"E_CONTRAT\" where \"COMP\" = ':comp' limit 1;" , nativeQuery = true)
    String IDcomp(@Param("comp") String comp);

    @Query(value = "select ec.\"ID_BCT\" from \"E_CUSTOMER\" ec inner join \"E_CONTRAT\" econ on ec.\"ID\" = econ.\"CUST\" where econ.\"COMP\"=':comp' limit 1;" , nativeQuery = true)
    String IDBCTcomp(@Param("comp") String comp);

    @Query(value = "select ra.\"LIBL\" from \"R_ACTIVITE\" ra inner join \"E_CUSTOMER\" ec on ra.\"ID\" = ec.\"CU_ACTV\" where ec.\"ID\" = (select \"CUST\" from \"E_CONTRAT\" econ where econ.\"COMP\" =':comp' limit 1);" , nativeQuery = true)
    String LIBLcomp(@Param("comp") String comp);

    //filtre selon  REF_CRDT

    @Query(value = "select \"NAME_1\" from \"E_CUSTOMER\" ec inner join \"E_CONTRAT\" econ on ec.\"ID\" = econ.\"CUST\" where econ.\"REF_CRDT\" =':refcrdt' limit 1;" , nativeQuery = true)
    String NAMErefcrdt(@Param("refcrdt") String refcrdt);

    @Query(value = "select \"CUST\" from \"E_CONTRAT\" where \"REF_CRDT\" = ':refcrdt';" , nativeQuery = true)
    String IDrefcrdt(@Param("refcrdt") String refcrdt);

    @Query(value = "select \"ID_BCT\" from \"E_CUSTOMER\" ec inner join \"E_CONTRAT\" econ on ec.\"ID\" = econ.\"CUST\" where econ.\"REF_CRDT\" =':refcrdt' limit 1;"  , nativeQuery = true)
    String IDBCTrefcrdt(@Param("refcrdt") String refcrdt);

    @Query(value = "select ra.\"LIBL\" from \"R_ACTIVITE\" ra inner join \"E_CUSTOMER\" ec on ra.\"ID\" = ec.\"CU_ACTV\" where ec.\"ID\" = (select \"CUST\" from \"E_CONTRAT\" econ where econ.\"REF_CRDT\" =':refcrdt');" , nativeQuery = true)
    String LIBLrefcrdt(@Param("refcrdt") String refcrdt);
}
