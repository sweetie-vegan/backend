package com.sweetievegan.domain.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberDto {
    private Long memberId;
    private String loginId;
    private String pw;
    private String nickname;
    private boolean authorization;
    private boolean subscribe;
    private boolean avail;
    private String profileImg;

    @Builder
    public MemberDto(Long memberId, String loginId, String pw, String nickname, boolean authorization, boolean subscribe, boolean avail, String profileImg) {
        this.memberId = memberId;
        this.loginId = loginId;
        this.pw = pw;
        this.nickname = nickname;
        this.authorization = authorization;
        this.subscribe = subscribe;
        this.avail = avail;
        this.profileImg = profileImg;
    }
}
