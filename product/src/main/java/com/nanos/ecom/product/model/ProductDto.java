package com.nanos.ecom.product.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nanos.ecom.product.entity.ProductImage;
import com.nanos.ecom.product.entity.ProductType;
import com.nanos.ecom.product.entity.categories.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private Long productId;
    private ProductType productType;

    private List<ProductImage> productImages;
    private String shortDescription;
    private String longDescription;
    private CategoryDto category;
}
