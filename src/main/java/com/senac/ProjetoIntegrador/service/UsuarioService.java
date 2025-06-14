package com.senac.ProjetoIntegrador.service;

import com.senac.ProjetoIntegrador.data.UsuarioEntity;
import com.senac.ProjetoIntegrador.data.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired

    UsuarioRepository usuarioRepository;

    public UsuarioEntity criarUsuario(UsuarioEntity usuario) {
        usuario.setId(null);
        usuarioRepository.save(usuario);
        return usuario;
    }
    
    public boolean autenticarUsuario(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha).isPresent();
    }
}
