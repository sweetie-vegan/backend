package com.sweetievegan.domain.product.repository;

import com.sweetievegan.domain.product.entity.ProductCompanyEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCompanyRepository extends JpaRepository<ProductCompanyEntity, Long> {
    ProductCompanyEntity findCompanyByCompanyName(String companyName);
}
