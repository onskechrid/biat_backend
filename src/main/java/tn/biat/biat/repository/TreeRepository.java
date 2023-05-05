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


    @Query(value = "select distinct(pole) from \"Tree\" t", nativeQuery = true)
    List<String> getAllPoles();
    @Query(value = "select distinct(zone) from \"Tree\" t", nativeQuery = true)
    List<String> getAllZones();
    @Query(value = "select distinct(region) from \"Tree\" t where region notnull", nativeQuery = true)
    List<String> getAllRegions();
    @Query(value = "select distinct(agence) from \"Tree\" t", nativeQuery = true)
    List<String> getAllAgences();

    @Query(value = "select distinct(zone) from \"Tree\" t where region = ':value'",nativeQuery = true)
    List<String> getAllZonesByRegion(@Param("value") String value);

    @Query(value = "select distinct(region) from \"Tree\" t where pole = ':value'", nativeQuery = true)
    List<String> getAllRegionsByPole(@Param("value") String value);

    @Query(value = "select distinct(zone) from \"Tree\" t where zone = ':value'", nativeQuery = true)
    List<String> getAllZonesByPole(@Param("value") String value);


}
