package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.Tree;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {

    @Query(value = "select agence from \"Tree\" t where \"zone\" =:zone", nativeQuery = true)
    List<String> getAgencesByZone(@Param("zone") String zone);

    @Query(value = "select agence from \"Tree\" t where \"region\" =:region", nativeQuery = true)
    List<String> getAgencesByRegion(@Param("region") String region);

    @Query(value = "select agence from \"Tree\" t where \"pole\" =:pole", nativeQuery = true)
    List<String> getAgencesByPole(@Param("pole") String pole);
}
