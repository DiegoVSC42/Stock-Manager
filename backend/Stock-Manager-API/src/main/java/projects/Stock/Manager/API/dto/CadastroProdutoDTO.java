package projects.Stock.Manager.API.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CadastroProdutoDTO(

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
	){
}
