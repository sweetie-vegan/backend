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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private ProductCompanyEntity productCompany;

    @Builder
    public ProductEntity(String productName, String productDescription, int price, int count, ProductCategoryEntity productCategory, ProductCompanyEntity productCompany) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.count = count;
        this.productCategory = productCategory;
        this.productCompany = productCompany;
    }

    public void editProductDetail(String productName, String productDescription, int price, int count, ProductCategoryEntity productCategory, ProductCompanyEntity productCompany) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.count = count;
        this.productCategory = productCategory;
        this.productCompany = productCompany;
    }

    public void editSale() {
        this.sale = !this.sale;
    }
}
