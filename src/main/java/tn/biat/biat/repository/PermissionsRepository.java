package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import tn.biat.biat.entities.otherDB.Permissions;

import java.util.List;


@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Long> {

    @Query(value = "DELETE FROM \"Profile_permissions\" WHERE \"permissions_id\" = :id", nativeQuery = true)
    public void deleteProfilePermissionsByPermissionId(@Param("id") Long id);

    @DeleteMapping
    @Query(value = "DELETE FROM \"Permissions\" WHERE \"id\" = :id", nativeQuery = true)
    public void deletePermissionsById(@Param("id") Long id);

    @Query(value = "SELECT * from \"Permissions\" WHERE \"menu_id\" = :id", nativeQuery = true)
    public List<Permissions> getByMenuId(@Param("id") Long id);

}
