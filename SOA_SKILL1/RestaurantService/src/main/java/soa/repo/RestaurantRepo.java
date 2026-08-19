package soa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soa.model.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
	

}
