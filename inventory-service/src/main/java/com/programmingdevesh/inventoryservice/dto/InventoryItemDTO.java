package com.programmingdevesh.inventoryservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItemDTO {
    @NotBlank(message = "Must provide a name for item")
    private String itemName;

    @Min(value = 1, message = "Must provide minimum quantity 1")
    private Integer quantity;
}
