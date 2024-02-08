package com.programmingdevesh.productservice.controller;

import com.programmingdevesh.productservice.dto.NewProductItemRequestDTO;
import com.programmingdevesh.productservice.dto.CreatedProductResponseDTO;
import com.programmingdevesh.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>("OK Fine, Server is Working.", HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody NewProductItemRequestDTO productRequest) {
        productService.createANewProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CreatedProductResponseDTO> getListOfAllProducts() {
        return productService.getAllProducts();
    }
}
