package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.Classification;


@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {

    @Query(value = "select * from \"Classification\" c where \"client_account\" = :account" , nativeQuery = true)
    public Classification getClassificationByClientaccount(@Param("account") String account);


}
