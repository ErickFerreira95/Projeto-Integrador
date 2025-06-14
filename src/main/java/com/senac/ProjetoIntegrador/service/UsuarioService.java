package com.senac.ProjetoIntegrador.service;

import com.senac.ProjetoIntegrador.data.UsuarioEntity;
import com.senac.ProjetoIntegrador.data.UsuarioRepository;
import java.util.Optional;
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
    
    public UsuarioEntity getUsuarioId(Integer usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }
    
    public boolean atualizarSenha(String email, String novaSenha) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByEmail(email);
        if (usuarioOpt.isPresent()) {
            UsuarioEntity usuario = usuarioOpt.get();
            usuario.setSenha(novaSenha); // Em produção, aplique hash
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }
}
