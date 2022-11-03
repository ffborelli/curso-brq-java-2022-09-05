package com.brq.ms01.controllers;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioControllerTests {

    @Autowired
    private UsuarioController controller;

    @MockBean
    private UsuarioService service;

    @Test
    void getAllUsuariosTest(){

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setTelefone("telefone");
        usuarioDTO.setEmail("email");
        usuarioDTO.setNome("nome");

        List<UsuarioDTO> listDTO = Arrays.asList(usuarioDTO);

        // mockar retorno do service

        when(service.getAllUsuarios())
                .thenReturn(listDTO);

        // chamar o método a ser testado
        final var response
                = controller.getAllUsuarios();

        // verificar se o retorno está correto

        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);

        assertThat( response.getBody() )
                .isEqualTo(listDTO);

        verify(service, times(1))
                .getAllUsuarios();
    }
}
