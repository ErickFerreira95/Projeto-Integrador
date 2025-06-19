package com.senac.ProjetoIntegrador.data;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository< UsuarioEntity, Integer> {
    
    Optional<UsuarioEntity> findByEmailAndSenha(String email, String senha);
    
    //Optional<UsuarioEntity> findByEmail(String email);
    UsuarioEntity findByEmail(String email);
    
}
