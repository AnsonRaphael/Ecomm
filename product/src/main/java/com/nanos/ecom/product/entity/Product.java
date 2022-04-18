package com.nanos.ecom.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nanos.ecom.product.entity.categories.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;
    private ProductType productType;

    @OneToMany(
            targetEntity = ProductImage.class,
            cascade =CascadeType.ALL,
            mappedBy = "product",
            fetch = FetchType.EAGER
    )
    @JsonManagedReference
    private List<ProductImage> productImages;
    private String shortDescription;
    private String longDescription;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonBackReference
    private Category category;
}
