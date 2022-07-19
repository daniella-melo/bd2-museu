package com.museu.dtos;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Consulta3Dto {

    private BigDecimal custototal;
    private BigDecimal nummes;
    private String mes;
    private BigDecimal ano;

    public Consulta3Dto(){}
    public Consulta3Dto(BigDecimal custoTotal, String mes, BigDecimal ano, BigDecimal numMes) {
        this.custototal = custoTotal;
        this.mes = mes;
        this.ano = ano;
        this.nummes = numMes;
     }

    public BigDecimal getCustoTotal() {
        return custototal;
    }

    public void setCustoTotal(BigDecimal custototal) {
        this.custototal = custototal;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public BigDecimal getAno() {
        return ano;
    }

    public void setAno(BigDecimal ano) {
        this.ano = ano;
    }

    public BigDecimal getNumMes() {
        return nummes;
    }

    public void setNumMes(BigDecimal nummes) {
        this.nummes = nummes;
    }
}
