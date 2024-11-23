package projects.Stock.Manager.API.dto;

import projects.Stock.Manager.API.domain.produto.Produto;

public record ProdutoDetalhadoDTO(long id,
								  String nome,
								  String marca,
								  String categoria,
								  Double valor,
								  int quantidade,
								  String imagem,
								  String descricao) {

	public ProdutoDetalhadoDTO(Produto produto) {
		this(produto.getId(), produto.getNome(), produto.getMarca(), produto.getCategoria(), produto.getValor(), produto.getQuantidade(), produto.getImagem(), produto.getDescricao());
	}
}
