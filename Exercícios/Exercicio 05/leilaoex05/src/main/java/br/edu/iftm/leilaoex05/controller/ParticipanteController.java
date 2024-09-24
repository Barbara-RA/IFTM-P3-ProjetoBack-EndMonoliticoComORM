package br.edu.iftm.leilaoex05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilaoex05.model.Participante;
import br.edu.iftm.leilaoex05.service.ParticipanteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping ("/participante")
public class ParticipanteController {
    
    @Autowired
    private ParticipanteService participanteService; 


    // {DELETE [/participante/{id}]}: delete(Long)
    // vai deletar um participante pelo id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        participanteService.delete(id);
    }


    // {GET [/participante/{id}]}: participante(Long)
    // vai retornar um participante pelo id
    @GetMapping("/{id}")
    public Participante buscar(@PathVariable Long id){
        return participanteService.buscar(id);
    }
    

    // {PUT [/participante/{id}]}: atualiza(Long,Participante)
    // atualização do participante pelo ID
    @PutMapping("/{id}")
    public Participante atualiza(@PathVariable Long id, @RequestBody Participante participante){
        return participanteService.atualiza(id, participante);
    }


    // {POST [/participante]}: novo(Participante)
    // cria um novo participante criando uma nova instancia de participante
    @PostMapping
    public Participante criar(@RequestBody Participante participante){
        return participanteService.criar(participante);
    }

    // {GET [/participante]}: participantes()
    // vai retornar todos os participantes
    @GetMapping
    public List<Participante> participantes(){
        return participanteService.participantes();
    }
}
