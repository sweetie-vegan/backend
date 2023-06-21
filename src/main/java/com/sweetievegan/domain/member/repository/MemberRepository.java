package com.sweetievegan.domain.member.repository;

import com.sweetievegan.domain.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findMemberByMemberId(Long memberId);
}
