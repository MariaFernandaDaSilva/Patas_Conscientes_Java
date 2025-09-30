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
    private SerieService serieService;

    public OngController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/cadastrarong")
    public String cadastrar() {
        return "cadastrarong.jsp";
    }

    @PostMapping("/cadastrarong")
    public String cadastrar(@ModelAttribute("serie") Serie serie, Model model) {
        Serie novaSerie = this.serieService.salvar(serie);
        model.addAttribute("texto", "Série cadastrada! Código: " + novaSerie.getId());
        return "mensagem.jsp";
    }

    @GetMapping("/listarong")
    public String listar(Model model) {
        model.addAttribute("listaSeries", this.serieService.listar());
        return "listarong.jsp";
    }

    @GetMapping("/alterarong")
    public String alterar(HttpServletRequest req, Model model){
        long id = Long.valueOf(req.getParameter("id"));
        Optional<Serie> opSerie = this.serieService.getPorId(id);
        if(opSerie.isPresent()) {
            model.addAttribute("serie", opSerie.get());
            return "alterarong.jsp";
        }else{
            model.addAttribute("texto", "Série não encontrada!");
            return "mensagem.jsp";
        }
    }

    @PostMapping("/alterarong")
    public String alterar(@ModelAttribute("serie") Serie serie, Model model) {
        Serie serieAtualizada = this.serieService.salvar(serie);
        model.addAttribute("texto", "Série atualizada! Código: " + serieAtualizada.getId());
        return "mensagem.jsp";
    }
}
