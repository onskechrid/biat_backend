package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.AttachementReclamation;

@Repository
public interface AttachementReclamationRepository extends JpaRepository<AttachementReclamation, Long> {
}
