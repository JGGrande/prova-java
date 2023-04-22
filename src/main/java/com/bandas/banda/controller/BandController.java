package com.bandas.banda.controller;

import com.bandas.banda.model.Banda;
import com.bandas.banda.service.BandaService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BandController {
    @Autowired
    private BandaService service;

    @RequestMapping("/")
    private String iniciar(Banda banda, Model model) {
        model.addAttribute("bemVindo", "Bem Vindo");
        return "formulario";
    }

    @PostMapping("salvar")
    public String salvar(Banda banda, Model model) {
        service.salvarBanda(banda);
        return "redirect:/lista";
    }

    @GetMapping("lista")
    public String listar(Model model) {
        model.addAttribute("bemVindo", "Prova Ranghetti");
        model.addAttribute("listaBandas", service.listarTodos());
        return "lista";
    }

    @GetMapping("alterar/{id}")
    public String alterar(@PathVariable Integer id, Model model) {
        model.addAttribute("bemVindo", "Prova Ranghetti");
        model.addAttribute("banda", service.buscarPorId(id));
        return "formulario";
    }
    @GetMapping("remover/{id}")
    public  String remover(@PathVariable Integer id, Model model) {
        var idBanda = service.buscarPorId(id);
        service.remover(idBanda);
        return "redirect:/lista";
    }
}

