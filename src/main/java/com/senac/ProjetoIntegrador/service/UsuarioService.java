package com.senac.ProjetoIntegrador.service;

import com.senac.ProjetoIntegrador.data.AlimentoEntity;
import com.senac.ProjetoIntegrador.data.AlimentoRepository;
import com.senac.ProjetoIntegrador.data.CriptografiaMD5;
import com.senac.ProjetoIntegrador.data.UsuarioEntity;
import com.senac.ProjetoIntegrador.data.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioEntity criarUsuario(UsuarioEntity usuario) {
        usuario.setId(null);
        String senhaCriptografada = CriptografiaMD5.gerarHashMD5(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        usuarioRepository.save(usuario);
        return usuario;
    }

    /*public boolean autenticarUsuario(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha).isPresent();
    }*/
    public boolean validarLogin(String email, String senhaDigitada) {
        UsuarioEntity usuario = usuarioRepository.findByEmail(email);

        if (usuario != null) {
            String senhaHash = CriptografiaMD5.gerarHashMD5(senhaDigitada);
            return senhaHash.equals(usuario.getSenha());
        }

        return false;
    }

    public UsuarioEntity getUsuarioId(Integer usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

    /*public boolean atualizarSenha(String email, String novaSenha) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByEmail(email);
        if (usuarioOpt.isPresent()) {
            UsuarioEntity usuario = usuarioOpt.get();
            usuario.setSenha(novaSenha); // Em produção, aplique hash
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }*/
    
    public boolean atualizarSenhaPorEmail(String email, String novaSenha) {
        UsuarioEntity usuario = usuarioRepository.findByEmail(email);

        if (usuario != null) {
            String novaSenhaHash = CriptografiaMD5.gerarHashMD5(novaSenha);
            usuario.setSenha(novaSenhaHash);
            usuarioRepository.save(usuario);
            return true;
        }

        return false;
    }
}
