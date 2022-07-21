package com.museu.dtos;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class EmprestadosPorColecaoDto {

    private String nomecol;
    private BigInteger qtdobjemprestados;
    

    public EmprestadosPorColecaoDto(){}
    
    public EmprestadosPorColecaoDto(BigInteger qtdobjemprestados, String nomecol) {
        this.qtdobjemprestados = qtdobjemprestados;
        this.nomecol = nomecol;
    }

    public BigInteger getQtdobjemprestados() {
        return qtdobjemprestados;
    }

    public void setQtdobjemprestados(BigInteger qtdobjemprestados) {
        this.qtdobjemprestados = qtdobjemprestados;
    }

    public String getCol() {
        return nomecol;
    }

    public void setCol(String nomecol) {
        this.nomecol = nomecol;
    }
}