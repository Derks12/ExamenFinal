package org.example.exfinal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigDecimal;

@Entity
@Table(name = "distribuidoras")
@Getter
@Setter

@JsonIgnoreProperties(value = {"iddistribuidora"})

public class Distribuidoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddistribuidora",nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fundacion")
    private Integer fundacion;

    @Column(name = "web")
    private String web;

    @ManyToOne
    @JoinColumn(name = "idsede")
    private Pais pais;
}
