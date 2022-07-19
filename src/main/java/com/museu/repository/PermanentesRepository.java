package com.museu.repository;

import com.museu.dtos.Consulta1Dto;
import com.museu.dtos.Consulta3Dto;
import com.museu.model.ObjetosArte;
import com.museu.model.Permanentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermanentesRepository extends JpaRepository<Permanentes, Integer> {

    @Query(value = "select SUM(pe.custo) as custototal, EXTRACT(month from pe.dataaquisicao) as nummes, " +
            "CASE WHEN EXTRACT(month from pe.dataaquisicao) = 1 THEN 'JANEIRO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 2 THEN 'FEVEREIRO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 3 THEN 'MARÇO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 4 THEN 'ABRIL' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 5 THEN 'MAIO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 6 THEN 'JUNHO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 7 THEN 'JULHO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 8 THEN 'AGOSTO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 9 THEN 'SETEMBRO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 10 THEN 'OUTUBRO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 11 THEN 'NOVEMBRO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 12 THEN 'DEZEMBRO' " +
            "END as mes, " +
            "EXTRACT(year from pe.dataaquisicao) as ano " +
            "from bd2.Permanentes pe " +
            "group by nummes, ano " +
            "order by nummes, ano", nativeQuery = true)
    List<Object[] > listCompras();

}
