package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.Composant;

@Repository
public interface ComposantRepository extends JpaRepository<Composant, Long> {
}
