package com.sweetievegan.domain.member.service;

import com.sweetievegan.domain.member.dto.MemberRegisterRequest;

public interface MemberService {
    Long registerMember(MemberRegisterRequest request);
    Long updateMemberDetail(Long id, MemberRegisterRequest request);
    Long removeMember(Long id);
}
