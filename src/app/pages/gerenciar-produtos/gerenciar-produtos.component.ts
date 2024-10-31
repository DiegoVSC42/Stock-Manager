import { ProdutoService } from '../../services/produto.service';
import { Component } from '@angular/core';
import { ContainerComponent } from '../../shared/container/container.component';
import {
	FormControl,
	FormGroup,
	ReactiveFormsModule,
	Validators,
} from '@angular/forms';
import { MensagemErroComponent } from '../../shared/mensagem-erro/mensagem-erro.component';
import { CommonModule } from '@angular/common';
import { InfoProdutoComponent } from '../info-produto/info-produto.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
	selector: 'app-gerenciar-produtos',
	standalone: true,
	imports: [
		ContainerComponent,
		ReactiveFormsModule,
		MensagemErroComponent,
		CommonModule,
		InfoProdutoComponent,
	],
	templateUrl: './gerenciar-produtos.component.html',
	styleUrl: './gerenciar-produtos.component.scss',
})
export class GerenciarProdutosComponent {
	produtoForm!: FormGroup;

	constructor(
		private produtoService: ProdutoService,
		private activatedRoute: ActivatedRoute,
		private router: Router
	) {}

	ngOnInit() {
		this.inicializarFormuilario();
		this.carregarProduto();
	}
	inicializarFormuilario() {
		this.produtoForm = new FormGroup({
			nome: new FormControl('', [Validators.required]),
			marca: new FormControl('', [Validators.required]),
			categoria: new FormControl('', [Validators.required]),
			valor: new FormControl('', Validators.required),
			quantidade: new FormControl('', Validators.required),
			descricao: new FormControl('', [Validators.required]),
			imagem: new FormControl('', [Validators.required]),
		});
	}

	obterControle(nome: string): FormControl {
		const control = this.produtoForm.get(nome);
		if (!control) {
			throw new Error('Controle de formulário não encontrado' + nome);
		}
		return control as FormControl;
	}

	carregarProduto() {
		const id = this.activatedRoute.snapshot.paramMap.get('id');
		if (id) {
			this.produtoService
				.buscarPorId(parseInt(id))
				.subscribe((produto) => {
					this.produtoForm.patchValue(produto);
				});
		}
	}

	salvarProduto() {
		const novoProduto = this.produtoForm.value;
		const id = this.activatedRoute.snapshot.paramMap.get('id');
		novoProduto.id = id ? parseInt(id) : null;

		this.produtoService.editarOuSalvarProduto(novoProduto).subscribe(() => {
			this.produtoForm.reset();
			this.router.navigateByUrl('/estoque');
		});
	}
	cancelar() {
		this.produtoForm.reset();
		this.router.navigateByUrl('/estoque');
	}
}
