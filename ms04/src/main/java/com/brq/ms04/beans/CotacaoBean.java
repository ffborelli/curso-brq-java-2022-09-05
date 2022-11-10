package com.brq.ms04.beans;

import com.brq.ms04.dtos.CotacaoUSDDTO;
import com.brq.ms04.models.USDBRLModel;
import com.brq.ms04.repositories.CotacaoRespository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CotacaoBean {

    @Autowired
    private CotacaoRespository cotacaoRespository;

    public USDBRLModel save(String messageIn){

        final var cotacao = convertStringToObject(messageIn);

        return cotacaoRespository.save(cotacao);
    }

    public List<USDBRLModel> findAll(){
        return cotacaoRespository.findAll();
    }

    private USDBRLModel convertStringToObject(String messageIn)  {
        final var objectMapper = new ObjectMapper();

        try{
            var cotacao = objectMapper
                    .readValue(messageIn, CotacaoUSDDTO.class);

            return cotacao.toModel().getUSDBRL();
        }catch (JsonProcessingException e){
            throw new RuntimeException("Erro ao converter objeto");
        }
    }
}
