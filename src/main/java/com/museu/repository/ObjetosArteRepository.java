package com.museu.repository;

import com.museu.model.ObjetosArte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjetosArteRepository extends JpaRepository<ObjetosArte, Integer> {

    // @Query(value = "SELECT a.id_cliente FROM livraria.Cliente a ORDER BY a.id_cliente DESC LIMIT 1", nativeQuery = true)
    // Collection<ObjetosArte> artObjectsByType(String type);

}