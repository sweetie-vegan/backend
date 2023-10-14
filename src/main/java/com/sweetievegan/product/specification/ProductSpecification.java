package com.sweetievegan.product.specification;

import com.sweetievegan.product.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface ProductSpecification {
    public static Specification<Product> findProductByNameKeyword(String nameKeyword) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("productName"), "%" + nameKeyword + "%");
            }
        };
    }
    public static Specification<Product> findProductByIngredientKeyword(String ingredientKeyword) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("productDescription"), "%" + ingredientKeyword + "%");
            }
        };
    }
    public static Specification<Product> betweenPrice(int price) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get("price"), 0, price);
            }
        };
    }
    
}
