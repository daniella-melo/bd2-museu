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
    @Column(name = "nomecol")
    private String nomecol;

    @NotNull
    @Column(name = "descrcol")
    private String descrCol;

    @NotNull
    @Column(name = "endereco")
    private String endereco;

    @NotNull
    @Column(name = "telefone")
    private String telefone;

    @NotNull
    @Column(name = "pessoacontato")
    private String pessoaContato;

    @NotNull
    @Column(name = "tipocol")
    private String tipoCol;

    public Colecao(){}

    public Colecao(String nomecol, String descrCol, String endereco, String telefone, String pessoaContato, String tipoCol) {
        this.nomecol = nomecol;
        this.descrCol = descrCol;
        this.endereco = endereco;
        this.telefone = telefone;
        this.pessoaContato = pessoaContato;
        this.tipoCol = tipoCol;
    }

    public String getNomeCol() {
        return nomecol;
    }

    public void setNomeCol(String nomecol) {
        this.nomecol = nomecol;
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
