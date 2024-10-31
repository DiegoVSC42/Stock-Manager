import { Component, OnInit } from '@angular/core';
import { MensagemErroComponent } from '../../shared/mensagem-erro/mensagem-erro.component';
import { ContainerComponent } from '../../shared/container/container.component';
import { Produto } from '../estoque/produto';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ProdutoService } from '../../services/produto.service';

@Component({
	selector: 'app-info-produto',
	standalone: true,
	imports: [MensagemErroComponent, ContainerComponent, RouterLink],
	templateUrl: './info-produto.component.html',
	styleUrl: './info-produto.component.scss',
})
export class InfoProdutoComponent implements OnInit {
	produto: Produto = {
		id: 0,
		imagem: 'https://m.media-amazon.com/images/I/51SM5xU-M1L._AC_SX679_.jpg',
		nome: 'TESTE',
		marca: 'TESTE',
		descricao: 'TESTE',
		categoria: 'TESTE',
		valor: 0,
		quantidade: 0,
	};

	constructor(
		private activatedRoute: ActivatedRoute,
		private produtoService: ProdutoService,
		private router: Router
	) {}

	ngOnInit() {
		const id = this.activatedRoute.snapshot.paramMap.get('id');
		if (id) {
			this.produtoService
				.buscarPorId(parseInt(id))
				.subscribe((produto) => {
					this.produto = produto;
				});
		}
	}

	excluir() {
		if (this.produto.id) {
			this.produtoService
				.excluirProduto(this.produto.id)
				.subscribe(() => {
					this.router.navigateByUrl('/estoque');
				});
		}
	}
}
