package com.programmingdevesh.orderservice.service;

import com.programmingdevesh.orderservice.dto.InventoryItemResponseDTO;
import com.programmingdevesh.orderservice.dto.OrderItemDTO;
import com.programmingdevesh.orderservice.dto.NewOrderRequestDTO;
import com.programmingdevesh.orderservice.event.OrderPlacedEvent;
import com.programmingdevesh.orderservice.model.Order;
import com.programmingdevesh.orderservice.model.OrderItem;
import com.programmingdevesh.orderservice.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    @Override
    public void placeOrder(NewOrderRequestDTO request){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderItem> orderdItemsList = request.getOrderItemDTOList().stream()
                .map(this::convertOrderItemDtoToOrderItem).toList();
        order.setOrderItemList(orderdItemsList);

        List<String> skuCodeList = orderdItemsList.stream().map(OrderItem::getSkuCode).toList();

        //Check if product is available using product-service
        InventoryItemResponseDTO[] inventoryItemResponseDTOArray = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inv",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodeList).build())
                        .retrieve()
                                .bodyToMono(InventoryItemResponseDTO[].class)
                                        .block();

        boolean allItemsInStock = Arrays.stream(inventoryItemResponseDTOArray)
                .allMatch(InventoryItemResponseDTO::isInStock);

        if (allItemsInStock){
            orderRepo.save(order);
            kafkaTemplate.send("notificationTopic", new OrderPlacedEvent(order.getOrderNumber()));
        }else {
            throw new IllegalArgumentException("Sorry, Item out of Stock");
        }
    }

    private OrderItem convertOrderItemDtoToOrderItem(OrderItemDTO orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(orderItemDto.getPrice());
        orderItem.setSkuCode(orderItemDto.getSkuCode());
        orderItem.setQuantity(orderItemDto.getQuantity());
        return orderItem;
    }
}
