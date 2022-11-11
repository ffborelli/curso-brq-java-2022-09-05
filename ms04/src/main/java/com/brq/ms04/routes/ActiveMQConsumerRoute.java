package com.brq.ms04.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("activemq:meu-primeiro-topico-2")
                .log("LOG CONSUMER >>> ${body}");
    }
}
