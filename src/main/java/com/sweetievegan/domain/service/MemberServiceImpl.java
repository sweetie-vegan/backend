package com.sweetievegan.domain.service;

import com.sweetievegan.domain.dto.MemberDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public List<MemberDto> getAllMembers() {
        return null;
    }

    @Override
    public MemberDto findMemberByLoginId(String loginId) {
        return null;
    }

    @Override
    public int registerMember(MemberDto memberDto) {
        return 0;
    }

    @Override
    public MemberDto updateMemberDetail(Long memberId, MemberDto memberDto) {
        return null;
    }

    @Override
    public int removeMember(Long memberId) {
        return 0;
    }
}
