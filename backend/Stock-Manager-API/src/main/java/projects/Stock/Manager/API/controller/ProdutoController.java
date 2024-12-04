package projects.Stock.Manager.API.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import projects.Stock.Manager.API.Service.ProdutoService;
import projects.Stock.Manager.API.dto.AtualizacaoProdutoDTO;
import projects.Stock.Manager.API.dto.CadastroProdutoDTO;
import projects.Stock.Manager.API.dto.ListagemProdutoDTO;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;

	@PostMapping
	@Transactional
	public ResponseEntity criar(@RequestBody @Valid CadastroProdutoDTO dados, UriComponentsBuilder uriBuilder){
		return produtoService.guardarProduto(dados, uriBuilder);
	}

	@GetMapping
	public ResponseEntity<List<ListagemProdutoDTO>> ler(){
		return produtoService.listarProdutos();
	}

	@GetMapping("/{id}")
	public ResponseEntity lerEspecifico(@PathVariable Long id) {
		return produtoService.buscarProdutoPorId(id);
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoProdutoDTO dados) {
		return produtoService.atualizarProduto(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id){
		return produtoService.removerProduto(id);
	}
}
