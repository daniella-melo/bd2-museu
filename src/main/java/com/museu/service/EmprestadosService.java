package com.museu.service;

import com.museu.configuration.Configuracoes;
import com.museu.dtos.Consulta4Dto;
import com.museu.model.Emprestados;
import com.museu.dtos.EmprestadosPorMesDto;
import com.museu.dtos.EmprestadosPorAnoDto;
import com.museu.dtos.EmprestadosPorColecaoDto;
import com.museu.repository.EmprestadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestadosService {
    @Autowired
    private EmprestadosRepository repository;
    @Autowired
    private EntityManager em;


    public List<Consulta4Dto> getListEmprestadosPorColecao(){
        ArrayList<Consulta4Dto> consulta4Dto = new ArrayList<>();
        List<Object[]> result = this.repository.listEmprestadosPorColecao();

        for (Object[] row : result) {
            Consulta4Dto container = new Consulta4Dto();
            container.setNomecol((String) row[0]);
            container.setQtdobjemprestados((BigInteger) row[1]);
            container.setNummes((BigDecimal) row[2]);
            container.setMes((String) row[3]);
            container.setAno((BigDecimal) row[4]);

            consulta4Dto.add(container);
        }
        return consulta4Dto;
    }

    public List<EmprestadosPorMesDto> getListEmprestadosPorMes(){
        ArrayList<EmprestadosPorMesDto> emprestadosPorMesDto = new ArrayList<>();
        List<Object[]> result = this.repository.listTotalEmprestadosPorMes();

        for (Object[] row : result) {
            EmprestadosPorMesDto container = new EmprestadosPorMesDto();
            container.setQtdobjemprestados((BigInteger) row[0]);
            container.setNummes((BigDecimal) row[1]);
            container.setMes((String) row[2]);

            emprestadosPorMesDto.add(container);
        }
        return emprestadosPorMesDto;
    }

    public List<EmprestadosPorAnoDto> getListEmprestadosPorAno(){
        ArrayList<EmprestadosPorAnoDto> emprestadosPorAnoDto = new ArrayList<>();
        List<Object[]> result = this.repository.listTotalEmprestadosPorAno();

        for (Object[] row : result) {
            EmprestadosPorAnoDto container = new EmprestadosPorAnoDto();
            container.setQtdobjemprestados((BigInteger) row[0]);
            container.setAno((String) row[1]);

            emprestadosPorAnoDto.add(container);
        }
        return emprestadosPorAnoDto;
    }

    public List<EmprestadosPorColecaoDto> getListTotalEmprestadosPorColecao(){
        ArrayList<EmprestadosPorColecaoDto> emprestadosPorColecaoDto = new ArrayList<>();
        List<Object[]> result = this.repository.listTotalEmprestadosPorColecao();

        for (Object[] row : result) {
            EmprestadosPorColecaoDto container = new EmprestadosPorColecaoDto();
             container.setCol((String) row[0]);
            container.setQtdobjemprestados((BigInteger) row[1]);

            emprestadosPorColecaoDto.add(container);
        }
        return emprestadosPorColecaoDto;
    }

    public List<Emprestados> getByPeriod(int mes, int ano){
        TypedQuery<Emprestados> query = em.createQuery(
                "select * from museu.Emprestados pe WHERE EXTRACT(month from e.dataemprestimo) = " + mes +" and " +
                        "EXTRACT(year from e.dataemprestimo) = " + ano, Emprestados.class);
        return query.getResultList();

    }
}