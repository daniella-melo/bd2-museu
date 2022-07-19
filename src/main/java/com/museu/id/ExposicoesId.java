package com.museu.id;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

public class ExposicoesId implements Serializable {

    private String nomeExp;
    private Timestamp dataInicio;

    public ExposicoesId(){};

    public ExposicoesId(String nomeExp, Timestamp dataInicio){
        this.setNomeExp(nomeExp);
        this.setDataInicio(dataInicio);
    }

    public String getNomeExp() {
        return nomeExp;
    }

    public void setNomeExp(String nomeExp) {
        this.nomeExp = nomeExp;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }
}
