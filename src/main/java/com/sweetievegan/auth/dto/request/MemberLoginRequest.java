package com.sweetievegan.auth.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginRequest {
	private String email;
	private String password;

	public UsernamePasswordAuthenticationToken toAuthentication() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}
}
