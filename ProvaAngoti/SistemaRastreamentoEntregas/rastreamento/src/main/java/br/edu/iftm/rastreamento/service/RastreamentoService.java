package br.edu.iftm.rastreamento.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.repository.RastreamentoRepository;

@Service
public class RastreamentoService {

    @Autowired
    private RastreamentoRepository rastreamentoRepository;
    
    public Rastreamento buscar(Long id) {
        return rastreamentoRepository.findById(id).get();
    }
}
