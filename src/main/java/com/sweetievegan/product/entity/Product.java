package com.sweetievegan.product.entity;

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
    private double price;
    private int count;
    private boolean isSoldout;

    private String ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private ProductCategory productCategory;

    public void editProductDetail(String name, String description, double price, int count, ProductCategory productCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
        this.productCategory = productCategory;
    }

    public void setSoldOut() {
        this.isSoldout = true;
    }
}
