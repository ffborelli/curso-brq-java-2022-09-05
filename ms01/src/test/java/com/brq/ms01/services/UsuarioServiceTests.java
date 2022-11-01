package com.brq.ms01.services;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.models.UsuarioModel;
import com.brq.ms01.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/*
* @SpringBootTest: fornece um jeito de iniciar o Spring Boot
* para utilizar os testes unitários
* */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioServiceTests {

    // primeiro temos que instanciar a classe de desejo do teste
    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    void getAllUsuariosTest(){
        // o primeiro passo é simular (mockar) os objetos que preciso
        List<UsuarioModel> listMock = new ArrayList<>();

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(1);
        usuarioModel.setNome("Teste");
        usuarioModel.setTelefone("Meu telefone");

        listMock.add(usuarioModel);

        // quando o findAll da camada repository for acionado, retorno a lista acima
        when ( usuarioRepository.findAll() )
                .thenReturn( listMock );

        // executar o método de desejo de teste
        List<UsuarioDTO> resultadoAtual = usuarioService.getAllUsuarios();

        //List<UsuarioDTO> resultadoEsperado = new ArrayList<>();

        assertThat(resultadoAtual.get(0).getNome() )
                .isEqualTo("Teste");
        assertThat(resultadoAtual.get(0).getTelefone())
                .isEqualTo("Meu telefone");
        assertThat(resultadoAtual.get(0).getId())
                .isEqualTo(1);

    }
    @Test
    void getAllUsuarios2Test(){

        // o primeiro passo é simular (mockar) os objetos que preciso
        List<UsuarioModel> listMock = new ArrayList<>();

        String nome = "Teste";
        int id = 1;

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(id);
        usuarioModel.setNome(nome);
        usuarioModel.setTelefone("Meu telefone");

        listMock.add(usuarioModel);

        // quando o findAll da camada repository for acionado, retorno a lista acima
        when ( usuarioRepository.findAll() )
                .thenReturn( listMock );

        // executar o método de desejo de teste
        List<UsuarioDTO> resultadoAtual = usuarioService.getAllUsuarios2();

        assertThat(resultadoAtual.get(0).getNome() )
                .isEqualTo(nome + "JAVA");
        assertThat(resultadoAtual.get(0).getTelefone())
                .isEqualTo(usuarioModel.getTelefone());
        assertThat(resultadoAtual.get(0).getId())
                .isEqualTo(id * 2);

    }
}
