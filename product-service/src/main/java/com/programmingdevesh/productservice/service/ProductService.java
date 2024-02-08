package com.programmingdevesh.productservice.service;

import com.programmingdevesh.productservice.dto.NewProductItemRequestDTO;
import com.programmingdevesh.productservice.dto.CreatedProductResponseDTO;
import com.programmingdevesh.productservice.models.Product;
import com.programmingdevesh.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createANewProduct(NewProductItemRequestDTO productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setBrand(productRequest.getBrand());
        product.setPrice(productRequest.getPrice());

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<CreatedProductResponseDTO> getAllProducts(){
        var productList =  productRepository.findAll();
        return productList.stream().map(this::mapToProductResponse).toList();
    }

    private CreatedProductResponseDTO mapToProductResponse(Product product){
        return new CreatedProductResponseDTO(product.getId(), product.getName(),
                product.getBrand(), product.getPrice());
    }

}
