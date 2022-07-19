package com.museu.repository;

import com.museu.dtos.Consulta2Dto;
import com.museu.model.Colecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColecaoRepository extends JpaRepository<Colecao, Integer> {

    @Query(value = "select count(e.numObj4) as qtd_total_objetos, co.nomecol from Colecao co join Emprestados e on e.nomecolpert = co.nomecol group by co.nomecol order by count(e.numObj4) desc", nativeQuery = true)
    List<Consulta2Dto> getEmprestimosPorColecao();
}
