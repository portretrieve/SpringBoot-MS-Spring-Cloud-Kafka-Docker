package com.programmingdevesh.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewProductItemRequestDTO {
    private String name;
    private String brand;
    private BigDecimal price;
}
