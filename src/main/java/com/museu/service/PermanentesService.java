package com.museu.service;

import com.museu.dtos.Consulta3Dto;
import com.museu.model.Permanentes;
import com.museu.repository.PermanentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class PermanentesService {
    @Autowired
    private PermanentesRepository repository;
    @Autowired
    private EntityManager em;

    public List<Consulta3Dto> getComprasObjetos(){
        return repository.listCompras();
    }

    public List<Permanentes> getByPeriod(int mes, int ano){
        TypedQuery<Permanentes> query = em.createQuery(
                "select *\n" +
                        "from permanentes pe\n" +
                        "WHERE EXTRACT(month from pe.dataaquisicao) = " + mes +" and\n" +
                        "EXTRACT(year from pe.dataaquisicao) = " + ano, Permanentes.class);
        return query.getResultList();
    }

}
