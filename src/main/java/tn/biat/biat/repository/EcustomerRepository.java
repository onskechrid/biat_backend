package tn.biat.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.biat.biat.entities.E_CUSTOMER;

@Repository
public interface EcustomerRepository extends JpaRepository<E_CUSTOMER, Integer> {
}
