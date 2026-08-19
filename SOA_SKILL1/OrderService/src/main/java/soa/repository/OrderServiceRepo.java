package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soa.models.Order;

@Repository
public interface OrderServiceRepo extends JpaRepository<Order, Long>{

}
