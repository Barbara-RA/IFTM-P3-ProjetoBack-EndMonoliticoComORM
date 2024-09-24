package br.edu.iftm.leilaoex05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilaoex05.model.Lance;
import br.edu.iftm.leilaoex05.service.LanceService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/lance")
public class LanceController {
    @Autowired
    public LanceService lanceService;

    // {DELETE [/lance/{id}]}: delete(Long)
    // vai deletar um lance pelo id
    @DeleteMapping("/{id}")
    public void delete(Long id) {
        lanceService.delete(id);
    }


    // {GET [/lance/{id}]}: lance(Long)
    // vai retornar um lance pelo id

    @GetMapping("/{id}")
    public Lance buscar(@RequestParam Long id){
        return lanceService.buscar(id);
    }
    

    // {PUT [/lance/{id}]}: atualiza(Long,Lance)
    // atualização do lance pelo ID
    @PutMapping("/{id}")
    public Lance atualizar(@PathVariable Long id, @RequestBody Lance lance) {      
        return lanceService.atualiza(id, lance);
    }


    // {GET [/lance]}: lances()
    // vai retornar todos os lances
    @GetMapping
    public List<Lance> lances() {
        return lanceService.lances();
    }

}
