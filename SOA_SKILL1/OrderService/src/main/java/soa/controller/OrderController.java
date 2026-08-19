package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import soa.models.Order;
import soa.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService OS;

    @PostMapping
    public Object placeOrder(@RequestBody Order order) {
        return OS.placeOrder(order);
    }
}