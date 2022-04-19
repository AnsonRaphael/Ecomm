package com.nanos.ecom.product.controller;

import com.nanos.ecom.product.model.CategoryDto;
import com.nanos.ecom.product.model.ProductDto;
import com.nanos.ecom.product.service.CategoryService;
import com.nanos.ecom.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping
    public void addCategory(@RequestBody CategoryDto categoryDto){
        categoryService.addCategory(categoryDto);
    }

    @GetMapping("/all")
    public List<CategoryDto> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/byId/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
}
