package com.programmingdevesh.productservice.controller;

import com.programmingdevesh.productservice.dto.ProductRequestDTO;
import com.programmingdevesh.productservice.dto.ProductResponseDTO;
import com.programmingdevesh.productservice.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody @Valid ProductRequestDTO productRequest) {
        productServiceImpl.addProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDTO> getListOfAllProducts() {
        return productServiceImpl.getAllProducts();
    }
}
