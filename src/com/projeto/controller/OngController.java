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
    public String alterar(HttpServletRequest req, Model model) {
        long id = Long.valueOf(req.getParameter("id"));
        Optional<Ong> opOng = this.ongService.getPorId(id);
        if (opOng.isPresent()) {
            model.addAttribute("ong", opOng.get());
            return "alterarong.jsp";
        } else {
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

    @GetMapping("/excluirong")
    public String excluir(HttpServletRequest req, Model model) {
        long id = Long.valueOf(req.getParameter("id"));
        Optional<Ong> opOng = this.ongService.getPorId(id);
        if (opOng.isPresent()) {
            this.ongService.excluir(id);
            model.addAttribute("texto", "Ong excluída! Código: " + id);
        } else {
            model.addAttribute("texto", "Ong não encontrada!");
        }
        return "mensagem.jsp";
    }

    // @GetMapping("/pesquisarong")
    // public String pesquisar(HttpServletRequest req, Model model) {
    // String nome = "%" + req.getParameter("nome") + "%";
    // model.addAttribute("listaOngs", this.ongService.pesquisarPorNome(nome));
    // return "listarong.jsp";
    // }

    // @GetMapping("/pesquisarnomeresp")
    // public String pesquisarnomeresp(HttpServletRequest req, Model model) {
    // String responsavel = "%" + req.getParameter("responsavel") + "%";
    // model.addAttribute("listaOngs",
    // this.ongService.pesquisarPorNomeResp(responsavel));
    // return "listarong.jsp";
    // }

    @GetMapping("/pesquisarong")
    public String pesquisar(HttpServletRequest req, Model model) {
        String termo = req.getParameter("termo");

        if (termo == null || termo.isEmpty()) {
            termo = "%";
        } else {
            termo = "%" + termo + "%";
        }

        model.addAttribute("listaOngs", this.ongService.pesquisarPorNomeOuResponsavel(termo));
        return "listarong.jsp";
    }

}
