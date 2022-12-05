package com.brq.ms06.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.brq.ms06.models.UsuarioModel;
import com.brq.ms06.repositories.UsuarioRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UsuarioServiceTest {

	// instanciar o objeto que queremos testar
	@Autowired
	private UsuarioService service;
	
	// mockar os outros objetos necessário para teste unitário
	@MockBean
	private UsuarioRepository repository;
	
	@Test
	void getAllTest() {
		
		// DADO QUE (cenário inicial de teste : inicialização das variáveis)

		// QUANDO( mockar: quando simulamos as outras camadas necessárias do teste)
		final var model = UsuarioModel
						.builder()
						.id("1")
						.nome("nome")
						.email("email")
						.build();
		
		final var listEntity = Arrays.asList(model);
		when(repository.findAll()).thenReturn(listEntity);

		// ENTÃO (execução do teste: chamar o método a ser testado)
		final var response = service.getAll();

		// VERIFICAR (verificar o resultado do passo anterior)
		assertThat(response.get(0).getNome())
			.isEqualTo(listEntity.get(0).getNome());
		
		assertThat(response.get(0).getEmail())
			.isEqualTo(listEntity.get(0).getEmail());
		
	} 
	
}
