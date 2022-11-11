package com.brq.ms04.routes;

import com.brq.ms04.beans.CotacaoBean;
import com.brq.ms04.processors.PollingProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class ActiveMQSenderRoute extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {

        from("timer:active-mq-sender?period=2000")
                //.transform().constant("Camel " + counter)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Random rand = new Random();
                        exchange.getIn().setBody( "Camel " + rand.nextInt() );
                    }
                })
                .log("${body}")
                .to("activemq:my-activemq-topic");

    }
}
