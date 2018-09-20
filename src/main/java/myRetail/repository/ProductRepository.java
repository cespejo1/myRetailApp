package myRetail.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import myRetail.ProductPrice;


/**
 * This is the database class. It will extend the mongoDB classes.
 * 
 */
@Repository
public interface ProductRepository extends MongoRepository<ProductPrice, Integer>{
	public ProductPrice findByProductId(int productId);
	

}
