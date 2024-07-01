package org.example.exfinal.repository;

import org.example.exfinal.entity.Editoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EditorasRepository extends JpaRepository<Editoras, Integer> {
}
