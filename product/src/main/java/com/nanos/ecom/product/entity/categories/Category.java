package com.nanos.ecom.product.entity.categories;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nanos.ecom.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long categoryId;
    private String categoryName;
    private CategoryType categoryType;
//    @ManyToMany()
//
//    private List<Category> childCategories;
    @OneToMany(
            targetEntity = Product.class,
            cascade = CascadeType.ALL,
            mappedBy = "category",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Product> products;
}
