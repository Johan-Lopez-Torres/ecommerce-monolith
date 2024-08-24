package org.johan.microservices.sqljpaqueryes.service.impl;

import org.johan.microservices.sqljpaqueryes.dto.request.ProductRequest;
import org.johan.microservices.sqljpaqueryes.dto.response.ProductResponse;
import org.johan.microservices.sqljpaqueryes.repository.ProductRepository;
import org.johan.microservices.sqljpaqueryes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void createProduct(ProductRequest productRequest) {


    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public void updateProduct(Long id, ProductRequest productRequest) {

    }

    @Override
    public ProductResponse getProductById(Long id) {
        return null;
    }

    @Override
    public void isStockAvailable(Long id, Integer quantity) {

    }
}
