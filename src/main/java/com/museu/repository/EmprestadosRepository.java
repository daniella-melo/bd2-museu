package com.museu.repository;

import com.museu.dtos.Consulta2Dto;
import com.museu.model.Emprestados;
import com.museu.model.Permanentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestadosRepository extends JpaRepository<Emprestados, Integer> {
    
    @Query(value = "select co.nomeCol, count(e.numObj4) as qtd_obj_emprestados, " +
            "EXTRACT(month from e.dataemprestimo) as nummes, " +
            "CASE " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 1 THEN 'JANEIRO' " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 2 THEN 'FEVEREIRO' " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 3 THEN 'MARÇO' " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 4 THEN 'ABRIL' " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 5 THEN 'MAIO' " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 6 THEN 'JUNHO' " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 7 THEN 'JULHO' " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 8 THEN 'AGOSTO' " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 9 THEN 'SETEMBRO' " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 10 THEN 'OUTUBRO' " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 11 THEN 'NOVEMBRO' " +
            "WHEN EXTRACT(month from e.dataemprestimo) = 12 THEN 'DEZEMBRO' " +
            "END as mes, " +
            "EXTRACT(year from e.dataemprestimo) as ano " +
            "from museu.Colecao co " +
            "join museu.Emprestados e on e.nomeColPert = co.nomeCol " +
            "group by co.nomeCol, nummes, ano " +
            "order by nummes, ano", nativeQuery = true)
    List<Object[]> listEmprestadosPorColecao();
}
