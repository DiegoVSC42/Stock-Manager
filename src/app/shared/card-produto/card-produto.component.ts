import { Component, Input } from '@angular/core';

import { ContainerComponent } from '../container/container.component';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
	selector: 'app-card-produto',
	standalone: true,
	imports: [ContainerComponent, RouterLink, CommonModule],
	templateUrl: './card-produto.component.html',
	styleUrl: './card-produto.component.scss',
})
export class CardProdutoComponent {
	@Input() imagem: string = '';
	@Input() nome: string = '';
	@Input() marca: string = '';
	@Input() categoria: string = '';
	@Input() descricao: string = '';
	@Input() valor?: number;
	@Input() quantidade?: number;
	@Input() id?: number;
}
