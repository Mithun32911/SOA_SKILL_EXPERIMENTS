package soa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long productId;

     String productName;
     Double price;
     String category;
     int stock;
	 public int getStock() {
		return stock;
	}
	 public void setStock(int stock) {
		 this.stock = stock;
	 }
	 public Long getProductId() {
		 return productId;
	 }
	 public void setProductId(Long productId) {
		 this.productId = productId;
	 }
	 public String getProductName() {
		 return productName;
	 }
	 public void setProductName(String productName) {
		 this.productName = productName;
	 }
	 public Double getPrice() {
		 return price;
	 }
	 public void setPrice(Double price) {
		 this.price = price;
	 }
	 public String getCategory() {
		 return category;
	 }
	 public void setCategory(String category) {
		 this.category = category;
	 }

    
}