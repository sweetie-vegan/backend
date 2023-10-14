package com.sweetievegan.subscribe.service;

import com.sweetievegan.auth.domain.entity.Member;
import com.sweetievegan.auth.domain.repository.MemberRepository;
import com.sweetievegan.subscribe.domain.entity.Subscribe;
import com.sweetievegan.subscribe.domain.repository.SubscribeRepository;
import com.sweetievegan.subscribe.dto.request.SubscribeRegisterRequest;
import com.sweetievegan.subscribe.dto.response.SubscribeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscibeServiceImp implements SubscribeService{
	private final SubscribeRepository subscribeRepository;
	private final MemberRepository memberRepository;

	@Override
	public Long addSubscribe(Long memberId, SubscribeRegisterRequest request) {
		Subscribe subscribe = Subscribe.builder()
				.size(request.getSize())
				.perWeek(request.getPerWeek())
				.price(request.getPrice())
				.preference(request.getPreference())
				.allergy(request.getAllergy())
				.name(request.getName())
				.address(request.getAddress())
				.addressDetail(request.getAddressDetail())
				.tel(request.getTel())
				.build();

		/* member 추가 */
		Member currentMember = memberRepository.findMemberById(memberId);
		subscribe.setMember(currentMember);

		return subscribeRepository.save(subscribe).getId();
	}

	@Override
	public SubscribeResponse findSubscribeByMemberId(Long memberId) {
		return null;
	}

	@Override
	public Long removeSubscribe(Long memberId, Long id) {
		Member subscribeMember = subscribeRepository.findSubscribeById(id).getMember();
		if(memberId != subscribeMember.getId())
			throw new IllegalArgumentException("구독자 정보가 다릅니다.");
		subscribeRepository.deleteById(id);
		return id;
	}
}
