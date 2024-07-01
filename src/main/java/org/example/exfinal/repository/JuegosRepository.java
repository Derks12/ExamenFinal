package org.example.exfinal.repository;

import org.example.exfinal.entity.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface JuegosRepository extends JpaRepository<Juegos, Integer> {
}
