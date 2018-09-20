package myRetail;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

/**
 * The ProductPrice is designed to work with the MongoDB. 
 * It will be used when the put request updates product pricing.
 * @author carlosespejo
 *
 */

public class ProductPrice {
	
	@Id
	private BigInteger id;
	
	private int productId;
	private double value;
	private String currency_code;
	
	public ProductPrice(int productId, double value, String currency_code) {
		super();
		this.productId = productId;
		this.value = value;
		this.currency_code = currency_code;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCurrencyCode() {
		return currency_code;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currency_code = currencyCode;
	}
	
	
	
	
	

}
