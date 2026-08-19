package soa.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="orders")
public class Order {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long orderId;
	Long userId;
	Long restaurantId;
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL)
	List<Orderitems> items;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public List<Orderitems> getItems() {
		return items;
	}
	public void setItems(List<Orderitems> items) {
		this.items = items;
	}
}