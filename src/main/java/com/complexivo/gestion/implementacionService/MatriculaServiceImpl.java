package com.complexivo.gestion.implementacionService;

import com.complexivo.gestion.model.Matricula;
import com.complexivo.gestion.repository.MatriculaRepository;
import com.complexivo.gestion.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula saveMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula findById(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }
}

