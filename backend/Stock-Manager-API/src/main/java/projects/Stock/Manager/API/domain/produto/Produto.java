package projects.Stock.Manager.API.domain.produto;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import projects.Stock.Manager.API.dto.AtualizacaoProdutoDTO;
import projects.Stock.Manager.API.dto.CadastroProdutoDTO;

@Table(name = "produtos")
@Entity(name = "Medico")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String marca;
	private String categoria;
	private Double valor;
	private int quantidade;
	private String imagem;
	private String descricao;

	public Produto(CadastroProdutoDTO dados) {
		this.nome = dados.nome();
		this.marca = dados.marca();
		this.categoria = dados.categoria();
		this.valor = dados.valor();
		this.quantidade = dados.quantidade();
		this.imagem = dados.imagem();
		this.descricao = dados.descricao();
	}

	public void atualizarInformacoes(AtualizacaoProdutoDTO dados) {

		if (dados.nome() != null) {
			this.nome = dados.nome();

		}
		if (dados.marca() != null) {
			this.marca = dados.marca();

		}
		if (dados.categoria() != null) {
			this.categoria = dados.categoria();

		}
		if (dados.valor() != null) {
			this.valor = dados.valor();

		}
		if (dados.quantidade() != 0) {
			this.quantidade = dados.quantidade();

		}
		if (dados.imagem() != null) {
			this.imagem = dados.imagem();

		}
		if (dados.descricao() != null) {
			this.descricao = dados.descricao();
		}



	}
}
