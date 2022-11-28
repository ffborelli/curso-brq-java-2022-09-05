package com.brq.ms06.controllers;

import com.brq.ms06.dtos.UsuarioDTO;
import com.brq.ms06.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(){

        var usuarios = service.getAll();

        return ResponseEntity.ok().body(usuarios);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuario){

        var usuarioResponse = service.create(usuario);

        return ResponseEntity.ok().body(usuarioResponse);

    } // create

    // /usuarios/1 -> o valor do id vai ser 1

    @PatchMapping("{id}")
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioBody,
                                @PathVariable String id ){

        var tiberio = service.update(id, usuarioBody);
        return ResponseEntity.ok().body(tiberio);
    } // update()

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable String id){

        var resp = service.delete(id);
        return ResponseEntity.ok().body(resp);
    } // delete

    // busca por apenas um usuário (pelo id)
    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> getOne(@PathVariable String id){

        var u = service.getOne(id);
        return ResponseEntity.ok().body(u);

    } // getOne
    
    @GetMapping(value = "find-by-nome/{nome}")
    public ResponseEntity< List<UsuarioDTO> > findByNome(
            @PathVariable String nome){
        return ResponseEntity.ok().body( service.findByNome(nome) );
    }
    
    @GetMapping(value = "find-by-email/{email}")
    public ResponseEntity< List<UsuarioDTO> > findByEmail(
            @PathVariable String email){
        return ResponseEntity.ok().body( service.findByEmail(email) );
    }

} // UsuarioController