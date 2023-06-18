package com.sweetievegan.domain.service;

import com.sweetievegan.domain.dto.MemberDto;

import java.util.List;

public interface MemberService {
    List<MemberDto> getAllMembers();
    MemberDto findMemberByLoginId(String loginId);
    Long registerMember(MemberDto memberDto);
    MemberDto updateMemberDetail(Long memberId, MemberDto memberDto);
    int removeMember(Long memberId);
}
