package projects.Stock.Manager.API.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

	// Esse erro acontece quando o usuário da API tenta requisitar um id que nao existe no banco,
	// portanto deveria retornar "Not Found"
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ApiRestErro> ProductNotFoundExceptionHandler(ProductNotFoundException exception) {
		List<TratadorDeErros.DadosErroValidacao> erros = List.of(
			new TratadorDeErros.DadosErroValidacao("id", exception.getMessage())
		);
		ApiRestErro apiRestErro = ApiRestErroBuilder.aApiRestError()
			.withCode(HttpStatus.NOT_FOUND.value())
			.withStatus(HttpStatus.NOT_FOUND.name())
			.withError(erros)
			.build();
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiRestErro);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
		var erros = ex.getFieldErrors().stream().map(DadosErroValidacao::new).toList();
		ApiRestErro apiRestErro = ApiRestErroBuilder.aApiRestError()
			.withCode(HttpStatus.BAD_REQUEST.value())
			.withStatus(HttpStatus.BAD_REQUEST.name())
			.withError(erros)
			.build();
		return ResponseEntity.badRequest().body(apiRestErro);
	}

	protected record DadosErroValidacao(String campo,String mensagem){
		public DadosErroValidacao(FieldError erro){
			this(erro.getField(),erro.getDefaultMessage());
		}
	}
}
