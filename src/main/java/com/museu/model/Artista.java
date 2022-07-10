package com.museu.model;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="artista")
public class Artista {

    @Id
    @Column(name = "Nome")
    private String nome;

    private String descrArtista;
    private Timestamp dataMorte;
    private String estiloPrincipal;
    private String periodo;
    private String paisdeOrigem;
}
