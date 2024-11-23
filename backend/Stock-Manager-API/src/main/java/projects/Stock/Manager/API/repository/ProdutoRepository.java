package projects.Stock.Manager.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.Stock.Manager.API.domain.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
