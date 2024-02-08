package com.programmingdevesh.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryItemResponseDTO {
    private String skuCode;
    private boolean isInStock;
}
