package com.museu.service;

import com.museu.dtos.Consulta1Dto;
import com.museu.dtos.Consulta3Dto;
import com.museu.model.Permanentes;
import com.museu.repository.PermanentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PermanentesService {
    @Autowired
    private PermanentesRepository repository;
    @Autowired
    private EntityManager em;

    public List<Consulta3Dto> getComprasObjetos(){
        ArrayList<Consulta3Dto> consulta3Dto = new ArrayList<>();
        TypedQuery<Object[]> query = em.createQuery(
                "select SUM(pe.custo) as custo_total, SUBSTRING(CAST(pe.dataaquisicao as varchar), 6, 2) as numMes, " +
                        "CASE WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 1 THEN 'JANEIRO' " +
                        "WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 2 THEN 'FEVEREIRO' " +
                        "WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 3 THEN 'MARÇO' " +
                        "WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 4 THEN 'ABRIL' " +
                        "WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 5 THEN 'MAIO' " +
                        "WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 6 THEN 'JUNHO' " +
                        "WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 7 THEN 'JULHO' " +
                        "WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 8 THEN 'AGOSTO' " +
                        "WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 9 THEN 'SETEMBRO' " +
                        "WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 10 THEN 'OUTUBRO' " +
                        "WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 11 THEN 'NOVEMBRO' " +
                        "WHEN SUBSTRING(pe.dataaquisicao, 6, 2) = 12 THEN 'DEZEMBRO' " +
                        "END as mes, " +
                        "SUBSTRING(pe.dataaquisicao, 1, 4) as ano from Permanentes pe group by numMes, ano " +
                        "order by numMes, ano", Object[].class);

        for (Object[] row : query.getResultList()) {
            Consulta3Dto container = new Consulta3Dto();
            container.setCustoTotal((BigDecimal) row[0]);
            container.setNumMes((int) row[1]);
            //container.setMes((String) row[2]);
            container.setAno((String) row[3]);

            consulta3Dto.add(container);
        }
        return consulta3Dto;
    }

    public List<Permanentes> getByPeriod(int mes, int ano){
        TypedQuery<Permanentes> query = em.createQuery(
                "select * from Permanentes pe WHERE EXTRACT(month from pe.dataaquisicao) = " + mes +" and " +
                        "EXTRACT(year from pe.dataaquisicao) = " + ano, Permanentes.class);
        return query.getResultList();

    }

}
