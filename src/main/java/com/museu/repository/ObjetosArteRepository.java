package com.museu.repository;

import com.museu.dtos.Consulta1Dto;
import com.museu.model.ObjetosArte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjetosArteRepository extends JpaRepository<ObjetosArte, Integer> {
    
    //lista de objetos de arte comprados por tipo e por classe (emprestado ou proprio)
    @Query(value = "select oa.numId as id_objeto, oa.titulo, oa.tipoObjArt as tipo, " +
            "CASE WHEN e.numObj4 IS NULL then 'PERMANENTE' " +
            "WHEN pe.numObj5 IS NULL then 'EMPRESTADO' " +
            "ELSE 'OUTROS' END as classe " +
            "from museu.ObjetosArte oa " +
            "full join museu.Emprestados e on e.numObj4 = oa.numId " +
            "full join museu.Permanentes pe on pe.numObj5 = oa.numId", nativeQuery = true)
    List<Object[]> listByTipoEClasse();
}
