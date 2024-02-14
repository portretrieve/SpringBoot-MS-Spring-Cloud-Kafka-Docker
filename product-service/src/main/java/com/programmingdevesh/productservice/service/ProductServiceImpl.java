package com.programmingdevesh.productservice.service;

import com.programmingdevesh.productservice.dto.ProductRequestDTO;
import com.programmingdevesh.productservice.dto.ProductResponseDTO;
import com.programmingdevesh.productservice.models.Product;
import com.programmingdevesh.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(ProductRequestDTO productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setBrand(productRequest.getBrand());
        product.setPrice(productRequest.getPrice());

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    @Override
    public List<ProductResponseDTO> getAllProducts(){
        var productList =  productRepository.findAll();
        return productList.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponseDTO mapToProductResponse(Product product){
        return new ProductResponseDTO(product.getId(), product.getName(),
                product.getBrand(), product.getPrice());
    }
}
