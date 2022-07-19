package com.museu.service;

import com.museu.configuration.Configuracoes;
import com.museu.dtos.Consulta1Dto;
import com.museu.dtos.Consulta2Dto;
import com.museu.model.ObjetosArte;
import com.museu.model.Permanentes;
import com.museu.repository.ObjetosArteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObjetosArteService {

    @Autowired
    private ObjetosArteRepository repository;
    @Autowired
    private EntityManager em;
    @Autowired
    private Configuracoes configs;

    //public List<Consulta1Dto> getByTipoEClasse(){
        //return repository.listByTipoEClasse();
    //}

    public List<Consulta1Dto> getConsulta1(){
        ArrayList<Consulta1Dto> consulta1Dto = new ArrayList<>();
        List<Object[]> result = this.repository.listByTipoEClasse();
        for (Object[] row : result) {
            Consulta1Dto container = new Consulta1Dto();
            container.setIdObj((int) row[0]);
            container.setTitulo((String) row[1]);
            container.setTipo((String) row[2]);
            container.setClasse((String) row[3]);

            consulta1Dto.add(container);
        }

        return consulta1Dto;
    }
}
