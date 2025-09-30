package com.projeto.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.projeto.model.Serie;
import com.projeto.repository.SerieRepository;

@Service
public class SerieService {
    private SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public Serie salvar(Serie serie) {
        return this.serieRepository.save(serie);
    }

    public List<Serie> listar(){
        return this.serieRepository.findAll();
    }

    public Optional<Serie> getPorId(long id){
        return this.serieRepository.findById(id);
    }
}
