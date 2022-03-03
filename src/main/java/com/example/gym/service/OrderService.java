package com.example.gym.service;


import com.example.gym.domain.Order;
import com.example.gym.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(int id){
        return orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrder(int id){
        orderRepository.deleteById(id);
    }
}
