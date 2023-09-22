package com.sweetievegan.domain.member.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class MemberRegisterRequest {
    private Long id;
    private String email;
    private String password;
    private String nickname;

    @Nullable
    private String profileImg;

    @Builder
    public MemberRegisterRequest(Long id, String email, String password, String nickname, String profileImg) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileImg = profileImg;
    }
}
