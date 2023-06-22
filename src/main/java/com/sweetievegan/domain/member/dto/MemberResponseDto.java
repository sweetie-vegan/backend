package com.sweetievegan.domain.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberResponseDto {
    private Long memberId;
    private String loginId;
    private String nickname;
    private boolean authorization;
    private boolean subscribe;
    private String profileImg;

    @Builder
    public MemberResponseDto(Long memberId, String loginId, String nickname, boolean authorization, boolean subscribe, String profileImg) {
        this.memberId = memberId;
        this.loginId = loginId;
        this.nickname = nickname;
        this.authorization = authorization;
        this.subscribe = subscribe;
        this.profileImg = profileImg;
    }
}
