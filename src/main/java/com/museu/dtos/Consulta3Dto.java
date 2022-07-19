package com.museu.dtos;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Consulta3Dto {

    private BigDecimal custototal;
    private int nummes;
    private String mes;
    private String ano;

    //public Consulta3Dto(BigDecimal custoTotal, String mes, String ano, int numMes) {
    //    this.custoTotal = custoTotal;
    //     this.mes = mes;
    //     this.ano = ano;
    //    this.numMes = numMes;
    // }

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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getNumMes() {
        return nummes;
    }

    public void setNumMes(int nummes) {
        this.nummes = nummes;
    }
}
