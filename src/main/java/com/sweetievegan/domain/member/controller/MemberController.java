package com.sweetievegan.domain.member.controller;

import com.sweetievegan.domain.member.dto.MemberRequestDto;
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

    @GetMapping("")
    public ResponseEntity<?> memberList() {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getAllMembers());
    }
    @PostMapping("")
    public ResponseEntity<Long> memberRegister(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.registerMember(memberRequestDto));
    }
    @PutMapping("/{memberId}")
    public ResponseEntity<Long> memberModify(@PathVariable("memberId") Long memberId, @RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.updateMemberDetail(memberId, memberRequestDto));
    }
    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> memberDelete(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.removeMember(memberId));
    }
}