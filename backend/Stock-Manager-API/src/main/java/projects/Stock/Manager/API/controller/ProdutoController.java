package projects.Stock.Manager.API.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.Stock.Manager.API.dto.CadastroProdutoDTO;
import projects.Stock.Manager.API.produto.Produto;
import projects.Stock.Manager.API.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;

	@PostMapping
	public void cadastrar(@RequestBody @Valid CadastroProdutoDTO dados){
		repository.save(new Produto(dados));

	}

}
