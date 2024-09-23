package com.complexivo.gestion.service;

import com.complexivo.gestion.model.Docente;

import java.util.List;
import java.util.Optional;

public interface DocenteService {
    List<Docente> findAll();
    Docente saveDocente(Docente docente);
    Docente findById(Long id);
    void deleteDocente(Long id);
}
