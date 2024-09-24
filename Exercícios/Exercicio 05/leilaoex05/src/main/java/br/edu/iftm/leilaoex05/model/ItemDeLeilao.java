package br.edu.iftm.leilaoex05.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class ItemDeLeilao {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double valorMinimo;
    private boolean leilaoAberto;

    //FetchType.EAGER é o padrão do JPA.
    @OneToMany(fetch = FetchType.EAGER)
    private List<Lance> lances;

    @OneToOne
    private Lance lancevencedor;

    public ItemDeLeilao(String nome, double valorMinimo, boolean leilaoAberto) {
        super();
        this.nome = nome;
        this.valorMinimo = valorMinimo;
        this.leilaoAberto = leilaoAberto;
    }

    //Método que registra o lance e se existe um item na lista
    public void registrarLance(Lance lance) {
        if(this.lances==null) {
            this.lances = new ArrayList<Lance>();
        }

        if(lance.getValor() > this.valorMinimo) {
            this.lances.add(lance);

            if(this.lancevencedor==null) {
                this.lancevencedor = new Lance();
                this.lancevencedor.setValor(0);
            }
            
            if(lance.getValor() > this.lancevencedor.getValor()) {
                this.lancevencedor = lance;
            }
        }
    }
}
