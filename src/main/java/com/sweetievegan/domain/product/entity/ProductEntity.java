package com.sweetievegan.domain.product.entity;

import lombok.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private ProductCategoryEntity productCategory;

    @Builder
    public ProductEntity(Long productId, String productName, String productDescription, int price, int count, boolean sale, ProductCategoryEntity productCategory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.count = count;
        this.sale = sale;
        this.productCategory = productCategory;
    }

    public void editProductDetail(String productName, String productDescription, int price, int count, ProductCategoryEntity productCategory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.count = count;
        this.productCategory = productCategory;
    }

    public void editSale() {
        this.sale = !this.sale;
    }
}
