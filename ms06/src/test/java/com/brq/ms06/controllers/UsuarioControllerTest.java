package com.brq.ms06.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.models.UsuarioModel;
import com.brq.ms06.services.UsuarioService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioControllerTest {

	@Autowired
	private UsuarioController controller;
	
	@MockBean
	private UsuarioService service;
	
	@Test
	void getAllTest() {
		
		// dado que
		String id = "1";
		String nome = "nome";
		String email = "email";
		
		final var listDTO = Arrays.asList(getUsuarioDTOMock(id, nome, email));
		// quando
		when(service.getAll()).thenReturn(listDTO);
		
		// então
		final var response = controller.getAll();
		
		// validação
		assertThat(response.getStatusCode())
			.isEqualTo(HttpStatus.OK);
			
		assertThat(response.getBody())
			.isEqualTo(listDTO);
		
		verify(service, times(1)).getAll();
	}
	
	@Test
	void getOneTest() {
		
		// dado que
		String id = "1";
		String nome = "nome";
		String email = "email";
		final var dto = getUsuarioDTOMock(id, nome, email);
		
		//quando
		when(service.getOne(id)).thenReturn(dto);
		
		// então
		final var response = controller.getOne(id);
		
		// validar teste
		assertThat(response.getStatusCode())
			.isEqualTo(HttpStatus.OK);
		
		assertThat(response.getBody())
			.isEqualTo(dto);
		
		verify(service, times(1)).getOne(id);
		
	}
	
	@Test
	void createTest() {
		
		// dado que
		String id = "1";
		String nome = "nome";
		String email = "email";
		final var dto = getUsuarioDTOMock(null, nome, email);
		final var dtoSaved = getUsuarioDTOMock(id, nome, email);
		
		// quando
		when(service.create(dto.toModel()))
			.thenReturn(dtoSaved);
		
		// então
		final var response = controller.create(dto);
		
		// validar teste
		assertThat(response.getStatusCode())
			.isEqualTo(HttpStatus.CREATED);
		
		assertThat(response.getBody().getId())
		.isNotNull();
		
		assertThat(response.getBody().getNome())
			.isEqualTo(dto.getNome());
		
		assertThat(response.getBody().getEmail())
			.isEqualTo(dto.getEmail());
	
		verify(service, times(1)).create(dto.toModel());
		
	}
	
	@Test
	void updateTest() {
		
		String id = "1";
		String nomeAlterado = "nomeAlterado";
		String emailAlterado = "emailAlterado";
		
		final var dto = getUsuarioDTOMock(id, nomeAlterado, emailAlterado);
		
		// quando
		when(service.update(id, dto)).thenReturn(dto);
		
		// então
		final var response = controller.update(id, dto);
		
		// validar teste
		assertThat(response.getStatusCode())
			.isEqualTo(HttpStatus.OK);
		
		assertThat(response.getBody())
			.isEqualTo(dto);
		
		verify(service, times(1)).update(id, dto);
		
	}
	
	@Test
	void deleteTest() {
		
		String id = "1";
		
		// quando
		doNothing().when(service).delete(id);
		
		// então
		final var response = controller.delete(id);
		
		// validar teste
		assertThat(response.getStatusCode())
			.isEqualTo(HttpStatus.OK);
		
		verify(service, times(1)).delete(id);
		
	}
	
	@Test
	void findByNomeTest() {
		
		// dado que
		String id = "1";
		String nome = "nome";
		String email = "email";
		
		final var listDTO = Arrays.asList(getUsuarioDTOMock(id, nome, email));
		// quando
		when(service.findByNome(nome)).thenReturn(listDTO);
		
		// então
		final var response = controller.findByNome(nome);
		
		// validação
		assertThat(response.getStatusCode())
			.isEqualTo(HttpStatus.OK);
			
		assertThat(response.getBody())
			.isEqualTo(listDTO);
		
		verify(service, times(1)).findByNome(nome);
	}
	
	@Test
	void findByNomeContainsTest() {
		
		// dado que
		String id = "1";
		String nome = "nome";
		String email = "email";
		
		final var listDTO = Arrays.asList(getUsuarioDTOMock(id, nome, email));
		// quando
		when(service.findByNomeContains(nome)).thenReturn(listDTO);
		
		// então
		final var response = controller.findByNomeContains(nome);
		
		// validação
		assertThat(response.getStatusCode())
			.isEqualTo(HttpStatus.OK);
			
		assertThat(response.getBody())
			.isEqualTo(listDTO);
		
		verify(service, times(1)).findByNomeContains(nome);
	}
	
	@Test
	void findByEmailTest() {

		// dado que
		String email = "email";

		final var page = 0;
		final var limit = 5;
		final var direction = "ASC";
		final var orderBy = "id";

		final var pageUsuarioModel = getPageUsuarioModel();

		// quando
		when(service.findByEmail(email, page, limit, orderBy, direction))
			.thenReturn(pageUsuarioModel);

		// então
		final var response = controller.findByEmail(email, page, limit, orderBy, "ASC");

		// validação
		assertThat(response.getStatusCode())
			.isEqualTo(HttpStatus.OK);

		assertThat(response.getBody())
			.isEqualTo(pageUsuarioModel);

		verify(service, times(1))
			.findByEmail(email, page, limit, orderBy, direction);
	}
	
	private UsuarioDTO getUsuarioDTOMock(String id, String nome, String email) {
		
		final var dto = UsuarioDTO
				.builder()
				.id(id)
				.nome(nome)
				.email(email)
				.build();

		return dto;
		
	}
	
	private Page<UsuarioModel> getPageUsuarioModel(){
		
		Page<UsuarioModel> pageUsuarioModel = new Page<UsuarioModel>() {
		
			UsuarioModel model = UsuarioModel
					.builder()
					.id("1")
					.nome("nome")
					.email("email")
					.build();

			List<UsuarioModel> listEntity = Arrays.asList(model);
			
		@Override
		public Iterator<UsuarioModel> iterator() {
			return (Iterator<UsuarioModel>) listEntity;
		}
		
		@Override
		public Pageable previousPageable() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Pageable nextPageable() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean isLast() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean isFirst() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean hasContent() {
			// TODO Auto-generated method stub
			return true;
		}
		
		@Override
		public Sort getSort() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int getSize() {
			
			return listEntity.size();
		}
		
		@Override
		public int getNumberOfElements() {
			
			return listEntity.size();
		}
		
		@Override
		public int getNumber() {
			
			return 1;
		}
		
		@Override
		public List<UsuarioModel> getContent() {
			
			return listEntity;
		}
		
		@Override
		public <U> Page<U> map(Function<? super UsuarioModel, ? extends U> converter) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int getTotalPages() {
		
			return 1;
		}
		
		@Override
		public long getTotalElements() {
			
			return listEntity.size();
		}
	};
	
	return pageUsuarioModel;
}
	
	
}
