package com.projeto.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.projeto.model.Ong;

@Repository
public interface OngRepository extends CrudRepository<Ong, Long> {

  List<Ong> findAll();

  @Query("SELECT o FROM Ong o WHERE o.nome LIKE :termo OR o.responsavel LIKE :termo")
  List<Ong> pesquisarPorNomeOuResponsavel(@Param("termo") String termo);

}
