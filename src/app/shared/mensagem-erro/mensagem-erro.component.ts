import { Component, Input } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
	selector: 'app-mensagem-erro',
	standalone: true,
	imports: [],
	templateUrl: './mensagem-erro.component.html',
	styleUrl: './mensagem-erro.component.scss',
})
export class MensagemErroComponent {
	@Input() control!: FormControl;
}
