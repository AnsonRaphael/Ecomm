package com.nanos.ecom.product.config;

import com.nanos.ecom.product.entity.ProductImage;
import com.nanos.ecom.product.entity.ProductImageSize;
import com.nanos.ecom.product.entity.ProductType;
import com.nanos.ecom.product.entity.categories.CategoryType;
import com.nanos.ecom.product.model.CategoryDto;
import com.nanos.ecom.product.model.ProductDto;
import com.nanos.ecom.product.service.CategoryService;
import com.nanos.ecom.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class Dataload implements CommandLineRunner {
    private ProductService productService;
    private CategoryService categoryService;
    @Override
    public void run(String... args) throws Exception {
        CategoryDto categoryDto = CategoryDto.builder()
                .categoryName("Electronics")
                .categoryType(CategoryType.PARENT)
                .build();
        categoryDto=categoryService.addCategory(categoryDto);
        // add product
        ProductImage productImage = ProductImage.builder()
                .imageSize(ProductImageSize.MID)
                .imageURL("https://images.pexels.com/photos/243757/pexels-photo-243757.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
                .build();
        List<ProductImage> productImages= new ArrayList<ProductImage>();
        productImages.add(productImage);
        ProductDto productDto = ProductDto.builder()
                .productType(ProductType.ITEM)
                .longDescription("camera")
                .shortDescription("cam")
                .category(categoryDto)
                .productImages(productImages)
                .build();
        productService.addProduct(productDto);
    }
}
