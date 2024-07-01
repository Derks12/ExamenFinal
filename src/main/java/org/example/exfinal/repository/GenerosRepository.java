package org.example.exfinal.repository;

import org.example.exfinal.entity.Generos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface GenerosRepository extends JpaRepository<Generos, Integer> {
}
