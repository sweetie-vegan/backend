package com.sweetievegan.domain.member.controller;

import com.sweetievegan.domain.member.dto.MemberRegisterRequest;
import com.sweetievegan.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public ResponseEntity<Long> memberRegister(@RequestBody MemberRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.registerMember(request));
    }
    @PutMapping("/{memberId}")
    public ResponseEntity<Long> memberModify(@PathVariable("memberId") Long id,
                                          @RequestBody MemberRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.updateMemberDetail(id, request));
    }
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Long> memberDelete(@PathVariable("memberId") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.removeMember(id));
    }
}