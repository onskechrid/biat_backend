package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    @Query(value = "select * from \"Url\" u where url = ':url'", nativeQuery = true)
    public Url getUrlByUrl(@Param("url") String url);
}
