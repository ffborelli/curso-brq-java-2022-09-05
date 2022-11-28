package com.brq.ms06.services;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.models.UsuarioModel;
import com.brq.ms06.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioModel save(UsuarioModel m){
        return repository.save(m);
    }

    public List<UsuarioDTO> getAll(){
        final var list = (List<UsuarioModel>) repository.findAll();

        return list.stream().map( x -> x.toDTO())
                .collect(Collectors.toList());
    }

    public UsuarioDTO create(UsuarioDTO usuario){
        if (usuario.getId() == null){
            //UUID uuid = new UUID(long mostSignificant64Bits, long leastSignificant64Bits);
            usuario.setId(generateUniqueKeysWithUUIDAndMessageDigest());
        }

        return repository.save(usuario.toModel()).toDTO();
    }

    private String generateUniqueKeysWithUUIDAndMessageDigest() {
        final MessageDigest salt;
        try {
            salt = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        salt.update(UUID.randomUUID()
                .toString()
                .getBytes(StandardCharsets.UTF_8));
        return bytesToHex(salt.digest());
    }

    private String bytesToHex(byte[] bytes) {
        final char[] hexArray = "0123456789ABCDEF".toCharArray();
        final char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            final int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public UsuarioDTO update(String id, UsuarioDTO usuarioBody)  {

        // TODO: fazer uma exceção para quando não encontrar o dado. Sugestão: ObjNotFountException. Retornar status 404
        UsuarioModel usuario = repository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado") );

        usuario.setEmail( usuarioBody.getEmail() );
        usuario.setNome( usuarioBody.getNome() );

        return repository.save(usuario).toDTO();
    }

    public String delete(String id){

        final var usuario = repository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado") );

        log.info("deletando usuário id: {} com sucesso, email : {}",
                usuario.getId(), usuario.getEmail() );

        repository.deleteById(id);
        return "Usuário delatado com sucesso!";
    }

    public UsuarioDTO getOne(String id){

        UsuarioModel usuario = repository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado"));

        return usuario.toDTO();
    }
    
    public List<UsuarioDTO> findByNome(String nome){

        final var dtos = repository.findByNome(nome);

        return dtos.stream()
                .map( UsuarioModel::toDTO )
                .collect(Collectors.toList());
    }
    
    public List<UsuarioDTO> findByEmail(String email){

        final var dtos = repository.findByEmail(email);

        return dtos.stream()
                .map( UsuarioModel::toDTO )
                .collect(Collectors.toList());
    }

}
