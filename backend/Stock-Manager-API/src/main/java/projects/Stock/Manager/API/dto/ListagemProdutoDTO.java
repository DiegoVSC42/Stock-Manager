package projects.Stock.Manager.API.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import projects.Stock.Manager.API.domain.produto.Produto;


public record ListagemProdutoDTO(

		Long id,
        @NotBlank
        String nome,
        @NotBlank
        String marca,
        @NotBlank
        String categoria,
        @NotNull
        Double valor,
        @NotNull
        int quantidade,
        @NotBlank
        String imagem,
        @NotBlank
        String descricao
) {

    public ListagemProdutoDTO(Produto produto) {
        this(
				produto.getId(),
				produto.getNome(),
				produto.getMarca(),
				produto.getCategoria(),
				produto.getValor(),
				produto.getQuantidade(),
				produto.getImagem(),
				produto.getDescricao());
    }
}
