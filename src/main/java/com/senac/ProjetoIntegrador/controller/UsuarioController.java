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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    AlimentoController controller;

    @GetMapping("/")
    public String MostrarPaginaLogin(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return "login";
    }
    
    @GetMapping("/criarUsuario")
    public String criarUsuario(Model model) {
        UsuarioEntity usuario = new UsuarioEntity();
        model.addAttribute("usuario", usuario);
        return "cadastrarUsuario";
    }

    @PostMapping("/salvarUsuario")
    public String salvarUsuario(@ModelAttribute("usuario") UsuarioEntity usuario) {
        if (usuario.getId() == null) {
            usuarioService.criarUsuario(usuario);
        }
        return "redirect:/";
    }

    @PostMapping("/fazerLogin")
    public String processarLogin(@ModelAttribute("usuario") UsuarioEntity usuario, Model model) {
        boolean autenticado = usuarioService.autenticarUsuario(usuario.getEmail(), usuario.getSenha());

        if (autenticado) {
            return controller.mostrarIndex(model); // Redireciona para página protegida
        } else {
            model.addAttribute("erro", "E-mail ou senha inválidos.");
            return "login";
        }
    }

    @GetMapping("/atualizarSenha")
    public String mostrarFormularioRedefinir(Model model) {
        model.addAttribute("usuario", new UsuarioEntity()); // classe com email e senha
        return "esqueciMinhaSenha";
    }

    @PostMapping("/salvarSenha")
    public String redefinirSenha(@ModelAttribute("usuario") UsuarioEntity usuario, Model model) {
        boolean atualizado = usuarioService.atualizarSenha(usuario.getEmail(), usuario.getSenha());

        if (atualizado) {
            return "redirect:/";
        } else {
            model.addAttribute("erro", "E-mail não encontrado.");
            return "esqueciMinhaSenha";
        }
    }
    
    @GetMapping("/criarTmb")
    public String criarTmb(Model model) {
        UsuarioEntity usuario = new UsuarioEntity();
        model.addAttribute("usuario", usuario);
        return "tmb";
    }
}
