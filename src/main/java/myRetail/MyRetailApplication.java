package myRetail;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class will begin the Spring Application. It will also 
 * insert 2 records in the database in order to test the program.
 */
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import myRetail.repository.ProductRepository;

@SpringBootApplication
public class MyRetailApplication implements CommandLineRunner{
	
	@Autowired
	private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MyRetailApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of products
		repository.save(new ProductPrice(13860428, 13.49, "USD"));
		repository.save(new ProductPrice(3456, 25.00, "USD"));


	}
}


