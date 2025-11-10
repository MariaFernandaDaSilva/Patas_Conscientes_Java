package com.projeto.api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.Ong;
import com.projeto.service.OngService;

@RestController
@RequestMapping("/ongapi")
public class OngApi {
    private OngService ongService;

    public OngApi (OngService ongService){
        this.ongService = ongService;
    }

    @GetMapping 
    @ResponseBody
    public ResponseEntity<List<Ong>> listar(){
        return new ResponseEntity<List<Ong>>(this.ongService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Ong> getPorId(@PathVariable("id") long id){
        Optional<Ong> opOng = this.ongService.getPorId(id);
        if (opOng.isPresent()) {
            return new ResponseEntity<Ong>(opOng.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Ong> cadastrar(@RequestBody Ong ong) {
        return new ResponseEntity<Ong>(this.ongService.salvar(ong), HttpStatus.CREATED);
    }
}
