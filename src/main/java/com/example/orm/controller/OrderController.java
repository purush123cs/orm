package com.example.orm.controller;

import com.example.orm.dto.OrderGetDTO;
import com.example.orm.dto.OrderPostDTO;
import com.example.orm.model.OrderRequest;
import com.example.orm.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
class OrderController {

    private final OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    OrderPostDTO createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("/order/{orderId}")
    OrderGetDTO getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }
}