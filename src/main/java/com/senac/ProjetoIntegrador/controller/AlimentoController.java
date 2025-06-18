package com.senac.ProjetoIntegrador.controller;

import com.senac.ProjetoIntegrador.data.AlimentoEntity;
import com.senac.ProjetoIntegrador.data.AlimentoRepository;
import com.senac.ProjetoIntegrador.service.AlimentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping("/criarAlimento")
    public String criarAlimento(Model model) {
        AlimentoEntity alimento = new AlimentoEntity();
        model.addAttribute("alimento", alimento);
        return "cadastrarAlimento";
    }

    @PostMapping("/salvarAlimento")
    public String salvarAlimento(@ModelAttribute("alimento") AlimentoEntity alimento, BindingResult result, Model model) {
        if (alimento.getId() == null) {
            alimentoService.criarAlimento(alimento);
        } else {
            alimentoService.atualizarAlimento(alimento.getId(), alimento);
        }
        return "redirect:/mostrarIndex";
    }

    @GetMapping("/mostrarIndex")
    public String mostrarIndex(Model model) {
        model.addAttribute("listarAlimentos", alimentoService.listarTodosAlimentos());
        return "index";
    }
    
    @GetMapping("/atualizarAlimento/{id}")
    public String atualizarAlimento(@PathVariable(value = "id") Integer id, Model model) {
        AlimentoEntity alimento = alimentoService.getAlimentoId(id);
        model.addAttribute("alimento", alimento);
        return "atualizar";
    }
}
