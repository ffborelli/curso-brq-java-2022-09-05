package com.brq.ms04.processors;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PollingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        final var messageIn = exchange.getIn().getBody(String.class);
        System.out.println("GET IN " + messageIn);
    }
}
