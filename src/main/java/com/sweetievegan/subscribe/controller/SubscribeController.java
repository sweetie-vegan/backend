package com.sweetievegan.subscribe.controller;

import com.sweetievegan.auth.dto.response.MemberResponse;
import com.sweetievegan.auth.service.MemberService;
import com.sweetievegan.config.SecurityUtil;
import com.sweetievegan.subscribe.dto.request.SubscribeRegisterRequest;
import com.sweetievegan.subscribe.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sweetievegan.config.SecurityUtil.getCurrentMemberId;

@Slf4j
@RestController
@RequestMapping("/members/subscribes")
@RequiredArgsConstructor
public class SubscribeController {
	private final SubscribeService subscribeService;
	private final MemberService memberService;
	private SecurityUtil securityUtil;

	@PostMapping()
	public ResponseEntity<Long> subscribeRegister(@RequestHeader("Authorization") String accessToken,
	                                              @RequestBody SubscribeRegisterRequest request) {
		/* 사용자 인가 과정 */
		Long memberId = getCurrentMemberId();
		log.info("{}", memberId);
		return ResponseEntity.status(HttpStatus.OK).body(subscribeService.addSubscribe(memberId, request));
	}
	@DeleteMapping("/{subscribeId}")
	public ResponseEntity<Long> subscribeDelete(@RequestHeader("Authorization") String accessToken,
	                                            @PathVariable("subscribeId") Long id) {
		Long memberId = getCurrentMemberId();
		return ResponseEntity.status(HttpStatus.OK).body(subscribeService.removeSubscribe(memberId, id));
	}
}
