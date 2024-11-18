package projects.Stock.Manager.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockManagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockManagerApiApplication.class, args);
		System.out.println(
			"\n############################################################################################################################################################################################################################" +
				"\n################################################################################################## APLICAÇÃO INICIALIZADA ##################################################################################################" +
				"\n############################################################################################################################################################################################################################"
		);
	}

}
