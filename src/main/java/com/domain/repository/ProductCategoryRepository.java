package com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryRepository, Long> {
    String findCategoryNameByCategoryId(Long categoryId);
}
