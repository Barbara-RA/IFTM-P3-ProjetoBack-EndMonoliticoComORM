package br.edu.iftm.leilaoex05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilaoex05.model.ItemDeLeilao;
import br.edu.iftm.leilaoex05.model.Lance;
import br.edu.iftm.leilaoex05.service.ItemDeLeilaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/itemdeleilao")
public class ItemDeLeilaoController {
    @Autowired
    public ItemDeLeilaoService itemDeLeilaoService;


    // {DELETE [/itemdeleilao/{id}]}: delete(Long)
    // atraves do id, deleta o item de leilao
    @DeleteMapping("/{id}")
    public void delete(Long id) {
        itemDeLeilaoService.delete(id);
    }

    // {GET [/itemdeleilao/{id}]}: item(Long)
    // atraves do id, o usuário quer visualizar item de leilão é preciso retornar o item de leilaos
    @GetMapping("/{id}")
    public ItemDeLeilao buscar(@PathVariable Long id) {
        return itemDeLeilaoService.buscar(id);
    }
    
    // {PUT [/itemdeleilao/{id}]}: atualiza(Long,ItemDeLeilao)
    // atraves do id, atualiza o item de leilao com as novas informações
    @PutMapping("/{id}")
    public ItemDeLeilao atualiza (@PathVariable Long id, @RequestBody ItemDeLeilao itemDeLeilao) {
        return itemDeLeilaoService.atualiza(id, itemDeLeilao);
    }


    // {POST [/itemdeleilao]}: novo(ItemDeLeilao)
    // cria um novo item de leilão criando uma nova instancia de item de leilão
    @PostMapping
    public ItemDeLeilao criar(@RequestBody ItemDeLeilao itemDeLeilao) {   
        return itemDeLeilaoService.criar(itemDeLeilao);
    }
    

    // {GET [/itemdeleilao]}: itens()
    // retorna todos os itens de leilão
    @GetMapping
    public List<ItemDeLeilao> itens() {
        return itemDeLeilaoService.itens();
    }

    // POST /itemdeleilao/{id}
    @PostMapping("/{id}")
    public void darLance(@PathVariable Long id, @RequestBody Lance lance) {
        itemDeLeilaoService.darLance(id, lance);
    }


    // PATCH /itemdeleilao/{id}

    @PatchMapping("/{id}")
    public Lance finalizarLeilao(@PathVariable Long id) {
        return itemDeLeilaoService.finalizarLeilao(id);
    }

    

}
