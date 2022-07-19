package com.museu.repository;

import com.museu.dtos.Consulta1Dto;
import com.museu.model.ObjetosArte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjetosArteRepository extends JpaRepository<ObjetosArte, Integer> {

    @Query(value = "select oa.numId as id_objeto, oa.titulo, oa.tipoObjArt as tipo, \n" +
            "CASE\n" +
            "\tWHEN e.numObj4 IS NULL then 'PERMANENTE'\n" +
            "\tWHEN pe.numObj5 IS NULL then 'EMPRESTADO'\n" +
            "\tELSE 'OUTROS'\n" +
            "END as classe\n" +
            "from ObjetosArte oa\n" +
            "full join Emprestados e on e.numObj4 = oa.numId\n" +
            "full join Permanentes pe on pe.numObj5 = oa.numId", nativeQuery = true)
    List<Consulta1Dto> listByTipoEClasse();
}
