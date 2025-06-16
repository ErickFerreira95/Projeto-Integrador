package com.senac.ProjetoIntegrador.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentoRepository extends JpaRepository<AlimentoEntity, Integer>{
    
    AlimentoEntity findByNomeAlimento(String nomeAlimento);
}
