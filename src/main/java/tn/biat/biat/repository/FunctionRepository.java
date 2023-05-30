package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.biat.biat.entities.otherDB.Function;



@Repository
public interface FunctionRepository  extends JpaRepository<Function, Long> {

    @Query(value = "select count(*) as n from public.\"Functions\" where status='1';" , nativeQuery = true)
    public Number getNbrWrongFunctions();


    @Transactional
    @Modifying
    @Query(value = "update public.\"Functions\" set \"status\"=?2 where \"id\"=?1" , nativeQuery = true)
    public Boolean updateFnStatus(@Param("id") Long id, @Param("update") int update);

}
