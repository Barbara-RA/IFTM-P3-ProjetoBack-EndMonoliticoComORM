package br.edu.iftm.rastreamento.model;

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
public class Endereco {
    // Requisitos funcionais
    // Endereço: Deve registrar informações como rua, número, cidade, estado e CEP.

    // - Atributos:
    // - rua: String
    // - numero: String
    // - cidade: String
    // - estado: String
    // - cep: String

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

}
