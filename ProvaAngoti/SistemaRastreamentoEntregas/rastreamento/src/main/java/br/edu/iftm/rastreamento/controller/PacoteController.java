package br.edu.iftm.rastreamento.controller;

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

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.service.PacoteService;

@RestController
@RequestMapping("/pacote")
public class PacoteController {
    @Autowired
    public PacoteService pacoteService;

    // - GET /pacotes - Consulta todos os pacotes.
    @GetMapping
    public List<Pacote> pacotes() {
        return pacoteService.pacotes();
    }

    // - POST /pacotes - Adiciona um novo pacote.
    @PostMapping
    public Pacote criar(@RequestBody Pacote pacote) {
        return pacoteService.criar(pacote);
    }

    // - GET /pacotes/{id} - Consulta um pacote específico.
    @GetMapping("/{id}")
    public Pacote buscar(@PathVariable Long id) {
        return pacoteService.buscar(id);
    }

    // - PUT /pacotes/{id} - Atualiza as informações de um pacote.
    @PutMapping("/{id}")
    public Pacote atualiza(@PathVariable Long id, @RequestBody Pacote pacote) {
        return pacoteService.atualiza(id, pacote);
    }

    // - DELETE /pacotes/{id} - Remove um pacote.
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pacoteService.delete(id);
    }

}
