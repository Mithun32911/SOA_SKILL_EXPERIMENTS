package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soa.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
