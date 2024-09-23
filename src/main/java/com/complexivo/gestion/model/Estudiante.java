package com.complexivo.gestion.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    private String nombre;
    private Date fechaNacimiento;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;
}
