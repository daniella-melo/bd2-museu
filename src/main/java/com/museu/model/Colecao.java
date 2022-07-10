package com.museu.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="colecao")
public class Colecao {

    @Id
    @NotNull
    @Column(name = "NomeCol")
    private String nomeCol;

    @NotNull
    @Column(name = "DescrCol")
    private String descrCol;

    @NotNull
    @Column(name = "Endereco")
    private String endereco;

    @NotNull
    @Column(name = "Telefone")
    private String telefone;

    @NotNull
    @Column(name = "PessoaContato")
    private String pessoaContato;

    @NotNull
    @Column(name = "TipoCol")
    private String tipoCol;

    public Colecao(String nomeCol, String descrCol, String endereco, String telefone, String pessoaContato, String tipoCol) {
        this.nomeCol = nomeCol;
        this.descrCol = descrCol;
        this.endereco = endereco;
        this.telefone = telefone;
        this.pessoaContato = pessoaContato;
        this.tipoCol = tipoCol;
    }

    public String getNomeCol() {
        return nomeCol;
    }

    public void setNomeCol(String nomeCol) {
        this.nomeCol = nomeCol;
    }

    public String getDescrCol() {
        return descrCol;
    }

    public void setDescrCol(String descrCol) {
        this.descrCol = descrCol;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPessoaContato() {
        return pessoaContato;
    }

    public void setPessoaContato(String pessoaContato) {
        this.pessoaContato = pessoaContato;
    }

    public String getTipoCol() {
        return tipoCol;
    }

    public void setTipoCol(String tipoCol) {
        this.tipoCol = tipoCol;
    }
}
