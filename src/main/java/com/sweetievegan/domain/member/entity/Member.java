package com.sweetievegan.domain.member.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String nickname;
    private boolean subscribe;
    private boolean isDeleted;

    @Column(nullable = true)
    private String profileImage;

    @Builder
    public Member(Long id, String email, String password, String nickname, boolean subscribe, boolean isDeleted, String profileImage) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.subscribe = subscribe;
        this.isDeleted = isDeleted;
        this.profileImage = profileImage;
    }

    public void editMemberDetail(String password, String nickname, String profileImage) {
        this.password = password;
        this.nickname = nickname;
        this.profileImage = profileImage;
    }

    public void removeMember() {
        this.isDeleted = true;
    }
    public void updateSubscribe() {
        this.subscribe = !this.subscribe;
    }

}
