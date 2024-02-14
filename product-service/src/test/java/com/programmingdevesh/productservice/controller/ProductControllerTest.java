package com.programmingdevesh.productservice.controller;

import com.programmingdevesh.productservice.dto.ProductResponseDTO;
import com.programmingdevesh.productservice.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getListOfAllProducts() {
        List<ProductResponseDTO> productResponseDTOList = List.of(new ProductResponseDTO("100","Phone", "Samsung", BigDecimal.valueOf(500)));
        Mockito.when(productService.getAllProducts()).thenReturn(productResponseDTOList);
        var list = productController.getListOfAllProducts();
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("Samsung", list.get(0).getBrand());
        Mockito.verify(productService, Mockito.times(1)).getAllProducts();
    }



}