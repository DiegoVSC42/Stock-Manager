package projects.Stock.Manager.API.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import projects.Stock.Manager.API.dto.AtualizacaoProdutoDTO;
import projects.Stock.Manager.API.dto.CadastroProdutoDTO;
import projects.Stock.Manager.API.dto.ListagemProdutoDTO;
import projects.Stock.Manager.API.dto.ProdutoDetalhadoDTO;
import projects.Stock.Manager.API.domain.produto.Produto;
import projects.Stock.Manager.API.repository.ProdutoRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid CadastroProdutoDTO dados, UriComponentsBuilder uriBuilder){
		var produto = new Produto(dados);
		repository.save(produto);
		var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDetalhadoDTO(produto));
	}

	@GetMapping
	public ResponseEntity<List<ListagemProdutoDTO>> listar(){
		var page = repository.findAll().stream().map(ListagemProdutoDTO::new).toList();
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity pesquisarPorID(@PathVariable Long id) {
		var produto = repository.getReferenceById(id);
		return ResponseEntity.ok(new ProdutoDetalhadoDTO(produto));
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoProdutoDTO dados) {
		var produto = repository.getReferenceById(dados.id());
		produto.atualizarInformacoes(dados);

		return ResponseEntity.ok(new ProdutoDetalhadoDTO(produto));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id){
		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
