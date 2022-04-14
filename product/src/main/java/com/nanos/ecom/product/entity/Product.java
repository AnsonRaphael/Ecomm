package com.nanos.ecom.product.entity;

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
            cascade =CascadeType.ALL
    )
    private List<ProductImage> productImages;
    private String shortDescription;
    private String longDescription;

}
