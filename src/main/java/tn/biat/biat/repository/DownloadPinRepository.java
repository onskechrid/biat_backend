package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.DownloadPin;

import java.util.List;

@Repository
public interface DownloadPinRepository extends JpaRepository<DownloadPin, Long> {

    @Query(value = "select * from public.\"DownloadPin\" where user_id=:id" , nativeQuery = true)
    List<DownloadPin> findCodeByUserId(@Param("id") Long id);
    @Modifying
    @Query(value = "delete from public.\"DownloadPin\" where user_id=:id", nativeQuery = true)
    void deleteByUserId(@Param("id") Long id);


}
