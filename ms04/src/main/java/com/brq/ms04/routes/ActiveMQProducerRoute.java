package com.brq.ms04.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:active-mq-producer?repeatCount=10&period=3000")
                .transform().constant("Apache Camel")
                .to("activemq:meu-primeiro-topico");
    }
}
