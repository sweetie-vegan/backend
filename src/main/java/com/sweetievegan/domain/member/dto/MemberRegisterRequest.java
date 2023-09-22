package com.sweetievegan.domain.member.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class MemberRegisterRequest {
    private String email;
    private String password;
    private String nickname;

    @Nullable
    private String profileImg;

    @Builder
    public MemberRegisterRequest(String email, String password, String nickname, String profileImg) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileImg = profileImg;
    }
}
