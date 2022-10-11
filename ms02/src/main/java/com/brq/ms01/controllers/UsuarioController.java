package com.brq.ms01.controllers;

import com.brq.ms01.models.UsuarioModel;
import com.brq.ms01.services.ProfessorService;
import com.brq.ms01.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


// comentário

/*
 * comentário
 * */

@RestController
public class UsuarioController {

    // ESTE ARRAYLIST É DIDÁTICO, POIS ESTÁ SIMULANDO UM BANCO DE DADOS
    private ArrayList<UsuarioModel> usuarios = new ArrayList<>();
    private int counter = 1;

    // private UsuarioService usuServ = new UsuarioService();
    @Autowired
    private UsuarioService usuServ;

    @Autowired
    private ProfessorService profServ;
    /*
    * o @GetMapping permite associoar o verbo GET com a rota /usuarios
    * */
    @GetMapping("usuarios")
    public ArrayList<UsuarioModel> getAllUsuarios(){

//        UsuarioModel u = new UsuarioModel();
//        u.setId(1);
//        u.setNome("Manoel");
//        u.setEmail("manoel@gmail.com");
//
//        usuarios.add(u);

        return usuarios;
    }

    @PostMapping("usuarios")
    public UsuarioModel create(@RequestBody UsuarioModel usuario){

        // System.out.println(usuario);

        usuServ.teste();

        usuario.setId( counter );
        usuarios.add(usuario);
        counter++;

        System.out.println(usuario);

        // return "POST Usuários";
        return usuario;
    } // create

    // /usuarios/1 -> o valor do id vai ser 1

    @PatchMapping("usuarios/{id}")
    public UsuarioModel update(@RequestBody UsuarioModel usuarioBody,
                                @PathVariable int id ){
        // como achar o usuário a ser alterado?
        for ( int i = 0; i <  usuarios.size(); i++ ){
            if (usuarios.get(i).getId() == id){
                // achamos o usuário a ser alterado
                usuarios.get(i).setNome( usuarioBody.getNome() );
                usuarios.get(i).setEmail( usuarioBody.getEmail() );

                return usuarios.get(i);
            } // if
        }// for

        return null;
    } // update()

    @DeleteMapping("usuarios/{id}")
    public String delete(@PathVariable int id){

        // FORECH
//        for (UsuarioModel usuarioLocal: usuarios) {
//            usuarios.remove(usuarioLocal);
//        }
         for (int i = 0; i < usuarios.size(); i++){
             // se achar o usuário, então delete do arraylist
            if (usuarios.get(i).getId() == id){
                usuarios.remove(i);
                return "Usuário delatado com sucesso!";
            } // if
         } // for
        return "Usuário não encontrado";
    } // delete

    // busca por apenas um usuário (pelo id)
    @GetMapping("usuarios/{id}")
    public UsuarioModel getOne(@PathVariable int id){

        for (int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getId() == id){
                return usuarios.get(i);
            } // if
        } // for
        return null;
    } // getOne

} // UsuarioController
