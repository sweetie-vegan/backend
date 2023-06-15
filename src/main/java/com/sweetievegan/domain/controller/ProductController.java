package com.sweetievegan.domain.controller;

import com.sweetievegan.domain.dto.OnlyProductDto;
import com.sweetievegan.domain.service.ProductService;
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
    public ResponseEntity<?> productDetailByProductId(@PathVariable("productId") int productId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductByProductId(productId));
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProductsByParams(@RequestParam(required = false) String keyword,
                                                    @RequestParam(required = false) int price,
                                                    @RequestParam(required = false) boolean sale) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductsBySearchingKeyword(keyword, price, sale));
    }

    @PostMapping("")
    public ResponseEntity<?> productRegister(OnlyProductDto onlyProductDto) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.registerProduct(onlyProductDto));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> productModify(@PathVariable("productId") int productId, @RequestBody OnlyProductDto onlyProductDto) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductDetail(productId, onlyProductDto));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> productDelete(@PathVariable("productId") int productId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.removeProduct(productId));
    }
}
