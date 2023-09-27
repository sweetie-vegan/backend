package com.sweetievegan.domain.product.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int price;
    private int count;
    private boolean isSoldout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private ProductCategory productCategory;

    public void editProductDetail(String name, String description, int price, int count, ProductCategory productCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
        this.productCategory = productCategory;
    }

    public void SoldOutProduct() {
        this.isSoldout = true;
    }
}
