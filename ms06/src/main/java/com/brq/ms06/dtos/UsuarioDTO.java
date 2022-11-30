package com.brq.ms06.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.brq.ms06.models.UsuarioModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private String id;
	
	@NotNull (message = "nome é obrigatório")
	private String nome;
	
	@NotNull (message = "nome é obrigatório")
	private String email;
	
	public UsuarioModel toModel() {
		final var mapper = new ModelMapper();
		
		return mapper.map(this, UsuarioModel.class);
	}
}
