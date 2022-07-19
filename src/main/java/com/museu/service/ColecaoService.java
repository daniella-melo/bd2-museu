package com.museu.service;

import com.museu.configuration.Configuracoes;
import com.museu.dtos.Consulta1Dto;
import com.museu.dtos.Consulta2Dto;
import com.museu.repository.ColecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class ColecaoService {

    @Autowired
    private ColecaoRepository repository;
    @Autowired
    private EntityManager em;
    @Autowired
    private Configuracoes configs;

    public List<Consulta2Dto> getConsulta2(){
        ArrayList<Consulta2Dto> consulta2Dto = new ArrayList<>();
        List<Object[]> result = this.repository.getEmprestimosPorColecao();
        for (Object[] row : result) {
            Consulta2Dto container = new Consulta2Dto();
            container.setQtdTotalObjetos((int) row[0]);
            container.setNomeCol((String) row[1]);

            consulta2Dto.add(container);
        }

        return consulta2Dto;
    }
}
