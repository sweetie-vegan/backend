package com.sweetievegan.domain.service;

import com.sweetievegan.domain.dto.MemberDto;
import com.sweetievegan.domain.entity.MemberEntity;
import com.sweetievegan.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public List<MemberDto> getAllMembers() {
        return null;
    }

    @Override
    public MemberDto findMemberByLoginId(String loginId) {
        return null;
    }

    @Override
    public Long registerMember(MemberDto memberDto) {
        MemberEntity memberDtoToEntity = MemberEntity.builder()
                .loginId(memberDto.getLoginId())
                .pw(memberDto.getPw())
                .nickname(memberDto.getNickname())
                .authorization(memberDto.isAuthorization())
                .subscribe(memberDto.isSubscribe())
                .avail(memberDto.isAvail())
                .build();
        return memberRepository.save(memberDtoToEntity).getMemberId();
    }

    @Override
    public Long updateMemberDetail(Long memberId, MemberDto memberDto) {
        MemberEntity memberEntityToUpdate = memberRepository.findMemberByMemberId(memberId);
        memberEntityToUpdate.editMemberDetail(memberDto.getPw(), memberDto.getNickname(), memberDto.getProfileImg());
        memberRepository.save(memberEntityToUpdate);
        return memberEntityToUpdate.getMemberId();
    }

    @Override
    public Long removeMember(Long memberId) {
        memberRepository.deleteById(memberId);
        return memberId;
    }
}
