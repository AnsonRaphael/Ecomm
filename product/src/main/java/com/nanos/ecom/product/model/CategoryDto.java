package com.nanos.ecom.product.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nanos.ecom.product.entity.Product;
import com.nanos.ecom.product.entity.categories.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private Long categoryId;
    private String categoryName;
    private CategoryType categoryType;
    private List<Product> products;
}
