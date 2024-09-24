package br.edu.iftm.leilaoex05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilaoex05.model.Lance;
import br.edu.iftm.leilaoex05.repository.LanceRepository;


@Service
public class LanceService {

    @Autowired
    private LanceRepository lanceRepository;

    public void delete(Long id) {
        lanceRepository.deleteById(id);
    }

    public Lance buscar(Long id) {
        return lanceRepository.findById(id).get();
        
    }

    public Lance atualiza(Long id, Lance lance) {
        lance.setId(id);
        return lanceRepository.save(lance);
    }

    public List<Lance> lances() {
        return (List<Lance>) lanceRepository.findAll();
    }

}
