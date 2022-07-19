package com.museu.model;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name="outros")
public class Outros {

    @Id
    @NotNull
    @Column(name = "numobj3")
    private int numObj3;

    @NotNull
    @Column(name = "tipo")
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
