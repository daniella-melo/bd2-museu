package com.museu.dtos;

import javax.persistence.*;

import java.math.BigDecimal;

import java.sql.Timestamp;

public class ObjetosArteDto {

    private int numId;

    private String titulo;

    private String descricao;

    private String anoCriacao;

    private String periodoObj;

    private String paisCultura;

    private String estilo;

    private String tipoObjArt;

    private String catObjArt;

    private String nomeArt;

    private BigDecimal custo;

    //emprestados
    private Timestamp dataEmprestimo;
    private Timestamp dataDevolucao;
    private String nomecolpert;

    //permanentes
    private Timestamp dataAquisicao;
    private Boolean emExposicao;

    //pinturas
    private String tipoTinta;
    private String suporte;

    //outros
    private String tipo;

    //esculturas
    private String material;
    private Double altura;
    private Double peso;

    public ObjetosArteDto(int numId, String titulo, String descricao, String anoCriacao, String periodoObj, String paisCultura, String estilo, String tipoObjArt, String catObjArt, String nomeArt, BigDecimal custo, Timestamp dataEmprestimo, Timestamp dataDevolucao, String nomecolpert) {
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
        this.custo = custo;
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

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }
}
