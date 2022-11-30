package com.brq.ms06.services;

import java.util.List;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.models.UsuarioModel;

public interface IUsuarioService {

	List<UsuarioDTO> getAll();
	UsuarioDTO getOne(String id);
	UsuarioDTO create(UsuarioModel model);
	UsuarioDTO update(String id, UsuarioDTO dto);
	void delete(String id);
	List<UsuarioDTO> findByNome(String nome);
}
