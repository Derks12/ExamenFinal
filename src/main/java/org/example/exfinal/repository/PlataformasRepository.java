package org.example.exfinal.repository;

import org.example.exfinal.entity.Plataformas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PlataformasRepository extends JpaRepository<Plataformas, Integer> {
}
