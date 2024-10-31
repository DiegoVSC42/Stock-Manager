import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Produto } from '../pages/estoque/produto';
import { Observable } from 'rxjs';

@Injectable({
	providedIn: 'root',
})
export class ProdutoService {
	private readonly API = 'http://localhost:3000/produtos';
	constructor(private http: HttpClient) {}
	obterProdutos(): Observable<Produto[]> {
		return this.http.get<Produto[]>(this.API);
	}

	salvarProduto(produto: Produto) {
		return this.http.post<Produto>(this.API, produto);
	}
	buscarPorId(id: number): Observable<Produto> {
		const url = `${this.API}/${id}`;
		return this.http.get<Produto>(url);
	}

	excluirProduto(id: number): Observable<Produto> {
		const url = `${this.API}/${id}`;
		return this.http.delete<Produto>(url);
	}
	editarProduto(produto: Produto): Observable<Produto> {
		const url = `${this.API}/${produto.id}`;
		return this.http.put<Produto>(url, produto);
	}

	editarOuSalvarProduto(produto: Produto): Observable<Produto> {
		if (produto.id) {
			return this.editarProduto(produto);
		} else {
			return this.salvarProduto(produto);
		}
	}
}
