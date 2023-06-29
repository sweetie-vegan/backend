package com.sweetievegan.domain.member.service;

import com.sweetievegan.domain.member.dto.MemberRequestDto;
import com.sweetievegan.domain.member.dto.MemberResponseDto;

import java.util.List;

public interface MemberService {
    List<MemberResponseDto> getAllMembers();
    Long registerMember(MemberRequestDto memberDto);
    Long updateMemberDetail(Long memberId, MemberRequestDto memberRequestDto);
    Long removeMember(Long memberId);
}
