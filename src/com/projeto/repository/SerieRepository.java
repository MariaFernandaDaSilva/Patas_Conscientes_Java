package com.projeto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Serie;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Long> {
  public List<Serie> findAll();  
}
