package com.sweetievegan.domain.product.repository;

import com.sweetievegan.domain.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    ProductCategory findProductCategoryByCategoryId(Long categoryId);
}
