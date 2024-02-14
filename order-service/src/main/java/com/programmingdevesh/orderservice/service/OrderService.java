package com.programmingdevesh.orderservice.service;

import com.programmingdevesh.orderservice.dto.NewOrderRequestDTO;

public interface OrderService {
    void placeOrder(NewOrderRequestDTO request);
}
