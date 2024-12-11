package projects.Stock.Manager.API.Service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import projects.Stock.Manager.API.domain.produto.Produto;
import projects.Stock.Manager.API.dto.CadastroProdutoDTO;
import projects.Stock.Manager.API.dto.ProdutoDetalhadoDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ProdutoServiceTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private JacksonTester<CadastroProdutoDTO> cadastroProdutoDTOJacksonTester;
	@Autowired
	private JacksonTester<ProdutoDetalhadoDTO> produtoDetalhadoDTOJacksonTester;

	@MockBean
	private ProdutoService produtoService;

	@Test
	@DisplayName("Deveria devolver codigo HTTP 404 ao passar um ID inexistente")
	void buscarProdutoInexistente() throws Exception {
		long id = 42000;
		var response = mvc.perform(get("/produtos/"+id)).andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	}
	@Test
	@DisplayName("Deveria devolver codigo HTTP 200 quando informações estão validas")
	void enviarDadosValidos() throws Exception {
		var id = 1;
		var nomeProduto = "Carro";
		var marcaProduto = "Ford";
		var categoriaProduto = "veiculo";
		var valorProduto = 40000.00;
		var quantidadeProduto = 1;
		var imagemProduto = "imagem";
		var descricaoProduto = "descricao";

		var produtoDetalhado = new ProdutoDetalhadoDTO(id,nomeProduto,marcaProduto,categoriaProduto,valorProduto,quantidadeProduto,imagemProduto,descricaoProduto);
//		when(produtoService.guardarProduto()).thenReturn(dadosDetalhamento);

		var response = mvc
			.perform(
				post("/produtos")
					.contentType(cadastroProdutoDTOJacksonTester.write(
						new CadastroProdutoDTO(nomeProduto,marcaProduto,categoriaProduto,valorProduto,quantidadeProduto,imagemProduto,descricaoProduto)
					).getJson())

			)

			.andReturn().getResponse();


		var jsonEsperado =  produtoDetalhadoDTOJacksonTester.write(
			new ProdutoDetalhadoDTO(1,nomeProduto,marcaProduto,categoriaProduto,valorProduto,quantidadeProduto,imagemProduto,descricaoProduto)).getJson();
		assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
	}

}
