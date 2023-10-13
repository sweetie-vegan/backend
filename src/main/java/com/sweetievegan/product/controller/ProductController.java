package com.sweetievegan.product.controller;

import com.sweetievegan.product.dto.request.ProductCategoryRequest;
import com.sweetievegan.product.dto.request.ProductRegisterRequest;
import com.sweetievegan.product.dto.response.ProductResponse;
import com.sweetievegan.product.service.ProductCategoryService;
import com.sweetievegan.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;

    @GetMapping("")
    public ResponseEntity<List<ProductResponse>> productList() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> productDetailByProductId(@PathVariable("productId") Long productId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductByProductId(productId));
    }
    @GetMapping("/search")
    public ResponseEntity<List<ProductRegisterRequest>> searchProductsByParams(@RequestParam(required = false) String keyword,
                                                    @RequestParam(required = false) int price,
                                                    @RequestParam(required = false) boolean sale) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductsBySearchingKeyword(keyword, price, sale));
    }
    @PostMapping("")
    public ResponseEntity<Long> productRegister(@RequestBody ProductRegisterRequest productRegisterRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.registerProduct(productRegisterRequest));
    }
    @PutMapping("/{productId}")
    public ResponseEntity<ProductRegisterRequest> productModify(@PathVariable("productId") Long productId, @RequestBody ProductRegisterRequest productRegisterRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductDetail(productId, productRegisterRequest));
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Long> productDelete(@PathVariable("productId") Long productId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.removeProduct(productId));
    }
    @PostMapping("/productCategory")
    public ResponseEntity<Long> productCategoryRegister(@RequestBody ProductCategoryRequest productCategoryRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(productCategoryService.registerProductCategory(productCategoryRequest));
    }
}
