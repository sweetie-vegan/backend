package com.domain.controller;

import com.domain.dto.ProductDto;
import com.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

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
    public ResponseEntity<?> productRegister(ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.registerProduct(productDto));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> productModify(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductDetail(productId, productDto));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> productDelete(@PathVariable("productId") Long productId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.removeProduct(productId));
    }
}
