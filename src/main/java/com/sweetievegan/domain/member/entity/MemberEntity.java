package com.sweetievegan.domain.member.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "members")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String loginId;
    private String pw;
    private String nickname;

    @Column(nullable = true)
    private boolean authorization;

    @Column(nullable = true)
    private boolean subscribe;

    @Column(nullable = true)
    private boolean avail;

    @Column(nullable = true)
    private String profileImg;

    public void editMemberDetail(String nickname, String profileImg) {
        this.nickname = nickname;
        this.profileImg = profileImg;
    }
    public void editPw(String pw) {
        this.pw = pw;
    }
    public void updateAuthorization() {
        this.avail = !this.avail;
    }

    public void updateSubscribe() {
        this.subscribe = !this.subscribe;
    }

}
