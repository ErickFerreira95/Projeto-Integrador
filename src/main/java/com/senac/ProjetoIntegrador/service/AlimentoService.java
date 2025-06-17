package com.senac.ProjetoIntegrador.service;

import com.senac.ProjetoIntegrador.data.AlimentoEntity;
import com.senac.ProjetoIntegrador.data.AlimentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlimentoService {
    
    @Autowired
    AlimentoRepository alimentoRepository;

    public AlimentoEntity criarAlimento(AlimentoEntity alimento) {
        alimento.setId(null);
        alimentoRepository.save(alimento);
        return alimento;
    }
    
    public AlimentoEntity atualizarAlimento(Integer alimentoId, AlimentoEntity alimentoEntity) {
        AlimentoEntity alimento = getAlimentoId(alimentoId);
        alimento.setNomeAlimento(alimentoEntity.getNomeAlimento());
        alimento.setQuantidade(alimentoEntity.getQuantidade());
        alimento.setProteina(alimentoEntity.getProteina());
        alimento.setCarboidrato(alimentoEntity.getCarboidrato());
        alimento.setGordura(alimentoEntity.getGordura());
        alimento.setKcal(alimentoEntity.getKcal());
        alimentoRepository.save(alimento);
        return alimento;
    }
    
    public AlimentoEntity getAlimentoId(Integer alimentoId) {
        return alimentoRepository.findById(alimentoId).orElse(null);
    }
    
    public List<AlimentoEntity> listarTodosAlimentos() {
        return alimentoRepository.findAll();
    }
}
