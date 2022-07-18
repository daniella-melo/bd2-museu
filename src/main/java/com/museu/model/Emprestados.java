package com.museu.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="emprestados")
public class Emprestados {

    @Id
    @NotNull
    @Column(name = "numobj4")
    private int numObj4;


    @NotNull
    @Column(name = "dataemprestimo")
    private Timestamp dataEmprestimo;

    @NotNull
    @Column(name = "datadevolucao")
    private Timestamp dataDevolucao;

    @NotNull
    @Column(name = "nomecolpert")
    private String nomeColPert;

    public Emprestados(int numObj4, Timestamp dataEmprestimo, Timestamp dataDevolucao, String nomeColPert) {
        this.numObj4 = numObj4;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.nomeColPert = nomeColPert;
    }

    public int getNumObj4() {
        return numObj4;
    }

    public void setNumObj4(int numObj4) {
        this.numObj4 = numObj4;
    }

    public Timestamp getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Timestamp dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Timestamp getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Timestamp dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getNomeColPert() {
        return nomeColPert;
    }

    public void setNomeColPert(String nomeColPert) {
        this.nomeColPert = nomeColPert;
    }
}
