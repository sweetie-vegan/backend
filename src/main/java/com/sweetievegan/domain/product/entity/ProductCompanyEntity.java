package com.sweetievegan.domain.product.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="product_companies")
public class ProductCompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String companyName;

    @Builder
    public ProductCompanyEntity(Long companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }
}
