package com.sweetievegan.domain.product.specification;

import com.sweetievegan.domain.product.entity.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface ProductSpecification {
    public static Specification<ProductEntity> findProductByNameKeyword(String nameKeyword) {
        return new Specification<ProductEntity>() {
            @Override
            public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("productName"), "%" + nameKeyword + "%");
            }
        };
    }
    public static Specification<ProductEntity> findProductByIngredientKeyword(String ingredientKeyword) {
        return new Specification<ProductEntity>() {
            @Override
            public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("productDescription"), "%" + ingredientKeyword + "%");
            }
        };
    }
    public static Specification<ProductEntity> betweenPrice(int price) {
        return new Specification<ProductEntity>() {
            @Override
            public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get("price"), 0, price);
            }
        };
    }
    
}
