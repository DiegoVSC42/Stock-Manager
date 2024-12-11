package projects.Stock.Manager.API.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import projects.Stock.Manager.API.service.ProdutoService;
import projects.Stock.Manager.API.domain.produto.Produto;
import projects.Stock.Manager.API.dto.AtualizacaoProdutoDTO;
import projects.Stock.Manager.API.dto.CadastroProdutoDTO;
import projects.Stock.Manager.API.dto.ListagemProdutoDTO;
import projects.Stock.Manager.API.dto.ProdutoDetalhadoDTO;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<ListagemProdutoDTO>> ler() {
		var produtos = produtoService.listarProdutos();
		var produtosDTO = produtos.stream().map(ListagemProdutoDTO::new).toList();
		return ResponseEntity.ok(produtosDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity lerEspecifico(@PathVariable Long id) {
		var produto = produtoService.buscarProdutoPorId(id);
		var produtoDTO = new ProdutoDetalhadoDTO(produto);
		return ResponseEntity.ok(produtoDTO);
	}

	@PostMapping
	@Transactional
	public ResponseEntity criar(@RequestBody @Valid CadastroProdutoDTO dados, UriComponentsBuilder uriBuilder) {
		var produto = new Produto(dados);
		produtoService.guardarProduto(produto);
		var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDetalhadoDTO(produto));
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoProdutoDTO dados) {
		var produto = produtoService.atualizarProduto(dados);
		return ResponseEntity.ok(new ProdutoDetalhadoDTO(produto));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id) {
		produtoService.removerProduto(id);
		return ResponseEntity.noContent().build();
	}
}
