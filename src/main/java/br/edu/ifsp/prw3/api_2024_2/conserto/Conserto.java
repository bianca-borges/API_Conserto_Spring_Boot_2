package br.edu.ifsp.prw3.api_2024_2.conserto;

import br.edu.ifsp.prw3.api_2024_2.mecanico.Mecanico;
import br.edu.ifsp.prw3.api_2024_2.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entrada;
    private String saida;

    @Embedded
    private Veiculo veiculo;

    @Embedded
    private Mecanico mecanico;

    public Conserto(DadosConserto dados) {
        this.entrada = dados.entrada();
        this.saida = dados.saida();
        this.veiculo = new Veiculo(dados.veiculo());
        this.mecanico = new Mecanico(dados.mecanico());
    }
}
