package com.nanos.ecom.product.service;

import com.nanos.ecom.product.entity.Product;
import com.nanos.ecom.product.exception.ProductNotFoundException;
import com.nanos.ecom.product.model.ProductDto;
import com.nanos.ecom.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Override
    @Transactional
    public void addProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productsDtos = products.stream().map(product -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            return productDto;
        }).collect(Collectors.toList());
        return productsDtos;
    }

    @Override
    public ProductDto getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);
            return productDto;
        }else{
            throw new ProductNotFoundException("Product with id "+id+" not found in DB");
        }
    }
}
