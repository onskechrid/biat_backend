package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.Profile;

@Repository
public interface ProfilesRepository extends JpaRepository<Profile, Long> {

}
