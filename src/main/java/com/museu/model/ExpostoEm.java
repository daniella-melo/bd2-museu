package com.museu.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expostoEm")
public class ExpostoEm {

    @Id
    @NotNull
    @Column(name = "numobj6")
    private Long numObj6;

    @NotNull
    @Column(name = "nomeexpo")
    private String nomeExpo;

    public ExpostoEm(){}

    public ExpostoEm(Long numObj6, String nomeExpo) {
        this.numObj6 = numObj6;
        this.nomeExpo = nomeExpo;
    }

    public Long getNumObj6() {
        return numObj6;
    }

    public void setNumObj6(Long numObj6) {
        this.numObj6 = numObj6;
    }

    public String getNomeExpo() {
        return nomeExpo;
    }

    public void setNomeExpo(String nomeExpo) {
        this.nomeExpo = nomeExpo;
    }
}
