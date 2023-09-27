package com.sweetievegan.domain.product.controller;

import com.sweetievegan.domain.product.dto.ProductCategoryRequest;
import com.sweetievegan.domain.product.dto.ProductRegisterRequest;
import com.sweetievegan.domain.product.service.ProductCategoryService;
import com.sweetievegan.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;

    @GetMapping("")
    public ResponseEntity<?> productList() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }
    @GetMapping("/{productId}")
    public ResponseEntity<?> productDetailByProductId(@PathVariable("productId") Long productId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductByProductId(productId));
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchProductsByParams(@RequestParam(required = false) String keyword,
                                                    @RequestParam(required = false) int price,
                                                    @RequestParam(required = false) boolean sale) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductsBySearchingKeyword(keyword, price, sale));
    }
    @PostMapping("")
    public ResponseEntity<?> productRegister(@RequestBody ProductRegisterRequest productRegisterRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.registerProduct(productRegisterRequest));
    }
    @PutMapping("/{productId}")
    public ResponseEntity<?> productModify(@PathVariable("productId") Long productId, @RequestBody ProductRegisterRequest productRegisterRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductDetail(productId, productRegisterRequest));
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<?> productDelete(@PathVariable("productId") Long productId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.removeProduct(productId));
    }
    @PostMapping("/productCategory")
    public ResponseEntity<?> productCategoryRegister(@RequestBody ProductCategoryRequest productCategoryRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(productCategoryService.registerProductCategory(productCategoryRequest));
    }
}
