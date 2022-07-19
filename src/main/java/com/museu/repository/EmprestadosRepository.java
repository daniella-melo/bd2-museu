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

}
