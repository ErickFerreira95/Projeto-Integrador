package com.senac.ProjetoIntegrador.controller;

import com.senac.ProjetoIntegrador.data.UsuarioEntity;
import com.senac.ProjetoIntegrador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioControl {
    
    @Autowired

    UsuarioService usuarioService;
    
    @PostMapping("/adicionar")
    public ResponseEntity<UsuarioEntity> addUsuario(@RequestBody UsuarioEntity usuario) {
        var novoUsuario = usuarioService.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }
}
