package com.senac.ProjetoIntegrador.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Alimentos")
public class AlimentoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    
    private Integer id;
    private String nomeAlimento;
    private String quantidade;
    private String proteina;
    private String carboidrato;
    private String gordura;
    private String kcal;
}
