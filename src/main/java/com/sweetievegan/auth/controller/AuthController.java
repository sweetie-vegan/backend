package com.sweetievegan.auth.controller;

import com.sweetievegan.auth.dto.jwt.MemberLoginDto;
import com.sweetievegan.auth.dto.jwt.MemberRequestDto;
import com.sweetievegan.auth.dto.jwt.MemberResponseDto;
import com.sweetievegan.auth.jwt.TokenDto;
import com.sweetievegan.auth.service.jwt.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto requestDto) {
		return ResponseEntity.ok(authService.signup(requestDto));
	}

	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody MemberLoginDto requestDto) {
		return ResponseEntity.ok(authService.login(requestDto));
	}
}
