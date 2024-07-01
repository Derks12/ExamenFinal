package org.example.exfinal.repository;

import org.example.exfinal.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PaisRepository extends JpaRepository<Pais, Integer> {
}
