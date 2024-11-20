package projects.Stock.Manager.API.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import org.springframework.web.bind.annotation.*;
import projects.Stock.Manager.API.dto.AtualizacaoProdutoDTO;
import projects.Stock.Manager.API.dto.CadastroProdutoDTO;
import projects.Stock.Manager.API.dto.ListagemProdutoDTO;
import projects.Stock.Manager.API.produto.Produto;
import projects.Stock.Manager.API.repository.ProdutoRepository;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid CadastroProdutoDTO dados){
		repository.save(new Produto(dados));

	}

	@GetMapping
	public List<ListagemProdutoDTO> listar(){
		return repository.findAll().stream().map(ListagemProdutoDTO::new).toList();
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid AtualizacaoProdutoDTO dados){
		var produto = repository.getReferenceById(dados.id());
		produto.atualizarInformacoes(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id){
		repository.deleteById(id);
	}
}
