package com.example.gym.controller;

import com.example.gym.domain.Order;
import com.example.gym.dto.OrderUpsertDTO;
import com.example.gym.mapper.OrderMapper;
import com.example.gym.service.GymService;
import com.example.gym.service.MemberService;
import com.example.gym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    GymService gymService;

    @Autowired
    MemberService memberService;

    @GetMapping
    public List<Order> getList(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order getList(@PathVariable("id") int id){
        return orderService.findById(id);
    }

    @PostMapping
    public Order insertOrder(@Valid @RequestBody OrderUpsertDTO req){
        Order order = OrderMapper.INSTANCE.orderInsertRequestToOrder(req);
        order.setStatus(req.getStatus());

        return orderService.saveOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") int id, @Valid @RequestBody OrderUpsertDTO req){
        Order order = orderService.findById(id);
        OrderMapper.INSTANCE.orderUpdateRequestToOrder(req);

        order.setStatus(req.getStatus());

        order.setGym(gymService.findById(req.getGymId()));
        order.setMember(memberService.findById(req.getMemberId()));

        return orderService.saveOrder(order);
    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") int id){
        orderService.deleteOrder(id);
    }
}
