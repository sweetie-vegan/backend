package com.sweetievegan.domain.product.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name="products")
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private String productDescription;
    private int price;
    private int count;
    private boolean sale;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "categoryId")
//    private ProductCategoryEntity productCategory;

    public void editProductDetail(String productName, String productDescription, int price, int count, boolean sale) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.count = count;
        this.sale = sale;
    }

    public void editSale() {
        this.sale = !this.sale;
    }
}
