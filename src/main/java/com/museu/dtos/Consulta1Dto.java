package com.museu.dtos;

import org.springframework.stereotype.Component;

@Component
public class Consulta1Dto {

    private int idObj;
    private String titulo;
    private String tipo;
    private String classe;

    public Consulta1Dto(int idObj, String titulo, String tipo, String classe) {
        this.idObj = idObj;
        this.titulo = titulo;
        this.tipo = tipo;
        this.classe = classe;
    }

    public int getIdObj() {
        return idObj;
    }

    public void setIdObj(int idObj) {
        this.idObj = idObj;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}
