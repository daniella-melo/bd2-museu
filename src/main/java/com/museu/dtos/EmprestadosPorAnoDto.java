package com.museu.dtos;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class EmprestadosPorAnoDto {

    private BigInteger qtdobjemprestados;
    private String ano;

    public EmprestadosPorAnoDto(){}
    
    public EmprestadosPorAnoDto(BigInteger qtdobjemprestados, String ano) {
        this.qtdobjemprestados = qtdobjemprestados;
        this.ano = ano;
    }

    public BigInteger getQtdobjemprestados() {
        return qtdobjemprestados;
    }

    public void setQtdobjemprestados(BigInteger qtdobjemprestados) {
        this.qtdobjemprestados = qtdobjemprestados;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}