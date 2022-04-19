package com.nanos.ecom.product.entity.categories;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nanos.ecom.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(name = "categoryRel",
    joinColumns = {@JoinColumn(name = "categoryId")},
    inverseJoinColumns = {@JoinColumn(name = "childCategoryId")}
    )
    private Set<Category> categories;
    @ManyToMany(mappedBy = "categories")
    private Set<Category> childCategories;
    @OneToMany(
            targetEntity = Product.class,
            cascade = CascadeType.ALL,
            mappedBy = "category",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Product> products;
}
