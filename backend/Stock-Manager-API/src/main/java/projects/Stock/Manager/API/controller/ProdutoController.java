package projects.Stock.Manager.API.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
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
	public void cadastrar(@RequestBody @Valid CadastroProdutoDTO dados){
		repository.save(new Produto(dados));

	}

	@GetMapping
	public Page<ListagemProdutoDTO> listar(@PageableDefault(size=10,sort={"valor"}) Pageable paginacao){
		return repository.findAll(paginacao).map(ListagemProdutoDTO::new);
	}

}
