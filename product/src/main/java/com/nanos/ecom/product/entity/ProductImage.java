package com.nanos.ecom.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productImageId;
    private ProductImageSize imageSize;
    private String imageURL;
    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    @JsonBackReference
    private Product product;
}
