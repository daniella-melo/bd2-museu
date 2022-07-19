package com.museu.configuration;

import com.museu.dtos.Consulta1Dto;
import com.museu.dtos.Consulta2Dto;
import com.museu.dtos.Consulta3Dto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracoes {

    @Bean
    public Consulta1Dto criarObjetoConsulta1Dto() {
        return new Consulta1Dto();
    }

    @Bean
    public Consulta2Dto criarObjetoConsulta2Dto() {
        return new Consulta2Dto();
    }

    @Bean
    public Consulta3Dto criarObjetoConsulta3Dto() {
        return new Consulta3Dto();
    }


}
