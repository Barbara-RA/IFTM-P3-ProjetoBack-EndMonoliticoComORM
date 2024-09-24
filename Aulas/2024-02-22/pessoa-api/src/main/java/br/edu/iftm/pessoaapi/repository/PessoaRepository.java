package br.edu.iftm.pessoaapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.iftm.pessoaapi.domain.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {
    @Override
    List<Pessoa> findAll();
}