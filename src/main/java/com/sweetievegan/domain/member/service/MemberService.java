package com.sweetievegan.domain.member.service;

import com.sweetievegan.domain.member.dto.MembeRequestrDto;
import com.sweetievegan.domain.member.dto.MemberResponseDto;

import java.util.List;

public interface MemberService {
    List<MemberResponseDto> getAllMembers();
    Long registerMember(MembeRequestrDto memberDto);
    Long updateMemberDetail(Long memberId, MembeRequestrDto membeRequestrDto);
    Long removeMember(Long memberId);
}
