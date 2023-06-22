package com.sweetievegan.domain.cart.controller;

import com.sweetievegan.domain.cart.dto.CartRequestDto;
import com.sweetievegan.domain.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/{memberId}")
    public ResponseEntity<?> cartsByMemberId(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.findCartsByMemberId(memberId));
    }
    @PostMapping("")
    public ResponseEntity<?> cartRegister(@RequestBody CartRequestDto cartRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.registerCart(cartRequestDto));
    }
    @DeleteMapping("/{cartId}")
    public ResponseEntity<?> cartDelete(@PathVariable("cartId") Long cartId) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.removeCart(cartId));
    }
}
