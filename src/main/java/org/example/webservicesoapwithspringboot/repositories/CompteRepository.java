package org.example.webservicesoapwithspringboot.repositories;

import org.example.webservicesoapwithspringboot.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
