package com.brq.ms06.repositories;

import com.brq.ms06.models.UsuarioModel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, String> {
	
	List<UsuarioModel> findByNome(String nome);
	
	List<UsuarioModel> findByEmail(String email);
	
}