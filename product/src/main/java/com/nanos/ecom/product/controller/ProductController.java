package com.nanos.ecom.product.controller;


import com.nanos.ecom.product.model.ProductDto;
import com.nanos.ecom.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
    }

    @GetMapping("/all")
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/byId/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
}
