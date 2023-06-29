package com.sweetievegan.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {
//    private Long memberId;
    private String loginId;
    private String pw;
    private String nickname;
//    private boolean authorization;
//    private boolean subscribe;
//    private boolean avail;
    private String profileImg;
}
