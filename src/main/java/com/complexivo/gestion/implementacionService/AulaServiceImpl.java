package com.complexivo.gestion.implementacionService;

import com.complexivo.gestion.model.Aula;
import com.complexivo.gestion.repository.AulaRepository;
import com.complexivo.gestion.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public List<Aula> findAll() {
        return aulaRepository.findAll();
    }

    @Override
    public Aula saveAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public Aula findById(Long id) {
        return aulaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAula(Long id) {
        aulaRepository.deleteById(id);
    }
}


