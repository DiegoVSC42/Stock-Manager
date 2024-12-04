package projects.Stock.Manager.API.infra.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Stock-Manager API")
                        .description("API de um sistema de gerenciamento de produtos (CRUD) que permite adicionar, visualizar, editar e excluir produtos de um estoque.")
                        .contact(new Contact()
                                .name("Diego Vieira")
                                .email("2001.vieira.diego@gmail.com")
						));
    }

}
