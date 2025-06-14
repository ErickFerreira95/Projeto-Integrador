package com.senac.ProjetoIntegrador.controller;

import com.senac.ProjetoIntegrador.data.UsuarioEntity;
import com.senac.ProjetoIntegrador.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/")
    public String viewHomePage() {
        return "login";
    }
    
    @GetMapping("/criarUsuario")
    public String criarUsuario(Model model) {
        UsuarioEntity usuario = new UsuarioEntity();
        model.addAttribute("usuario", usuario);
        return "cadastrarUsuario";
    }
    
    @PostMapping("/salvarUsuario")
    public String salvarUsuario(@Valid @ModelAttribute("usuario") UsuarioEntity usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "inserir";
        }
        if (usuario.getId() == null) {
            usuarioService.criarUsuario(usuario);
        }
        return "redirect:/";
    }
}
