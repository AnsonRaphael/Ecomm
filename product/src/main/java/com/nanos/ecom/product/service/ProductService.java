package com.nanos.ecom.product.service;

import com.nanos.ecom.product.model.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto);

    List<ProductDto> getAllProduct();

    ProductDto getProductById(Long id);
}
