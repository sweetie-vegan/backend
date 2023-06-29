package com.sweetievegan.domain.product.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false, length = 50)
    private String productName;

    @Column(nullable = false)
    private String productDescription;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean sellStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private ProductCategoryEntity productCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private ProductCompanyEntity productCompany;

    public void editProductDetail(String productName, String productDescription, int price, int count, ProductCategoryEntity productCategory, ProductCompanyEntity productCompany) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.count = count;
        this.productCategory = productCategory;
        this.productCompany = productCompany;
    }

    public void editSale() {
        this.sellStatus = !this.sellStatus;
    }
}
