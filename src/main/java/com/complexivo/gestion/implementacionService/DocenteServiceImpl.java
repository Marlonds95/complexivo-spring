package com.complexivo.gestion.implementacionService;

import com.complexivo.gestion.model.Docente;
import com.complexivo.gestion.repository.DocenteRepository;
import com.complexivo.gestion.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    @Override
    public Docente saveDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public Docente findById(Long id) {
        return docenteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDocente(Long id) {
        docenteRepository.deleteById(id);
    }
}


