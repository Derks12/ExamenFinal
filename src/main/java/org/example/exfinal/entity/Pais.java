package org.example.exfinal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paises")
@Getter
@Setter

@JsonIgnoreProperties(value = {"idpais"})

public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpais")
    private Integer id;

    @Column(name = "iso")
    private String iso;

    @Column(name = "nombre")
    private String nombre;
}
