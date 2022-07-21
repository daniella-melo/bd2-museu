package com.museu.dtos;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class ObjCompradosPorMesDto {

    private BigDecimal custototal;
    private BigDecimal nummes;
    private String mes;

    public ObjCompradosPorMesDto(){}
    
    public ObjCompradosPorMesDto(BigDecimal custototal, BigDecimal nummes, String mes) {
        this.custototal = custototal;
        this.nummes = nummes;
        this.mes = mes;
    }

    public BigDecimal getCustoTotal() {
        return custototal;
    }

    public void setCustoTotal(BigDecimal custototal) {
        this.custototal = custototal;
    }

    public BigDecimal getNummes() {
        return nummes;
    }

    public void setNummes(BigDecimal nummes) {
        this.nummes = nummes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

}