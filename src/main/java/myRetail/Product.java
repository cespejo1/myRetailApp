package myRetail;


import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class will hold the data for the get request at http://redsky.target.com.
 */

@Document
public class Product {
	

	private int id;
	private String name;
	private ProductPrice productPrice;
	
	
	
	public Product(int id, String name, ProductPrice price) {
		super();
		this.id = id;
		this.name = name;
		this.productPrice = price;
	}
	
	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return this.productPrice.getValue();
	}
	public void setPrice(double price) {
		this.productPrice.setValue(price);
	}
	
	

}
