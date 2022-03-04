package com.example.gym.controller;

import com.example.gym.domain.Order;
import com.example.gym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public List<Order> getList(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order getList(@PathVariable("id") int id){
        return orderService.findById(id);
    }

    @PostMapping



    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") int id){
        orderService.deleteOrder(id);
    }
}
