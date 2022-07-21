package com.museu.dtos;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class ObjCompradosPorAnoDto {

    private BigDecimal custototal;
    private String ano;

    public ObjCompradosPorAnoDto(){}
    
    public ObjCompradosPorAnoDto(BigDecimal custototal, String ano) {
        this.custototal = custototal;
        this.ano = ano;
    }

    public BigDecimal getCustoTotal() {
        return custototal;
    }

    public void setCustoTotal(BigDecimal custototal) {
        this.custototal = custototal;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }


}