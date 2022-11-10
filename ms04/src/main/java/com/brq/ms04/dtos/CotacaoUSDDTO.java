package com.brq.ms04.dtos;

import com.brq.ms04.models.CotacaoUSDModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CotacaoUSDDTO {

    @JsonProperty("USDBRL")
    private USDBRLDTO uSDBRL;

    public CotacaoUSDModel toModel(){
        final var mapper = new ModelMapper();
        return mapper.map(this, CotacaoUSDModel.class);
    }
}