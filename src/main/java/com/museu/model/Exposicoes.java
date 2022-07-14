package com.museu.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="exposicoes")
public class Exposicoes {

    @NotNull
    @Column(name = "NomeExp")
    private String nomeExp;

    @NotNull
    @Column(name = "DataInicio")
    private Timestamp dataInicio;

    @NotNull
    @Column(name = "DataFinal")
    private Timestamp dataFinal;

    public Exposicoes(String nomeExp, Timestamp dataInicio, Timestamp dataFinal) {
        this.nomeExp = nomeExp;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public String getNomeExp() {
        return nomeExp;
    }

    public void setNomeExp(String nomeExp) {
        this.nomeExp = nomeExp;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Timestamp dataFinal) {
        this.dataFinal = dataFinal;
    }
}
