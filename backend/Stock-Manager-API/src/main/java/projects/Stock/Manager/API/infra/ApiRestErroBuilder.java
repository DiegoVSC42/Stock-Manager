package projects.Stock.Manager.API.infra;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
public class ApiRestErroBuilder {

	private LocalDateTime timestamp;
	private Integer code;
	private String status;
	private List<TratadorDeErros.DadosErroValidacao> error;

	public static ApiRestErroBuilder aApiRestError(){

		ApiRestErroBuilder apiRestErroBuilder = new ApiRestErroBuilder();

		setDefaultData(apiRestErroBuilder);

		return apiRestErroBuilder;
	}

	private static ApiRestErroBuilder setDefaultData(ApiRestErroBuilder apiRestErroBuilder){
		apiRestErroBuilder.code = HttpStatus.NOT_FOUND.value();
		apiRestErroBuilder.error = List.of(new TratadorDeErros.DadosErroValidacao("Nome", "Nome vazio ou inválido"));
		apiRestErroBuilder.timestamp = LocalDateTime.now();
		apiRestErroBuilder.status = HttpStatus.NOT_FOUND.name();

		return apiRestErroBuilder;
	}

	public ApiRestErroBuilder withCode(int code){
		this.code = code;
		return this;
	}

	public ApiRestErroBuilder withStatus(String status){
		this.status = status;
		return this;
	}

	public ApiRestErroBuilder withError(List<TratadorDeErros.DadosErroValidacao> error){
		this.error = error;
		return this;
	}

	public ApiRestErroBuilder withTimeStamp(LocalDateTime timestamp){
		this.timestamp = timestamp;
		return this;
	}

	public ApiRestErro build(){
		return new ApiRestErro(this.timestamp, this.code, this.status, this.error);
	}
}
