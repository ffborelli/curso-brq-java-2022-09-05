package com.brq.ms04.routes;

import com.brq.ms04.beans.ActiveMQBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ActiveMQReceiverRoute extends RouteBuilder {



    @Override
    public void configure() throws Exception {

        from("activemq:my-activemq-topic")
                .bean(ActiveMQBean.class, "save")
                .to("log:receiver-my-activemq-topic");

    }
}
