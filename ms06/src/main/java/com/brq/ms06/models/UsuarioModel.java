package com.brq.ms06.models;

import java.io.Serializable;

import com.brq.ms06.dtos.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import org.modelmapper.ModelMapper;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@RedisHash
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID = 1603714798906422731L;

    @Id
    @Indexed
    private String id;
    private String nome;
    private String email;

    public UsuarioDTO toDTO(){
        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, UsuarioDTO.class);
    }
}