import { Routes } from '@angular/router';
import { GerenciarProdutosComponent } from './pages/gerenciar-produtos/gerenciar-produtos.component';
import { EstoqueComponent } from './pages/estoque/estoque.component';
import { InfoProdutoComponent } from './pages/info-produto/info-produto.component';

export const routes: Routes = [
	{
		path: 'gerenciar-produtos',
		component: GerenciarProdutosComponent,
	},
	{
		path: 'gerenciar-produtos/:id',
		component: GerenciarProdutosComponent,
	},
	{
		path: 'estoque',
		component: EstoqueComponent,
	},
	{
		path: 'info-produto/:id',
		component: InfoProdutoComponent,
	},
	{
		path: '',
		redirectTo: '/estoque',
		pathMatch: 'full',
	},
];
