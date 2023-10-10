package com.sweetievegan.auth.service.jwt;

import com.sweetievegan.auth.domain.entity.Member;
import com.sweetievegan.auth.domain.repository.MemberRepository;
import com.sweetievegan.auth.dto.jwt.MemberLoginDto;
import com.sweetievegan.auth.dto.jwt.MemberRequestDto;
import com.sweetievegan.auth.dto.jwt.MemberResponseDto;
import com.sweetievegan.auth.jwt.TokenDto;
import com.sweetievegan.auth.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
	private final AuthenticationManagerBuilder managerBuilder;
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	private final TokenProvider tokenProvider;

	public MemberResponseDto signup(MemberRequestDto requestDto) {
		if (memberRepository.existsByEmail(requestDto.getEmail())) {
			throw new RuntimeException("이미 가입되어 있는 유저입니다");
		}

		Member member = requestDto.toMember(passwordEncoder);
		return MemberResponseDto.of(memberRepository.save(member));
	}

	public TokenDto login(MemberLoginDto requestDto) {
		UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
		Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
		return tokenProvider.generateTokenDto(authentication);
	}

}