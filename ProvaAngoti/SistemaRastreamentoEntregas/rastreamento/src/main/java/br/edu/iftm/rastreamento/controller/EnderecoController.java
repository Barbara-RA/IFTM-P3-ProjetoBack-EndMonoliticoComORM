package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.model.Endereco;
import br.edu.iftm.rastreamento.service.EnderecoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    public EnderecoService enderecoService;

    // - GET /enderecos - Consulta todos os endereços.
    @GetMapping
    public List<Endereco> enderecos() {
        return enderecoService.enderecos();
    }

    // - POST /enderecos - Adiciona um novo endereço.
    @PostMapping
    public Endereco criar(@RequestBody Endereco endereco) {
        return enderecoService.criar(endereco);
    }

}
