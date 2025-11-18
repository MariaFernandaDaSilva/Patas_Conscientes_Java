package com.projeto.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.projeto.model.Ong;
import com.projeto.repository.OngRepository;

@Service
public class OngService {

    private OngRepository ongRepository;

    public OngService(OngRepository ongRepository) {
        this.ongRepository = ongRepository;
    }

    public Ong salvar(Ong ong) {
        return this.ongRepository.save(ong);
    }

    public List<Ong> listar() {
        return this.ongRepository.findAll();
    }

    public Optional<Ong> getPorId(long id) {
        return this.ongRepository.findById(id);
    }

    public void excluir(long id) {
        this.ongRepository.deleteById(id);
    }

    public List<Ong> pesquisarPorNomeOuResponsavel(String termo) {
        return ongRepository.pesquisarPorNomeOuResponsavel(termo);
    }

}
