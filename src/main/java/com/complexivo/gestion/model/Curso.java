package com.complexivo.gestion.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    private String nombreCurso;
    private String nivel;

    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;
}
