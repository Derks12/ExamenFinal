package org.example.exfinal.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "juegos")
@Getter
@Setter

@JsonIgnoreProperties(value = {"idgenero", "iddistribuidora", "ideditora", "idplataforma"})


public class Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego", nullable = false)
    private Integer idjuego;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Generos genero;

    @ManyToOne
    @JoinColumn(name = "idplataforma")
    private Plataformas plataforma;

    @ManyToOne
    @JoinColumn(name = "ideditora")
    private Editoras editora;

    @ManyToOne
    @JoinColumn(name = "iddistribuidora")
    private Distribuidoras distibuidora;


}
