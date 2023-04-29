package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.Attachement;

import java.util.List;

@Repository
public interface AttachementRepository extends JpaRepository<Attachement, Long> {

    @Query(value = "select * from \"Attachement\" a where \"name\" = :name and \"size\" = :size and \"type\" = :type;", nativeQuery = true)
    List<Attachement> getByNST(@Param("name") String name, @Param("size") String size, @Param("type") String type);
}
