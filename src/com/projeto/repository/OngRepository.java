package com.projeto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Ong;

@Repository
public interface OngRepository extends CrudRepository<Ong, Long> {
  public List<Ong> findAll();  
}
