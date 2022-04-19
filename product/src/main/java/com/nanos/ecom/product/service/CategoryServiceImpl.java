package com.nanos.ecom.product.service;

import com.nanos.ecom.product.entity.categories.Category;
import com.nanos.ecom.product.model.CategoryDto;
import com.nanos.ecom.product.repository.CategoryRepository;
import com.nanos.ecom.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto,category);
        category=categoryRepository.save(category);
        BeanUtils.copyProperties(category,categoryDto);
        return categoryDto;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoriesDto = categories.stream().map(cat -> {
            CategoryDto categorydto = new CategoryDto();
            BeanUtils.copyProperties(cat, categorydto);
            return categorydto;
        }).collect(Collectors.toList());
        return categoriesDto;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        CategoryDto categoryDto = new CategoryDto();
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            BeanUtils.copyProperties(category,categoryDto);
        }else{

        }
        return categoryDto;
    }
}
