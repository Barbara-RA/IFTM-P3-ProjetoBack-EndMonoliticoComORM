package br.edu.iftm.leilaoex05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilaoex05.model.Participante;
import br.edu.iftm.leilaoex05.repository.ParticipanteRepository;


@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public void delete(Long id) {
        participanteRepository.deleteById(id);
    }


    public Participante criar(Participante participante) {
        return participanteRepository.save(participante);
    }

    public Participante buscar(Long id) {
        return participanteRepository.findById(id).get();
    }

    public Participante atualiza(Long id, Participante participante) {
        participante.setId(id);
        return participanteRepository.save(participante);
    }

    public List<Participante> participantes() {
        return (List<Participante>) participanteRepository.findAll();
    }

    
}
