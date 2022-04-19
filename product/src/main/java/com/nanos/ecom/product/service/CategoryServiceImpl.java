package com.nanos.ecom.product.service;

import com.nanos.ecom.product.model.CategoryDto;
import com.nanos.ecom.product.repository.CategoryRepository;
import com.nanos.ecom.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    @Override
    public void addCategory(CategoryDto categoryDto) {

    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return null;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return null;
    }
}
