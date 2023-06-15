package com.sweetievegan.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private String productDescription;
    private int price;
    private int count;
    private boolean sale;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategoryEntity productCategory;

    @Builder
    public ProductEntity(Long productId, String productName, String productDescription, int price, int count, boolean sale, ProductCategoryEntity productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.count = count;
        this.sale = sale;
        this.productCategory = productCategory;
    }
}
