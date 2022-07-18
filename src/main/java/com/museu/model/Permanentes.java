package com.museu.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="permanentes")
public class Permanentes {

    @Id
    @NotNull
    @Column(name = "numobj5")
    private int numObj5;

    @NotNull
    @Column(name = "dataaquisicao")
    private Timestamp dataAquisicao;

    @NotNull
    @Column(name = "emexposicao")
    private Boolean emExposicao;

    @NotNull
    @Column(name = "custo")
    private BigDecimal custo;

    public Permanentes(int numObj5, Timestamp dataAquisicao, Boolean emExposicao, BigDecimal custo) {
        this.numObj5 = numObj5;
        this.dataAquisicao = dataAquisicao;
        this.emExposicao = emExposicao;
        this.custo = custo;
    }

    public int getNumObj5() {
        return numObj5;
    }

    public void setNumObj5(int numObj5) {
        this.numObj5 = numObj5;
    }

    public Timestamp getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Timestamp dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Boolean getEmExposicao() {
        return emExposicao;
    }

    public void setEmExposicao(Boolean emExposicao) {
        this.emExposicao = emExposicao;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }
}
