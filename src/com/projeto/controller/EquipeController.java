package com.projeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipeController {
    private List<String> colaboradores;

    public EquipeController() {
        this.colaboradores = new ArrayList<>();
        this.colaboradores.add("Teobaldo Junqueira");
        this.colaboradores.add("Magnólia Silva");
        this.colaboradores.add("Benedito Souza");
        this.colaboradores.add("Rosana Oliveira");
    }

    @GetMapping("/equipe")
    public String colaborador(Model model) {
        model.addAttribute("colaboradores", this.colaboradores);
        model.addAttribute("exibir", true);
        return "equipe.jsp";
    }
}
