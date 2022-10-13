package com.microservice.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// CLASSE DE CONFIGURAÇÃO PARA LINKAR O PAYROLL COM O WORKER
@Configuration
public class AppConfig {

    // SINGLETOM = PADRÃO DE INSTANCIA UNICA PARA INJETAR EM OUTROS SERVIÇOS
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
