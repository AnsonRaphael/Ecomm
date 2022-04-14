package com.nanos.ecom.product.repository;

import com.nanos.ecom.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
