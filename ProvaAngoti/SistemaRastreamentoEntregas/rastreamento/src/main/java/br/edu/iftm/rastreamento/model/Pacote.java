package br.edu.iftm.rastreamento.model;

import java.sql.Date;
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
    // endereço de entrega, status da entrega (por exemplo, "pendente", "em
    // trânsito", "entregue").

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localizadorPacoteId;
    private String destinatario;

    // nessa relação, um endereço pode ter vários pacotes
    @ManyToOne
    private Endereco endereco;

    private String status;

    // Neste caso, um pacote pode ter vários rastreamentos

    @OneToMany(mappedBy = "pacote")
    private List<Rastreamento> rastreamentos = new ArrayList<>();

    // - Métodos:
    // - atualizarStatus(novoStatus: String, dataHora: Date, localizacao: String):
    // void - Atualiza o status do pacote e registra o rastreamento.
    public void atualizarStatus(String status, Date dataHora, String localizacao) {
        this.status = status;
        Rastreamento rastreamento = new Rastreamento();
        rastreamento.setDataHora(dataHora);
        rastreamento.setLocalizacao(localizacao);
        rastreamento.setStatus(status);
        rastreamento.setPacote(this);
        rastreamentos.add(rastreamento);
    }

    // - consultarInformacoes(): String - Retorna todas as informações do pacote,
    // incluindo o status atual e rastreamento histórico.

    public String consultarInformacoes() {
        String informacoes = "Pacote: " + localizadorPacoteId + "\n";
        informacoes += "Destinatário: " + destinatario + "\n";
        informacoes += "Endereço de entrega: " + endereco + "\n";
        informacoes += "Status: " + status + "\n";
        informacoes += "Rastreamento: \n";
        for (Rastreamento rastreamento : rastreamentos) {
            informacoes += rastreamento + "\n";
        }
        return informacoes;
    }

}
