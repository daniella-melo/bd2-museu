package com.museu.repository;

import com.museu.dtos.Consulta1Dto;
import com.museu.model.ObjetosArte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjetosArteRepository extends JpaRepository<ObjetosArte, Integer> {

    @Query(value = "select CAST(SUM(pe.custo) as money) as custo_total,\n" +
            "CASE\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 1 THEN 'JANEIRO'\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 2 THEN 'FEVEREIRO'\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 3 THEN 'MARÇO'\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 4 THEN 'ABRIL'\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 5 THEN 'MAIO'\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 6 THEN 'JUNHO'\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 7 THEN 'JULHO'\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 8 THEN 'AGOSTO'\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 9 THEN 'SETEMBRO'\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 10 THEN 'OUTUBRO'\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 11 THEN 'NOVEMBRO'\n" +
            "\tWHEN EXTRACT(month from pe.dataaquisicao) = 12 THEN 'DEZEMBRO'\n" +
            "END as mes,\n" +
            "EXTRACT(year from pe.dataaquisicao) as ano\n" +
            "from permanentes pe\n" +
            "group by EXTRACT(month from pe.dataaquisicao), ano\n" +
            "order by EXTRACT(month from pe.dataaquisicao), ano;", nativeQuery = true)
    List<Consulta3Dto> listCompras();
}