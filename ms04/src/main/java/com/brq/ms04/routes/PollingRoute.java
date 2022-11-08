package com.brq.ms04.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PollingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // após o caracter ?, podemos colocar os parâmetros do conector do camel
        // ex: period=5000 -> executar a cada 5 segundos
        from("timer:polling?period=5000")
                .to("https://economia.awesomeapi.com.br/json/last/USD-BRL")
                .log("${body}");
    }
}
