package com.programmingdevesh.productservice.service;

import com.programmingdevesh.productservice.dto.ProductResponseDTO;
import com.programmingdevesh.productservice.dto.ProductRequestDTO;

import java.util.List;

public interface ProductService {
    void addProduct(ProductRequestDTO productRequest);
    List<ProductResponseDTO> getAllProducts();
}
