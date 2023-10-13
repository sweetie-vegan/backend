package com.sweetievegan.auth.controller;

import com.sweetievegan.auth.dto.request.MemberLoginRequest;
import com.sweetievegan.auth.dto.request.MemberRegisterRequest;
import com.sweetievegan.auth.dto.response.MemberResponse;
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
	public ResponseEntity<MemberResponse> signup(@RequestBody MemberRegisterRequest requestDto) {
		return ResponseEntity.ok(authService.signup(requestDto));
	}

	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody MemberLoginRequest requestDto) {
		return ResponseEntity.ok(authService.login(requestDto));
	}
}
