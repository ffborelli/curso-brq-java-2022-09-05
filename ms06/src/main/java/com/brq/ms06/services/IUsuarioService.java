package com.brq.ms06.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.models.UsuarioModel;

public interface IUsuarioService {

	List<UsuarioDTO> getAll();
	UsuarioDTO getOne(String id);
	UsuarioDTO create(UsuarioModel model);
	UsuarioDTO update(String id, UsuarioDTO dto);
	void delete(String id);
	List<UsuarioDTO> findByNome(String nome);
	List<UsuarioDTO> findByNomeContains(String input);
	void insertMany(int times);
	Page<UsuarioModel> findByEmail(String email, int page, int limit, String orderBy, String direction);
	void deleteAll();
}
