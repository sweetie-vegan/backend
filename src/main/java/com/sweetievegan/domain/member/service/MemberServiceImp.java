package com.sweetievegan.domain.member.service;

import com.sweetievegan.domain.member.dto.MemberRequestDto;
import com.sweetievegan.domain.member.dto.MemberResponseDto;
import com.sweetievegan.domain.member.entity.MemberEntity;
import com.sweetievegan.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImp implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public List<MemberResponseDto> getAllMembers() {
        List<MemberEntity> memberEntities = memberRepository.findAll();
        List<MemberResponseDto> memberResponseDtos = new ArrayList<>();
        for(MemberEntity memberEntity : memberEntities) {
            MemberResponseDto memberResponseEntityDto = MemberResponseDto.builder()
                    .memberId(memberEntity.getMemberId())
                    .loginId(memberEntity.getLoginId())
                    .nickname(memberEntity.getNickname())
                    .authorization(memberEntity.isAuthorization())
                    .subscribe(memberEntity.isSubscribe())
                    .avail(memberEntity.isAvail())
                    .profileImg(memberEntity.getProfileImg())
                    .build();
            memberResponseDtos.add(memberResponseEntityDto);
        }
        return memberResponseDtos;
    }

    @Override
    public Long registerMember(MemberRequestDto memberRequestDto) {
        MemberEntity memberDtoToEntity = MemberEntity.builder()
                .loginId(memberRequestDto.getLoginId())
                .pw(memberRequestDto.getPw())
                .nickname(memberRequestDto.getNickname())
                .authorization(false)
                .subscribe(false)
                .avail(true)
                .build();
        return memberRepository.save(memberDtoToEntity).getMemberId();
    }

    @Override
    public Long updateMemberDetail(Long memberId, MemberRequestDto memberRequestDto) {
        MemberEntity memberEntityToUpdate = memberRepository.findMemberByMemberId(memberId);
        memberEntityToUpdate.editMemberDetail(
                memberRequestDto.getNickname(),
                memberRequestDto.getProfileImg());
        memberRepository.save(memberEntityToUpdate);
        return memberEntityToUpdate.getMemberId();
    }

    @Override
    public Long removeMember(Long memberId) {
        memberRepository.deleteById(memberId);
        return memberId;
    }
}
