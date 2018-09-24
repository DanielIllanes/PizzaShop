package com.pizzashop.pizzashop.Controllers;

import com.pizzashop.pizzashop.Models.Order;
import com.pizzashop.pizzashop.Repositories.OrdersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private OrdersRepository ordersRepository;

    public OrdersController(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    @GetMapping
    public Page<Order> allOrders(Pageable pageable){
        return this.ordersRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    ResponseEntity<Order> byId(@PathVariable(value= "id") Long id){
        if(!this.ordersRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(this.ordersRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Order> newOrder(@RequestBody Order newOrder) {
        return new ResponseEntity<>(this.ordersRepository.save(newOrder), HttpStatus.CREATED);
    }
}
