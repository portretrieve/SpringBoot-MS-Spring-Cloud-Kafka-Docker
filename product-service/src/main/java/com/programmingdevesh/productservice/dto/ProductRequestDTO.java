package com.programmingdevesh.productservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    @NotBlank(message = "Must provide a Valid Name.")
    private String name;

    @NotNull(message = "Please provide brand name of the product.")
    private String brand;

    @Min(value = 1, message = "Minimum value can't be less than 1 CAD.")
    private BigDecimal price;
}
