package projects.Stock.Manager.API.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import projects.Stock.Manager.API.domain.produto.Produto;
import projects.Stock.Manager.API.dto.CadastroProdutoDTO;
import projects.Stock.Manager.API.dto.ProdutoDetalhadoDTO;
import projects.Stock.Manager.API.service.ProdutoService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ProdutoControllerTest {


	@Autowired
	private MockMvc mvc;

	@Autowired
	private JacksonTester<CadastroProdutoDTO> cadastroProdutoDTOJson;

	@Autowired
	private JacksonTester<ProdutoDetalhadoDTO> produtoDetalhadoDTOJson;

	@MockBean
	private ProdutoService produtoService;

	@Test
	@DisplayName("Deveria devolver codigo http 404 quando informacoes estao invalidas")
	void cenario1() throws Exception {
		var id = Integer.MAX_VALUE;
		var response = mvc.perform(get("/produtos/{id}", id))
			.andReturn()
			.getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	}

	@Test
	@DisplayName("Deveria devolver código http 200 quando informações estão válidas")
	void cenario2() throws Exception {
		Long id = 1L;
		var nome = "teste";
		var marca = "teste";
		var categoria = "teste";
		var valor = 0.0;
		var quantidade = 0;
		var imagem = "teste";
		var descricao = "teste";

		Produto produto = new Produto(id,nome,marca,categoria,valor,quantidade,imagem,descricao);
		when(produtoService.buscarProdutoPorId(id)).thenReturn(produto);  // Mock do serviço

		var response = mvc.perform(get("/produtos/{id}", id))
			.andReturn()
			.getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	@DisplayName ("Deveria retornar codigo http 201 quando informacoes estão validas")
	void cenario3() throws Exception {
		var nome = "teste";
		var marca = "teste";
		var categoria = "teste";
		var valor = 0.0;
		var quantidade = 0;
		var imagem = "teste";
		var descricao = "teste";



		var response = mvc
			.perform(
			post("/produtos").contentType(MediaType.APPLICATION_JSON)
				.content(cadastroProdutoDTOJson.write(
					new CadastroProdutoDTO(nome,marca,categoria,valor,quantidade,imagem,descricao)
				).getJson())
		).andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

		var jsonEsperado = produtoDetalhadoDTOJson.write(
			new ProdutoDetalhadoDTO(0L,nome,marca,categoria,valor,quantidade,imagem,descricao)
		).getJson();
		assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
	}
}
