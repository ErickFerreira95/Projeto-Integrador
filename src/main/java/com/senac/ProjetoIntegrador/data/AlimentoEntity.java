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
    private float kcalNumero;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNomeAlimento() {
        return nomeAlimento;
    }
    
    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }
    
    public String getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getProteina() {
        return proteina;
    }
    
    public void setProteina(String proteina) {
        this.proteina = proteina;
    }
    
    public String getCarboidrato() {
        return carboidrato;
    }
    
    public void setCarboidrato(String carboidrato) {
        this.carboidrato = carboidrato;
    }
    
    public String getGordura() {
        return gordura;
    }
    
    public void setGordura(String gordura) {
        this.gordura = gordura;
    }
    
    /*public String getKcal() {
        kcalNumero = (Float.parseFloat(proteina) * 4) + (Float.parseFloat(carboidrato) * 4) + (Float.parseFloat(gordura) * 9);
        return String.valueOf(kcalNumero);
    }*/
    
    public String getKcal() {
        kcalNumero = (Float.parseFloat(proteina) * 4) + (Float.parseFloat(carboidrato) * 4) + (Float.parseFloat(gordura) * 9);
        kcal = String.valueOf(kcalNumero);
        return kcal;
    }
    
    public void setKcal(String kcal) {
        this.kcal = kcal;
    }
}
