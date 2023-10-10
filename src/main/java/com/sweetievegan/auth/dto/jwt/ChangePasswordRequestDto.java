package com.sweetievegan.auth.dto.jwt;

import lombok.Data;

@Data
public class ChangePasswordRequestDto {
	private String email;
	private String exPassword;
	private String newPassword;
}
