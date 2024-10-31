import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { ContainerComponent } from './shared/container/container.component';
import { GerenciarProdutosComponent } from './pages/gerenciar-produtos/gerenciar-produtos.component';
import { EstoqueComponent } from './pages/estoque/estoque.component';
import { CommonModule } from '@angular/common';

@Component({
	selector: 'app-root',
	standalone: true,
	imports: [
		RouterOutlet,
		HeaderComponent,
		FooterComponent,
		ContainerComponent,
		GerenciarProdutosComponent,
		EstoqueComponent,
	],
	templateUrl: './app.component.html',
	styleUrl: './app.component.scss',
})
export class AppComponent {
	title = 'stock-manager';
}
