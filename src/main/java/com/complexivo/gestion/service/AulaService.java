package com.complexivo.gestion.service;

import com.complexivo.gestion.model.Aula;

import java.util.List;
import java.util.Optional;

public interface AulaService {
    List<Aula> findAll();
    Aula saveAula(Aula aula);
    Aula findById(Long id);
    void deleteAula(Long id);
}
