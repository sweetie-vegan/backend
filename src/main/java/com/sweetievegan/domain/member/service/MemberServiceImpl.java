package com.sweetievegan.domain.member.service;

import com.sweetievegan.domain.member.dto.MembeRequestrDto;
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
public class MemberServiceImpl implements MemberService {
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
                    .profileImg(memberEntity.getProfileImg())
                    .build();
            memberResponseDtos.add(memberResponseEntityDto);
        }
        return memberResponseDtos;
    }

    @Override
    public Long registerMember(MembeRequestrDto membeRequestrDto) {
        MemberEntity memberDtoToEntity = MemberEntity.builder()
                .loginId(membeRequestrDto.getLoginId())
                .pw(membeRequestrDto.getPw())
                .nickname(membeRequestrDto.getNickname())
//                .authorization(membeRequestrDto.isAuthorization())
//                .subscribe(membeRequestrDto.isSubscribe())
//                .avail(membeRequestrDto.isAvail())
                .build();
        return memberRepository.save(memberDtoToEntity).getMemberId();
    }

    @Override
    public Long updateMemberDetail(Long memberId, MembeRequestrDto membeRequestrDto) {
        MemberEntity memberEntityToUpdate = memberRepository.findMemberByMemberId(memberId);
        memberEntityToUpdate.editMemberDetail(membeRequestrDto.getPw(),
                membeRequestrDto.getNickname(),
                membeRequestrDto.getProfileImg());
        memberRepository.save(memberEntityToUpdate);
        return memberEntityToUpdate.getMemberId();
    }

    @Override
    public Long removeMember(Long memberId) {
        memberRepository.deleteById(memberId);
        return memberId;
    }
}
