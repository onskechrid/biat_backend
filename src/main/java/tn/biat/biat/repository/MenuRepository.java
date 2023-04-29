package tn.biat.biat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.Menu;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query(value = "select * from \"Menu\" where \"checked\" =true; ", nativeQuery = true)
    public List<Menu> getAllcheckedMenus();

    @Query(value = "select * from \"Menu\" where \"level\"= 1; ", nativeQuery = true)
    public List<Menu> getAllFirstLevelMenus();

    @Query(value = "select * from \"Menu\" where \"idparent\" =:id and \"level\"=:level ", nativeQuery = true)
    public List<Menu> getlistbyidandlevel(@Param("id") Long id, @Param("level") int level);

    //aatini el idparent (yaani el pere) ta3 el menu illi l'id te3ou =:id
    @Query(value = "select idparent from \"Menu\" where \"id\" =:id", nativeQuery = true)
    public Long getidparent(@Param("id") Long id);

    //aatini les menu lkoll illi l'idparent te3hom =:idparent (yaani l'id ta3 leur pere =:idparent)
    @Query(value = "select * from \"Menu\" where \"idparent\" =:idparent", nativeQuery = true)
    public List<Menu> getid(@Param("idparent") Long idparent);

    @Query(value = "select * from \"Menu\" m where \"name\" = :name",nativeQuery = true)
    public Menu getMenuByName(@Param("name") String name);

}
