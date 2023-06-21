package com.sweetievegan.domain.member.service;

import com.sweetievegan.domain.member.dto.MemberDto;

public interface MemberService {
    Long registerMember(MemberDto memberDto);
    Long updateMemberDetail(Long memberId, MemberDto memberDto);
    Long removeMember(Long memberId);
}
