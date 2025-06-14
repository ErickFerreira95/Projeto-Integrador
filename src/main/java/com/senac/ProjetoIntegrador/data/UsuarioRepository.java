package com.senac.ProjetoIntegrador.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository< UsuarioEntity, Integer> {
    
    UsuarioEntity findByNome(String nome);

    List<UsuarioEntity> findByNomeContaining(String nome);

    List<UsuarioEntity> findByNomeStartingWith(String nome);

    List<UsuarioEntity> findByNomeEndingWith(String nome);

    List<UsuarioEntity> findByOrderByNomeAsc();

    List<UsuarioEntity> findByOrderByNomeDesc();
}
