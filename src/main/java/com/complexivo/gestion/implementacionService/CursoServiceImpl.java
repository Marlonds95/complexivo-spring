package com.complexivo.gestion.implementacionService;


import com.complexivo.gestion.model.Curso;
import com.complexivo.gestion.repository.CursoRepository;
import com.complexivo.gestion.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}

