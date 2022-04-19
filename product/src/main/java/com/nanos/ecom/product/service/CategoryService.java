package com.nanos.ecom.product.service;

import com.nanos.ecom.product.model.CategoryDto;
import com.nanos.ecom.product.model.ProductDto;

import java.util.List;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategory();

    CategoryDto getCategoryById(Long id);
}
