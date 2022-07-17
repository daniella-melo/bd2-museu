package com.museu.service;

import com.museu.dtos.Consulta1Dto;
import com.museu.repository.ObjetosArteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetosArteService {

    @Autowired
    private ObjetosArteRepository repository;

    public List<Consulta1Dto> getByTipoEClasse(){
        return repository.listByTipoEClasse();
    }

}
