package com.museu.service;

import com.museu.dtos.Consulta1Dto;
import com.museu.dtos.Consulta2Dto;
import com.museu.repository.ColecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class ColecaoService {

    @Autowired
    private ColecaoRepository repository;
    @Autowired
    private EntityManager em;

    public List<Consulta2Dto> getConsulta2(){
        ArrayList<Consulta2Dto> consulta2Dto = new ArrayList<>();
        //return this.repository.getEmprestimosPorColecao();
        TypedQuery<Object[]> query = em.createQuery(
                "select count(e.numObj4) as qtd_total_objetos, co.nomecol from Colecao co join Emprestados e on e.nomecolpert = co.nomecol group by co.nomecol order by qtd_total_objetos desc", Object[].class);
        for (Object[] row : query.getResultList()) {
            Consulta2Dto container = new Consulta2Dto();
            container.setQtdTotalObjetos((Long) row[0]);
            container.setNomeCol((String) row[1]);

            consulta2Dto.add(container);
        }

        return consulta2Dto;
    }
}
