package projects.Stock.Manager.API.infra.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ApiRestErro(
	LocalDateTime timestamp,
	Integer code,
	String status,
	List<TratadorDeErros.DadosErroValidacao> error
) {
}
