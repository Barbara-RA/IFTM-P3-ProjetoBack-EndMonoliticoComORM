package br.edu.iftm.pessoaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.pessoaapi.domain.Pessoa;
import br.edu.iftm.pessoaapi.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public List<Pessoa> recuperaTodosRegistros() {
        return service.todos();
    }

    @PostMapping
    public Pessoa criaNovoRegistro(@RequestBody Pessoa pessoa) {
        return service.novo(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa buscaUmRegistro(@PathVariable Integer id) {
        return service.busca(id).orElseThrow(() -> new PessoaNaoEncontradaException(id));
    }

    @PutMapping("/{id}")
    public Pessoa atualizaRegistro(@RequestBody Pessoa pessoa, @PathVariable Integer id) {
        return service.atualiza(pessoa, id);
    }

    @DeleteMapping("/{id}")
    void excluiRegistro(@PathVariable Integer id) {
        service.exclui(id);
    }
}
