package com.museu.model;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.text.DecimalFormat;

@Entity
@Table(name="esculturas")
public class Esculturas {

    @Id
    @NotNull
    @Column(name = "NumObj2")
    private int numObj2;

    @NotNull
    @Column(name = "Material")
    private String material;

    @NotNull
    @Column(name = "Altura")
    private Double altura;

    @NotNull
    @Column(name = "Peso")
    private Double peso;

    public Esculturas(int numObj2, String material, Double altura, Double peso) {
        this.numObj2 = numObj2;
        this.material = material;
        this.altura = altura;
        this.peso = peso;
    }

    public int getNumObj2() {
        return numObj2;
    }

    public void setNumObj2(int numObj2) {
        this.numObj2 = numObj2;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
