package com.museu.configuration;

import com.museu.dtos.Consulta1Dto;
import com.museu.dtos.Consulta2Dto;
import com.museu.dtos.Consulta3Dto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

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

    @Bean
    public ArrayList<Consulta1Dto> criarListaConsulta1Dto() {return new ArrayList<Consulta1Dto>();}

    @Bean
    public ArrayList<Consulta2Dto> criarListaConsulta2Dto() {return new ArrayList<Consulta2Dto>();}

    @Bean
    public ArrayList<Consulta3Dto> criarListaConsulta3Dto() {return new ArrayList<Consulta3Dto>();}
}
