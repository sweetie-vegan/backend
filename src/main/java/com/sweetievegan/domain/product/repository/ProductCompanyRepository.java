package com.sweetievegan.domain.product.repository;

import com.sweetievegan.domain.product.entity.ProductCompanyEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCompanyRepository extends JpaRepository<ProductEntity, Long> {
    ProductCompanyEntity findCompanyByCompanyName(String companyName);
}
