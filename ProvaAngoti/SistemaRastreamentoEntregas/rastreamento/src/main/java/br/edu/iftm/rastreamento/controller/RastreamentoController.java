package br.edu.iftm.rastreamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.service.RastreamentoService;

@RestController
@RequestMapping("/rastreamento")
public class RastreamentoController {
    @Autowired
    public RastreamentoService rastreamentoService;

    // - GET /rastreamentos/{id} - Consulta todos os rastreamentos de um pacote
    // específico.
    @GetMapping("/{id}")
    public Rastreamento buscar(@PathVariable Long id) {
        return rastreamentoService.buscar(id);
    }

}
