package projects.Stock.Manager.API.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoProdutoDTO(
	@NotNull
	Long id,
	String nome,
	String marca,
	String categoria,
	Double valor,
	int quantidade,
	String imagem,
	String descricao
) {
}
