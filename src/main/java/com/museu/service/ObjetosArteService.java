package com.museu.service;

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

    public List<Consulta1Dto> getByTipoEClasse(){
        return repository.listByTipoEClasse();
    }

    public List<Consulta1Dto> getConsulta1(){
        ArrayList<Consulta1Dto> consulta1Dto = new ArrayList<>();
        TypedQuery<Object[]> query = em.createQuery(
                "select oa.numId as id_objeto, oa.titulo, oa.tipoObjArt as tipo, CASE WHEN e.numObj4 IS NULL then 'PERMANENTE' WHEN pe.numObj5 IS NULL then 'EMPRESTADO' ELSE 'OUTROS' END as classe from ObjetosArte oa full join Emprestados e on e.numObj4 = oa.numId full join Permanentes pe on pe.numObj5 = oa.numId", Object[].class);
        for (Object[] row : query.getResultList()) {
            Consulta1Dto container = new Consulta1Dto();
            container.setIdObj((Long) row[0]);
            container.setTitulo((String) row[1]);
            container.setTipo((String) row[2]);
            container.setClasse((String) row[3]);

            consulta1Dto.add(container);
        }

        return consulta1Dto;
    }
}
