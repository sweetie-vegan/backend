package com.sweetievegan.domain.product.repository;

import com.sweetievegan.domain.product.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {
    ProductCategoryEntity findProductCategoryEntityByCategoryId(Long categoryId);
}
