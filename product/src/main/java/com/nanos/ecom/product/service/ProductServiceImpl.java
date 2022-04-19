package com.nanos.ecom.product.service;

import com.nanos.ecom.product.entity.Product;
import com.nanos.ecom.product.entity.ProductImage;
import com.nanos.ecom.product.entity.categories.Category;
import com.nanos.ecom.product.exception.ProductNotFoundException;
import com.nanos.ecom.product.model.CategoryDto;
import com.nanos.ecom.product.model.ProductDto;
import com.nanos.ecom.product.repository.CategoryRepository;
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
    private CategoryRepository categoryRepository;
    @Override
    @Transactional
    public ProductDto addProduct(ProductDto productDto) {
        Product product = new Product();
        List<ProductImage> productImages = productDto.getProductImages();
        productDto.setProductImages(null);
        BeanUtils.copyProperties(productDto,product);
        Optional<Category> categoryOptional = categoryRepository.findById(productDto.getCategory().getCategoryId());
        if(categoryOptional.isPresent())
            product.setCategory(categoryOptional.get());
        product=productRepository.save(product);
        for (int i=0;i<productImages.size();i++){
            productImages.get(i).setProduct(product);
        }
        product.setProductImages(productImages);
        product=productRepository.save(product);
        BeanUtils.copyProperties(product,productDto);
        return productDto;
    }


    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productsDtos = products.stream().map(product -> {
            ProductDto productDto = new ProductDto();
            productDto.setCategory(new CategoryDto());
            BeanUtils.copyProperties(product, productDto);
            productDto.getCategory().setCategoryId(product.getCategory().getCategoryId());
            return productDto;
        }).collect(Collectors.toList());
        return productsDtos;
    }

    @Override
    public ProductDto getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            productDto.setCategory(new CategoryDto());
            BeanUtils.copyProperties(productOptional.get(),productDto);
            productDto.getCategory().setCategoryId(productOptional.get().getCategory().getCategoryId());
            return productDto;
        }else{
            throw new ProductNotFoundException("Product with id "+id+" not found in DB");
        }
    }



}
