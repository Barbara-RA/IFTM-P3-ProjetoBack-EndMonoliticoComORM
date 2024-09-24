package br.edu.iftm.leilaoex05.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.leilaoex05.model.Lance;


@Repository
public interface LanceRepository extends CrudRepository<Lance,Long>{

    
}
