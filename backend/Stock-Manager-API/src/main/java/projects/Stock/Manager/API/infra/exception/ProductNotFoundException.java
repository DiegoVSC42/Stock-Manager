package projects.Stock.Manager.API.infra.exception;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String message) {
		super(message);
	}
}
