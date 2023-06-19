package com.sweetievegan.domain.member.service;

import com.sweetievegan.domain.member.dto.MemberDto;
import com.sweetievegan.domain.member.entity.MemberEntity;
import com.sweetievegan.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

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
