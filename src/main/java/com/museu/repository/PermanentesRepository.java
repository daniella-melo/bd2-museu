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

    //Listagem da compra de objetos de arte por mes e por ano
    @Query(value = "select SUM(oa.custo) as custototal, EXTRACT(month from pe.dataaquisicao) as nummes, " +
            "CASE WHEN EXTRACT(month from pe.dataaquisicao) = 1 THEN 'JANEIRO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 2 THEN 'FEVEREIRO' " +
            "WHEN EXTRACT(month from pe.dataaquisicao) = 3 THEN 'MARCO' " +
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
            "from museu.Permanentes pe " +
            "inner join museu.ObjetosArte oa on oa.numid = pe.numobj5 "+
            "group by nummes, ano " +
            "order by nummes, ano", nativeQuery = true)
    List<Object[]> listCompras();

     //listagem da quantidade de objetos emprestados por mes em todos os anos
    @Query(value="select SUM(oa.custo) as custototal, "+
                "EXTRACT(month from pe.dataaquisicao) as nummes, "+
                "CASE "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 1 THEN 'JANEIRO' "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 2 THEN 'FEVEREIRO' "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 3 THEN 'MARÇO' "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 4 THEN 'ABRIL' "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 5 THEN 'MAIO' "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 6 THEN 'JUNHO' "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 7 THEN 'JULHO' "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 8 THEN 'AGOSTO' "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 9 THEN 'SETEMBRO' "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 10 THEN 'OUTUBRO' "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 11 THEN 'NOVEMBRO' "+
                "    WHEN EXTRACT(month from pe.dataaquisicao) = 12 THEN 'DEZEMBRO' "+
                "END as mes "+
                "from museu.Permanentes pe "+
                "inner join museu.ObjetosArte oa on oa.numid = pe.numobj5 "+
                "group by nummes, mes "+
                "order by nummes", nativeQuery= true)
    List<Object[]> listTotalComprasPorMes();

    @Query(value="select SUM(oa.custo) as custottotal, " +
            "SUBSTRING(CAST(pe.dataaquisicao as varchar), 1, 4)  as ano " +
            "from museu.Permanentes pe " +
            "inner join museu.ObjetosArte oa on oa.numid = pe.numobj5 " +
            "group by ano " +
            "order by ano", nativeQuery = true)
    List<Object[]> listTotalComprasPorAno();

}
