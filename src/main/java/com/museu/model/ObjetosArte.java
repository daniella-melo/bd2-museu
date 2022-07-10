package com.museu.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="objetos_arte")
public class ObjetosArte {

    @Id
    @NotNull
    @Column(name = "NumId")
    private int numId;

    @NotNull
    @Column(name = "Titulo")
    private String titulo;

    @NotNull
    @Column(name = "Descricao")
    private String descricao;

    @NotNull
    @Column(name = "AnoCriacao")
    private String anoCriacao;

    @NotNull
    @Column(name = "PeriodoObj")
    private String periodoObj;

    @NotNull
    @Column(name = "PaisCultura")
    private String paisCultura;

    @NotNull
    @Column(name = "Estilo")
    private String estilo;

    @NotNull
    @Column(name = "TipoObjArt")
    private String tipoObjArt;

    @NotNull
    @Column(name = "CatObjArt")
    private String catObjArt;

    @NotNull
    @Column(name = "NomeArt")
    private String nomeArt;

    public ObjetosArte(int numId, String titulo, String descricao, String anoCriacao, String periodoObj, String paisCultura, String estilo, String tipoObjArt, String catObjArt, String nomeArt) {
        this.numId = numId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.anoCriacao = anoCriacao;
        this.periodoObj = periodoObj;
        this.paisCultura = paisCultura;
        this.estilo = estilo;
        this.tipoObjArt = tipoObjArt;
        this.catObjArt = catObjArt;
        this.nomeArt = nomeArt;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(String anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public String getPeriodoObj() {
        return periodoObj;
    }

    public void setPeriodoObj(String periodoObj) {
        this.periodoObj = periodoObj;
    }

    public String getPaisCultura() {
        return paisCultura;
    }

    public void setPaisCultura(String paisCultura) {
        this.paisCultura = paisCultura;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getTipoObjArt() {
        return tipoObjArt;
    }

    public void setTipoObjArt(String tipoObjArt) {
        this.tipoObjArt = tipoObjArt;
    }

    public String getCatObjArt() {
        return catObjArt;
    }

    public void setCatObjArt(String catObjArt) {
        this.catObjArt = catObjArt;
    }

    public String getNomeArt() {
        return nomeArt;
    }

    public void setNomeArt(String nomeArt) {
        this.nomeArt = nomeArt;
    }
}
