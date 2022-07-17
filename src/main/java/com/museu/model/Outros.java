package com.museu.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="outros")
public class Outros {

    @Id
    @NotNull
    @Column(name = "NumObj3")
    private int numObj3;

    @NotNull
    @Column(name = "Tipo")
    private String tipo;

    public Outros(int numObj3, String tipo) {
        this.numObj3 = numObj3;
        this.tipo = tipo;
    }

    public int getNumObj3() {
        return numObj3;
    }

    public void setNumObj3(int numObj3) {
        this.numObj3 = numObj3;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}