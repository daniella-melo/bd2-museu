package com.museu.dto;

public class FiltroDto {
    private String filtro;
    private String valor;

    public FiltroDto(){}
    public FiltroDto(String filtro, String valor){
        this.setFiltro(filtro);
        this.setValor(valor);
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
