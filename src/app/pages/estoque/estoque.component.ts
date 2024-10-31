import { Component } from '@angular/core';
import { ContainerComponent } from '../../shared/container/container.component';
import { CardProdutoComponent } from '../../shared/card-produto/card-produto.component';
import { Produto } from './produto';
import { ProdutoService } from '../../services/produto.service';

@Component({
	selector: 'app-estoque',
	standalone: true,
	imports: [ContainerComponent, CardProdutoComponent],
	templateUrl: './estoque.component.html',
	styleUrl: './estoque.component.scss',
})
export class EstoqueComponent {
	produtos: Produto[] = [];

	constructor(private produtoSevice: ProdutoService) {}

	ngOnInit() {
		this.produtoSevice.obterProdutos().subscribe((listaProdutos) => {
			this.produtos = listaProdutos;
		});
	}
}
