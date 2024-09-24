package br.edu.iftm.rastreamento.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Pacote {
    // Pacote: Deve conter informações como identificador único, destinatário,
    // endereço de entrega, status da entrega (por exemplo, "pendente", "em trânsito", "entregue").

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localizadorPacoteId;
    private String destinatario;

    // nessa relação, um endereço pode ter vários pacotes
    @ManyToOne
    private Endereco endereco;
    private String status;


    //Neste caso, um pacote pode ter vários rastreamentos
    @OneToMany
    private List<Rastreamento> rastreamentos = new ArrayList<>();

    // - Métodos:
    // - atualizarStatus(novoStatus: String, dataHora: Date, localizacao: String):
    // void - Atualiza o status do pacote e registra o rastreamento.
    // - consultarInformacoes(): String - Retorna todas as informações do pacote,
    // incluindo o status atual e rastreamento histórico.

    



}
