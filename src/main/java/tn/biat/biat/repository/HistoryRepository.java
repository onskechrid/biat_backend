package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.otherDB.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
}
