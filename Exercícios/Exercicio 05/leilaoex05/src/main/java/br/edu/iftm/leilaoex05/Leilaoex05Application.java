package br.edu.iftm.leilaoex05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.leilaoex05.controller.ItemDeLeilaoController;
import br.edu.iftm.leilaoex05.controller.ParticipanteController;
import br.edu.iftm.leilaoex05.model.ItemDeLeilao;
import br.edu.iftm.leilaoex05.model.Lance;
import br.edu.iftm.leilaoex05.model.Participante;

@SpringBootApplication
public class Leilaoex05Application implements CommandLineRunner{
	@Autowired
	ParticipanteController participanteController = new ParticipanteController();

	@Autowired
	ItemDeLeilaoController itemDeLeilaoController = new ItemDeLeilaoController();


	public static void main(String[] args) {
		SpringApplication.run(Leilaoex05Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Testes de criação do participante
		Participante participante = participanteController.criar(new Participante("Vitor", "1345678911"));
		Participante participante02 = participanteController.criar(new Participante("Camilla", "66666666666"));
		System.out.println(participanteController.buscar(participante.getId())+"\n"+participanteController.buscar(participante02.getId()));
		
		// Testes de atualização do participante
		participante.setCpf("45679123662");
		participanteController.atualiza(participante.getId(), participante);
		System.out.println(participanteController.buscar(participante.getId()));


		// Testes de exclusão do participante
		participanteController.delete(participante.getId());
		System.out.println(participanteController.participantes());

		// Testes de criação do item de leilão
		ItemDeLeilao item = itemDeLeilaoController.criar(new ItemDeLeilao("Bola", 50.0,true ));


		//acionando um método de item de leilão Controller para dar um lance
		itemDeLeilaoController.darLance(item.getId(), new Lance(100.0, participante02));
		itemDeLeilaoController.darLance(item.getId(), new Lance(400.0, participante02));

		//finalizar o leilão
		Lance lanceGanhador = itemDeLeilaoController.finalizarLeilao(item.getId());

		System.out.println(lanceGanhador);
		System.out.println(itemDeLeilaoController.buscar(item.getId()));
		
		
	}

}
