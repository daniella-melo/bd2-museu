package com.museu.service;

import com.museu.dtos.Consulta1Dto;
import com.museu.model.ObjetosArte;
import com.museu.model.Permanentes;
import com.museu.repository.ObjetosArteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
        TypedQuery<Consulta1Dto> query = em.createQuery(
                "select oa.numId as id_objeto, oa.titulo, oa.tipoObjArt as tipo, CASE WHEN e.numObj4 IS NULL then 'PERMANENTE' WHEN pe.numObj5 IS NULL then 'EMPRESTADO' ELSE 'OUTROS' END as classe from objetos_arte oa full join emprestados e on e.numObj4 = oa.numId full join permanentes pe on pe.numObj5 = oa.numId", Consulta1Dto.class);
        return query.getResultList();
    }
}
