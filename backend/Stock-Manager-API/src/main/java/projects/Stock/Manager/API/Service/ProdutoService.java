package projects.Stock.Manager.API.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import projects.Stock.Manager.API.domain.produto.Produto;
import projects.Stock.Manager.API.dto.AtualizacaoProdutoDTO;
import projects.Stock.Manager.API.infra.exception.ProductNotFoundException;
import projects.Stock.Manager.API.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> listarProdutos() {
		return repository.findAll();

	}

	public Produto buscarProdutoPorId(long id) {
		try{
			return  repository.getReferenceById(id);
		}catch (Exception e){
			throw new ProductNotFoundException("Produto de id: "+ id +" não existe");
		}
	}

	public  void guardarProduto(Produto produto) {
		repository.save(produto);
	}

	public Produto atualizarProduto(AtualizacaoProdutoDTO dados) {
		var produto = repository.getReferenceById(dados.id());
		produto.atualizarInformacoes(dados);
		return produto;
	}

	public void removerProduto(long id) {
		repository.deleteById(id);
	}
}
