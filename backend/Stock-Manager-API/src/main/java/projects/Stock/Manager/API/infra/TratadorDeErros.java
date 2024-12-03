package projects.Stock.Manager.API.infra;

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

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity tratarErro500(){
		ApiRestErro erro = ApiRestErroBuilder.aApiRestError()
			.withError(List.of(new DadosErroValidacao("Server", "Erro Interno")))
			.withCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
			.withStatus(HttpStatus.INTERNAL_SERVER_ERROR.name()).build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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
