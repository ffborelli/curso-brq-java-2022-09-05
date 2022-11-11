package com.brq.ms04.beans;

import com.brq.ms04.models.ActiveMQModel;
import com.brq.ms04.repositories.ActiveMQRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActiveMQBean {

    @Autowired
    private ActiveMQRespository repository;

    public ActiveMQModel save(String messageIn){

        ActiveMQModel model = new ActiveMQModel();
        model.setMessage(messageIn);

        return repository.save(model);
    }

}
