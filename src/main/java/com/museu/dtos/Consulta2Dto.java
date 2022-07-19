package com.museu.dtos;

import org.springframework.stereotype.Component;

@Component
public class Consulta2Dto {

    private Long qtdTotalObjetos;
    private String nomeCol;

    //public Consulta2Dto(int qtdTotalObjetos, String nomeCol) {
    //    this.qtdTotalObjetos = qtdTotalObjetos;
    //    this.nomeCol = nomeCol;
    //}

    public Long getQtdTotalObjetos() {
        return qtdTotalObjetos;
    }

    public void setQtdTotalObjetos(Long qtdTotalObjetos) {
        this.qtdTotalObjetos = qtdTotalObjetos;
    }

    public String getNomeCol() {
        return nomeCol;
    }

    public void setNomeCol(String nomeCol) {
        this.nomeCol = nomeCol;
    }
}
