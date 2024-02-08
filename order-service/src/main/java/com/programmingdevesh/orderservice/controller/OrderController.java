package com.programmingdevesh.orderservice.controller;

import com.programmingdevesh.orderservice.dto.NewOrderRequestDTO;
import com.programmingdevesh.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String testServerOne(){
        return "Order Service is running : Test";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "InventoryCircuitBreaker", fallbackMethod = "fallbackMethod")
    public String placeOrder(@RequestBody NewOrderRequestDTO newOrderRequestDTO){
        orderService.placeOrder(newOrderRequestDTO);
        return "Order placed successfully";
    }

    public String fallbackMethod(NewOrderRequestDTO newOrderRequestDTO, RuntimeException runtimeException){
        return "Oops Something went Wrong(Inside Circuit breaker fallback method). Please try again later.";
    }
}
