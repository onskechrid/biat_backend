package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.biat.biat.entities.otherDB.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    public User findByUserName(String userName);

    @Query("SELECT Count(*) FROM User")
    public Integer getNumberUsers();

    @Query("SELECT u FROM User u where u.Libelle = :lib")
    public List<User> geAlltByLib(@Param("lib") String lib);
}