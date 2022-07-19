package com.museu.model;

import com.sun.istack.NotNull;
import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="objetos_arte", schema = "bd2")
public class ObjetosArte {

    @Id
    @NotNull
    @Column(name = "numid")
    private int numId;

    @NotNull
    @Column(name = "titulo")
    private String titulo;

    @NotNull
    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @Column(name = "anocriacao")
    private String anoCriacao;

    @NotNull
    @Column(name = "periodoobj")
    private String periodoObj;

    @NotNull
    @Column(name = "paiscultura")
    private String paisCultura;

    @NotNull
    @Column(name = "estilo")
    private String estilo;

    @NotNull
    @Column(name = "tipoobjart")
    private String tipoObjArt;

    @NotNull
    @Column(name = "catobjart")
    private String catObjArt;

    @NotNull
    @Column(name = "nomeart")
    private String nomeArt;

    @NotNull
    @Column(name = "custo")
    private BigDecimal custo;

    public ObjetosArte(){}

    public ObjetosArte(int numId, String titulo, String descricao, String anoCriacao, String periodoObj, String paisCultura, String estilo, String tipoObjArt, String catObjArt, String nomeArt, BigDecimal custo) {
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
