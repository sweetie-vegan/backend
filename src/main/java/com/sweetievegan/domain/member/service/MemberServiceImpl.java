package com.sweetievegan.domain.member.service;

import com.sweetievegan.domain.member.dto.MemberRegisterRequest;
import com.sweetievegan.domain.member.entity.Member;
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
    public Long registerMember(MemberRegisterRequest request) {
        Member memberDtoToEntity = Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .isDeleted(false)
                .build();
        return memberRepository.save(memberDtoToEntity).getId();
    }

    @Override
    public Long updateMemberDetail(Long id, MemberRegisterRequest request) {
        Member memberToUpdate = memberRepository.findMemberById(id);
        memberToUpdate.editMemberDetail(request.getPassword(), request.getNickname(), request.getProfileImg());
        return id;
    }

    @Override
    public Long removeMember(Long id) {
        Member member = memberRepository.findMemberById(id);
        member.removeMember();
        return id;
    }
}
