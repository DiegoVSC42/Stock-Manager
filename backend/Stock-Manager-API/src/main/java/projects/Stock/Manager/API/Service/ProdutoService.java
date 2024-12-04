package projects.Stock.Manager.API.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import projects.Stock.Manager.API.domain.produto.Produto;
import projects.Stock.Manager.API.dto.AtualizacaoProdutoDTO;
import projects.Stock.Manager.API.dto.CadastroProdutoDTO;
import projects.Stock.Manager.API.dto.ListagemProdutoDTO;
import projects.Stock.Manager.API.dto.ProdutoDetalhadoDTO;
import projects.Stock.Manager.API.infra.exception.ProductNotFoundException;
import projects.Stock.Manager.API.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;

	public ResponseEntity buscarProdutoPorId(long id) {
		try{
			var produto = repository.getReferenceById(id);
			return ResponseEntity.ok(new ProdutoDetalhadoDTO(produto));
		}catch (Exception e){
			throw new ProductNotFoundException("Produto de id: "+ id +" não existe");
		}
	}
	public  ResponseEntity guardarProduto(CadastroProdutoDTO dados, UriComponentsBuilder uriBuilder) {
		var produto = new Produto(dados);
		repository.save(produto);
		var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDetalhadoDTO(produto));
	}
	public ResponseEntity listarProdutos() {
		var page = repository.findAll().stream().map(ListagemProdutoDTO::new).toList();
		return ResponseEntity.ok(page);
	}
	public ResponseEntity atualizarProduto(AtualizacaoProdutoDTO dados) {
		var produto = repository.getReferenceById(dados.id());
		produto.atualizarInformacoes(dados);

		return ResponseEntity.ok(new ProdutoDetalhadoDTO(produto));
	}
	public ResponseEntity removerProduto(long id) {
		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
