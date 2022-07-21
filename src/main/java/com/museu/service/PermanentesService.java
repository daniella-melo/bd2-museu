package com.museu.service;

import com.museu.configuration.Configuracoes;
import com.museu.dtos.Consulta1Dto;
import com.museu.dtos.Consulta3Dto;
import com.museu.dtos.Consulta3Dto;
import com.museu.dtos.ObjCompradosPorMesDto;
import com.museu.dtos.ObjCompradosPorAnoDto;
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
    @Autowired
    private Configuracoes configs;


    public List<Consulta3Dto> getComprasObjetos(){
        ArrayList<Consulta3Dto> consulta3Dto = new ArrayList<>();
        List<Object[]> result = this.repository.listCompras();

        for (Object[] row : result) {
            Consulta3Dto container = new Consulta3Dto();
            container.setCustoTotal((BigDecimal) row[0]);
            container.setNumMes((BigDecimal) row[1]);
            container.setMes((String) row[2]);
            container.setAno((BigDecimal) row[3]);

            consulta3Dto.add(container);
        }
        return consulta3Dto;
    }

    public List<ObjCompradosPorMesDto> getListEmprestadosPorMes(){
        ArrayList<ObjCompradosPorMesDto> objCompradosPorMesDto = new ArrayList<>();
        List<Object[]> result = this.repository.listTotalComprasPorMes();

        for (Object[] row : result) {
            ObjCompradosPorMesDto container = new ObjCompradosPorMesDto();
            container.setCustoTotal((BigDecimal) row[0]);
            container.setNummes((BigDecimal) row[1]);
            container.setMes((String) row[2]);

            objCompradosPorMesDto.add(container);
        }
        return objCompradosPorMesDto;
    }

    public List<ObjCompradosPorAnoDto> getListEmprestadosPorAno(){
        ArrayList<ObjCompradosPorAnoDto> objCompradosPorAnoDto = new ArrayList<>();
        List<Object[]> result = this.repository.listTotalComprasPorAno();

        for (Object[] row : result) {
            ObjCompradosPorAnoDto container = new ObjCompradosPorAnoDto();
            container.setCustoTotal((BigDecimal) row[0]);
            container.setAno((String) row[1]);

            objCompradosPorAnoDto.add(container);
        }
        return objCompradosPorAnoDto;
    }
    
    public List<Permanentes> getByPeriod(int mes, int ano){
        TypedQuery<Permanentes> query = em.createQuery(
                "select * from museu.Permanentes pe WHERE EXTRACT(month from pe.dataaquisicao) = " + mes +" and " +
                        "EXTRACT(year from pe.dataaquisicao) = " + ano, Permanentes.class);
        return query.getResultList();

    }

}
