package com.sweetievegan.domain.member.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String loginId;
    private String pw;
    private String nickname;
    private boolean authorization;
    private boolean subscribe;
    private boolean avail;

    @Column(nullable = true)
    private String profileImg;

    @Builder
    public MemberEntity(Long memberId, String loginId, String pw, String nickname, boolean authorization, boolean subscribe, boolean avail, String profileImg) {
        this.memberId = memberId;
        this.loginId = loginId;
        this.pw = pw;
        this.nickname = nickname;
        this.authorization = authorization;
        this.subscribe = subscribe;
        this.avail = avail;
        this.profileImg = profileImg;
    }

    public void editMemberDetail(String pw, String nickname, String profileImg) {
        this.pw = pw;
        this.nickname = nickname;
        this.profileImg = profileImg;
    }

    public void updateAuthorization() {
        this.avail = !this.avail;
    }

    public void updateSubscribe() {
        this.subscribe = !this.subscribe;
    }

}
