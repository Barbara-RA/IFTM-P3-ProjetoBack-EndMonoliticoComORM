package br.edu.iftm.leilaoex05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilaoex05.model.ItemDeLeilao;
import br.edu.iftm.leilaoex05.model.Lance;
import br.edu.iftm.leilaoex05.repository.ItemDeLeilaoRepository;
import br.edu.iftm.leilaoex05.repository.LanceRepository;


@Service
public class ItemDeLeilaoService {
    @Autowired
    private ItemDeLeilaoRepository itemDeLeilaoRepository;

    @Autowired
    private LanceRepository lanceRepository;

    public void delete(Long id) {
        itemDeLeilaoRepository.deleteById(id);
    }

    public ItemDeLeilao buscar(Long id) {
        return itemDeLeilaoRepository.findById(id).get();
    }

    public ItemDeLeilao atualiza(Long id, ItemDeLeilao itemDeLeilao) {
        itemDeLeilao.setId(id);
        return itemDeLeilaoRepository.save(itemDeLeilao);
    }

    public ItemDeLeilao criar(ItemDeLeilao itemDeLeilao) {
        return itemDeLeilaoRepository.save(itemDeLeilao);
    }

    public List<ItemDeLeilao> itens() {
        return (List<ItemDeLeilao>) itemDeLeilaoRepository.findAll();
    }


    //Fazendo um lance
    //Essa método é responsável por fazer um lance em um item de leilão ele pesquisa o item de leilão pelo id e faz um lance
    public void darLance(Long id, Lance lance) {
        ItemDeLeilao itemDeLeilao = buscar(id);
        //Verificar se o leilão está aberto
        if(itemDeLeilao.isLeilaoAberto()) {
            itemDeLeilao.registrarLance(lance);
            // salva o Lance mesmo se for inválido
            lanceRepository.save(lance);
            // salva o Item de Leilao
            itemDeLeilaoRepository.save(itemDeLeilao);
        }
    }

    public Lance finalizarLeilao(Long id) {
        ItemDeLeilao itemDeLeilao = buscar(id);
        itemDeLeilao.setLeilaoAberto(false);
        itemDeLeilaoRepository.save(itemDeLeilao);

        return itemDeLeilao.getLancevencedor();
    }

}
