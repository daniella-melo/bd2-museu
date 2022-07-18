package com.museu.dtos;

import org.springframework.stereotype.Component;

@Component
public class Consulta2Dto {

    private int qtdTotalObjetos;
    private String nomeCol;

    public Consulta2Dto(int qtdTotalObjetos, String nomeCol) {
        this.qtdTotalObjetos = qtdTotalObjetos;
        this.nomeCol = nomeCol;
    }

    public int getQtdTotalObjetos() {
        return qtdTotalObjetos;
    }

    public void setQtdTotalObjetos(int qtdTotalObjetos) {
        this.qtdTotalObjetos = qtdTotalObjetos;
    }

    public String getNomeCol() {
        return nomeCol;
    }

    public void setNomeCol(String nomeCol) {
        this.nomeCol = nomeCol;
    }
}
