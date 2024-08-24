package org.johan.microservices.sqljpaqueryes.service;

import org.johan.microservices.sqljpaqueryes.dto.request.ProductRequest;
import org.johan.microservices.sqljpaqueryes.dto.response.ProductResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductService {
    void createProduct(ProductRequest productRequest);

    void deleteProductById(Long id);

    void updateProduct(Long id, ProductRequest productRequest);

    ProductResponse getProductById(Long id);

    void isStockAvailable(Long id, Integer quantity);


}
