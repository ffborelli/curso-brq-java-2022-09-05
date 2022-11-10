package com.brq.ms04.models;

import com.brq.ms04.dtos.USDBRLDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CotacaoUSDModel {

    @JsonProperty("USDBRL")
    private USDBRLModel uSDBRL;

}