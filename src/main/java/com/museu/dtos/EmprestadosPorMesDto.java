package com.museu.dtos;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class EmprestadosPorMesDto {

    private BigInteger qtdobjemprestados;
    private BigDecimal nummes;
    private String mes;

    public EmprestadosPorMesDto(){}
    
    public EmprestadosPorMesDto(BigInteger qtdobjemprestados, BigDecimal nummes, String mes) {
        this.qtdobjemprestados = qtdobjemprestados;
        this.nummes = nummes;
        this.mes = mes;
    }

    public BigInteger getQtdobjemprestados() {
        return qtdobjemprestados;
    }

    public void setQtdobjemprestados(BigInteger qtdobjemprestados) {
        this.qtdobjemprestados = qtdobjemprestados;
    }

    public BigDecimal getNummes() {
        return nummes;
    }

    public void setNummes(BigDecimal nummes) {
        this.nummes = nummes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

}