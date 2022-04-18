package com.nanos.ecom.product.repository;

import com.nanos.ecom.product.entity.categories.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
