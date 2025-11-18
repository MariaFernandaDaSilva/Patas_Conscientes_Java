package com.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SobrenosController {
    
    @GetMapping("/sobrenos")
    public String empresa(Model model) {
        model.addAttribute("texto", "Exemplo de mensagem para a View");
        return "sobrenos.jsp";
    }
}
