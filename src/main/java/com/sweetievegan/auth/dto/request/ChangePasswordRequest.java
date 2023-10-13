package com.sweetievegan.auth.dto.request;

import lombok.Data;

@Data
public class ChangePasswordRequest {
	private String email;
	private String exPassword;
	private String newPassword;
}
