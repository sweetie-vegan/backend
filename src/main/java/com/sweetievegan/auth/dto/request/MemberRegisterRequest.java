package com.sweetievegan.auth.dto.request;

import com.sweetievegan.auth.domain.entity.Member;
import com.sweetievegan.auth.util.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberRegisterRequest {
	private String email;
	private String password;
	private String nickname;

	public Member toMember(PasswordEncoder passwordEncoder) {
		return Member.builder()
				.email(email)
				.password(passwordEncoder.encode(password))
				.nickname(nickname)
				.authority(Authority.ROLE_USER)
				.isDeleted(false).build();
	}

}
