package com.museu.dtos;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Consulta1Dto {

    private Long idObj;
    private String titulo;
    private String tipo;
    private String classe;


    // public Consulta1Dto(int idObj, String titulo, String tipo, String classe) {
    //    this.idObj = idObj;
    //    this.titulo = titulo;
    //    this.tipo = tipo;
    //    this.classe = classe;
    //}

    public Long getIdObj() {
        return idObj;
    }

    public void setIdObj(Long idObj) {
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
