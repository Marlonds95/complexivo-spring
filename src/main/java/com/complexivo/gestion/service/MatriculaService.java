package com.complexivo.gestion.service;

import com.complexivo.gestion.model.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    List<Matricula> findAll();
    Matricula saveMatricula(Matricula matricula);
    Matricula findById(Long id);
    void deleteMatricula(Long id);
}
