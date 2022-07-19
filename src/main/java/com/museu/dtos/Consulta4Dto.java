package com.museu.dtos;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class Consulta4Dto {

    private String nomecol;
    private BigInteger qtdobjemprestados;
    private BigDecimal nummes;
    private String mes;
    private BigDecimal ano;

    public Consulta4Dto(){}
    
    public Consulta4Dto(String nomecol, BigInteger qtdobjemprestados, BigDecimal nummes, String mes, BigDecimal ano) {
        this.nomecol = nomecol;
        this.qtdobjemprestados = qtdobjemprestados;
        this.nummes = nummes;
        this.mes = mes;
        this.ano = ano;
    }

    public String getNomecol() {
        return nomecol;
    }

    public void setNomecol(String nomecol) {
        this.nomecol = nomecol;
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

    public BigDecimal getAno() {
        return ano;
    }

    public void setAno(BigDecimal ano) {
        this.ano = ano;
    }

}