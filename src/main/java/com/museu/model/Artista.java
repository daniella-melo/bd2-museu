package com.museu.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="artista")
public class Artista {

    @Id
    @Column(name = "Nome")
    @NotNull
    private String nome;

    @NotNull
    @Column(name = "DescrArtista")
    private String descrArtista;

    @NotNull
    @Column(name = "DataMorte")
    private Timestamp dataMorte;

    @NotNull
    @Column(name = "EstiloPrincipal")
    private String estiloPrincipal;

    @NotNull
    @Column(name = "Periodo")
    private String periodo;

    @NotNull
    @Column(name = "PaisdeOrigem")
    private String paisdeOrigem;

    public Artista(String nome, String descrArtista, Timestamp dataMorte, String estiloPrincipal, String periodo, String paisdeOrigem) {
        this.nome = nome;
        this.descrArtista = descrArtista;
        this.dataMorte = dataMorte;
        this.estiloPrincipal = estiloPrincipal;
        this.periodo = periodo;
        this.paisdeOrigem = paisdeOrigem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrArtista() {
        return descrArtista;
    }

    public void setDescrArtista(String descrArtista) {
        this.descrArtista = descrArtista;
    }

    public Timestamp getDataMorte() {
        return dataMorte;
    }

    public void setDataMorte(Timestamp dataMorte) {
        this.dataMorte = dataMorte;
    }

    public String getEstiloPrincipal() {
        return estiloPrincipal;
    }

    public void setEstiloPrincipal(String estiloPrincipal) {
        this.estiloPrincipal = estiloPrincipal;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPaisdeOrigem() {
        return paisdeOrigem;
    }

    public void setPaisdeOrigem(String paisdeOrigem) {
        this.paisdeOrigem = paisdeOrigem;
    }
}
