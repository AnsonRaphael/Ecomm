package com.nanos.ecom.product.model;

import com.nanos.ecom.product.entity.ProductImage;
import com.nanos.ecom.product.entity.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductDto {
    private Long productId;
    private ProductType productType;

    private List<ProductImage> productImages;
    private String shortDescription;
    private String longDescription;
}
