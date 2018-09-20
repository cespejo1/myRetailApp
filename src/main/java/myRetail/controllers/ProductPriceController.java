package myRetail.controllers;



import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import myRetail.Product;
import myRetail.ProductPrice;
import myRetail.repository.ProductRepository;

/**
 * This class will take a get request and put request.
 *
 * @author carlosespejo
 *
 */

@RestController
public class ProductPriceController {
	
	@Autowired
	private ProductRepository repository;
	
	/**
	 * This GET request will read in the id from the url,
	 * do a get request from an api at redsky.com, 
	 * it will read from the product price from the mongodb
	 * and then combine both results and return the information.
	 */
	@RequestMapping(method=RequestMethod.GET, value="/products/{id}")
	public Product getProduct(@PathVariable int id) {
		
		Product product;
		ObjectMapper objectMapper = new ObjectMapper();
		
		//the url from Redsky.com
		final String uri = "https://redsky.target.com/v2/pdp/tcin/" + id + 
				"?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews," + 
				"rating_and_review_statistics,question_answer_statistics";
		
		//get price for specific product from mongodb
		ProductPrice price = repository.findByProductId(id);
		
		//Get request from redsky.target.com
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
		
		//read JSON data from get request
		JsonNode rootNode;
		try {
			rootNode = objectMapper.readTree(response.getBody());
			JsonNode productId =rootNode.findValue("tcin");
			JsonNode productName =rootNode.findValue("title");
			
			//set new product
			product = new Product(productId.asInt(), productName.asText(), price);
		
			return product;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
	
	}
	
	/**
	 * This Put request receives JSON data in the following format:
	 * {"value": 102.30,"currency_code":"USD"}
	 * and it will update the price in the MongdoDB 
	 * @param productInfo
	 * @param id
	 * @throws IOException
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
	public void updatePrice(@RequestBody ProductPrice productInfo, @PathVariable int id) throws IOException {
		
		//Find info from DB
		ProductPrice price = repository.findByProductId(id);
		
		//change values of the price object
		price.setValue(productInfo.getValue());
		price.setCurrencyCode(productInfo.getCurrencyCode());
		
		//save into database
		repository.save(price);
		

	}
	

}
