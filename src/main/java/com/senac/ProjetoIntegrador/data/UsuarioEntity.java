package com.senac.ProjetoIntegrador.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuarios")
public class UsuarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    
    private Integer id;
    private String nome;
    private String email;
    private String senha;
}
