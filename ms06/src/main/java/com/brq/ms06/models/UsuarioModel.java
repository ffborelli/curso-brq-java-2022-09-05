package com.brq.ms06.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@RedisHash("Usuario")
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID = 1603714798906422731L;

    private String id;
    private String nome;
    private String email;
}