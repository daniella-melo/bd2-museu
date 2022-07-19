package com.museu.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name="pinturas")
public class Pinturas {

    @Id
    @NotNull
    @Column(name = "numobj1")
    private int numObj1;

    @NotNull
    @Column(name = "tipotinta")
    private String tipoTinta;

    @NotNull
    @Column(name = "suporte")
    private String suporte;

    public Pinturas(){}

    public Pinturas(int numObj1, String tipoTinta, String suporte) {
        this.numObj1 = numObj1;
        this.tipoTinta = tipoTinta;
        this.suporte = suporte;
    }

    public int getNumObj1() {
        return numObj1;
    }

    public void setNumObj1(int numObj1) {
        this.numObj1 = numObj1;
    }

    public String getTipoTinta() {
        return tipoTinta;
    }

    public void setTipoTinta(String tipoTinta) {
        this.tipoTinta = tipoTinta;
    }

    public String getSuporte() {
        return suporte;
    }

    public void setSuporte(String suporte) {
        this.suporte = suporte;
    }
}
