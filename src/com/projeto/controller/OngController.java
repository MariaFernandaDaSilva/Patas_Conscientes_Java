package com.projeto.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projeto.model.Ong;
import com.projeto.service.OngService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class OngController {
    private OngService ongService;

    public OngController(OngService ongService) {
        this.ongService = ongService;
    }

    @GetMapping("/cadastrarong")
    public String cadastrar() {
        return "cadastrarong.jsp";
    }

    @PostMapping("/cadastrarong")
    public String cadastrar(@ModelAttribute("ong") Ong ong, Model model) {
        Ong novaOng = this.ongService.salvar(ong);
        model.addAttribute("texto", "Ong cadastrada! Código: " + novaOng.getId());
        return "mensagem.jsp";
    }

    @GetMapping("/listarong")
    public String listar(Model model) {
        model.addAttribute("listaOngs", this.ongService.listar());
        return "listarong.jsp";
    }

    @GetMapping("/alterarong")
    public String alterar(HttpServletRequest req, Model model){
        long id = Long.valueOf(req.getParameter("id"));
        Optional<Ong> opOng = this.ongService.getPorId(id);
        if(opOng.isPresent()) {
            model.addAttribute("ong", opOng.get());
            return "alterarong.jsp";
        }else{
            model.addAttribute("texto", "Ong não encontrada!");
            return "mensagem.jsp";
        }
    }

    @PostMapping("/alterarong")
    public String alterar(@ModelAttribute("ong") Ong ong, Model model) {
        Ong ongAtualizada = this.ongService.salvar(ong);
        model.addAttribute("texto", "Ong atualizada! Código: " + ongAtualizada.getId());
        return "mensagem.jsp";
    }
}
