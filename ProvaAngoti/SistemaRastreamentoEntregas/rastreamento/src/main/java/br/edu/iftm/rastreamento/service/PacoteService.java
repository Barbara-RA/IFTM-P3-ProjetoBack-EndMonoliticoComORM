package br.edu.iftm.rastreamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.repository.PacoteRepository;

@Service
public class PacoteService {
    @Autowired
    public PacoteRepository pacoteRepository;

    public List<Pacote> pacotes() {
        return (List<Pacote>) pacoteRepository.findAll();
    }

    public Pacote criar(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public Pacote buscar(Long id) {
        return pacoteRepository.findById(id).get();
    }

    public Pacote atualiza(Long id, Pacote pacote) {
        pacote.setId(id);
        return pacoteRepository.save(pacote);
    }

    public void delete(Long id) {
        pacoteRepository.deleteById(id);
    }

}
