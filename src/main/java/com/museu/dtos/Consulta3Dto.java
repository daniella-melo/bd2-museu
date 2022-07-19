package com.museu.dtos;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Consulta3Dto {

    private BigDecimal custoTotal;
    private int numMes;
    private String mes;
    private String ano;

    //public Consulta3Dto(BigDecimal custoTotal, String mes, String ano, int numMes) {
    //    this.custoTotal = custoTotal;
    //     this.mes = mes;
    //     this.ano = ano;
    //    this.numMes = numMes;
    // }

    public BigDecimal getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(BigDecimal custoTotal) {
        this.custoTotal = custoTotal;
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
        return numMes;
    }

    public void setNumMes(int numMes) {
        this.numMes = numMes;
    }
}
