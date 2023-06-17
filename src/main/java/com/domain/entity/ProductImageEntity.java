package com.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="product_img")
public class ProductImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productImgId;

    private String imgUrl;
    private boolean mainImg;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Builder
    public ProductImageEntity(Long productImgId, String imgUrl, boolean mainImg, ProductEntity product) {
        this.productImgId = productImgId;
        this.imgUrl = imgUrl;
        this.mainImg = mainImg;
        this.product = product;
    }
}
