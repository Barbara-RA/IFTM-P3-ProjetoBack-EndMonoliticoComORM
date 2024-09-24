package br.edu.iftm.rastreamento.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Rastreamento {
    // Requisitos funcionais
    // Rastreamento: Deve registrar a data e hora da atualização, o status da
    // entrega e a localização atual.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataHora;
    private String status;
    private String localizacao;

    // - Métodos:
    // - getResumo(): String - Retorna um resumo das informações de rastreamento.

}
