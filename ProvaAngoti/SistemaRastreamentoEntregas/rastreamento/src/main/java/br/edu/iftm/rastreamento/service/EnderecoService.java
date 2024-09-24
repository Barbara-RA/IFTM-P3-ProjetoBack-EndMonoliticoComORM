package br.edu.iftm.rastreamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.rastreamento.model.Endereco;
import br.edu.iftm.rastreamento.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    public EnderecoRepository enderecoRepository;

    public List<Endereco> enderecos() {
        return (List<Endereco>) enderecoRepository.findAll();
    }

    public Endereco criar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

}
