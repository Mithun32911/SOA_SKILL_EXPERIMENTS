package soa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import soa.model.Product;
import soa.repository.ProductRepo;

@Service
public class ProductService {
	
	ProductRepo PR;
	public ProductService(ProductRepo PR) {
		this.PR = PR;
	}
	
	public Object getAllProducts() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<Product> products = PR.findAll();
			response.put("products", products);
			
		}catch(Exception e) {
			response.put("code",500);
			response.put("message", e.getMessage());
		}
		return response;
	}
	

}
