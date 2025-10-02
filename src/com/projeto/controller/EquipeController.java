package com.projeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipeController {
    private List<String> equipe;

    public EquipeController() {
        this.equipe = new ArrayList<>();
        this.equipe.add("BARBARA CRISTINA MELLO PAGLIUSO");
        this.equipe.add("CAMILLY ELIZANDRA DE ALMEIDA");
        this.equipe.add("LUCAS LEONARDO DE SOUZA ALVES");
        this.equipe.add("MARIA FERNANDA DA SILVA");
    }

    @GetMapping("/equipe")
    public String colaborador(Model model) {
        model.addAttribute("equipe", this.equipe);
        model.addAttribute("exibir", true);
        return "equipe.jsp";
    }
}
