package com.sweetievegan.subscribe.service;

import com.sweetievegan.subscribe.dto.request.SubscribeRegisterRequest;
import com.sweetievegan.subscribe.dto.response.SubscribeResponse;

public interface SubscribeService {
	Long addSubscribe(Long memberId, SubscribeRegisterRequest request);
	SubscribeResponse findSubscribeByMemberId(Long memberId);
	Long removeSubscribe(Long memberId, Long id);
}
