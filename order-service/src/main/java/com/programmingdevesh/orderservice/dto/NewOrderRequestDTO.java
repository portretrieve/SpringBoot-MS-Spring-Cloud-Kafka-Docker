package com.programmingdevesh.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrderRequestDTO {
    private List<OrderItemDTO> orderItemDTOList;
}
