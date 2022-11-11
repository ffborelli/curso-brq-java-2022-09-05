package com.brq.ms04.routes;

import com.brq.ms04.beans.CotacaoBean;
import com.brq.ms04.processors.PollingProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.apache.camel.model.rest.RestBindingMode;
@Slf4j
@Component
public class PollingRoute extends RouteBuilder {

    @Value("${exchange.url}")
    private String url;

    @Autowired
    private Environment env;

    @Override
    public void configure() throws Exception {

        // configure we want to use servlet as the component for the rest DSL
        // and we enable json binding mode
//        restConfiguration()
//                .contextPath("/camel-rest-jpa").apiContextPath("/api-doc")
//                .bindingMode(RestBindingMode.json);

        log.info("O valor da URL é {}", url);

        // após o caracter ?, podemos colocar os parâmetros do conector do camel
        // ex: period=5000 -> executar a cada 5 segundos
        from("timer:polling?period=50000")
                //.to("https://economia.awesomeapi.com.br/json/last/USD-BRL")
                .to(url)
                .process( new PollingProcessor() )
                .bean(CotacaoBean.class, "save")

                //.process( new PollingProcessor2() )
                .log("${body}");

//        rest("/cotacoes")
//                .description("Books REST service")
//                .consumes("application/json")
//                .produces("application/json")
//                .get("/")
//                .description("The list of all the books")
//                .to("direct:cotacoes");

//        from("direct:cotacoes")
//                .routeId("cotacoes-api")
//                .bean(CotacaoBean.class, "findAll");
    }
}
