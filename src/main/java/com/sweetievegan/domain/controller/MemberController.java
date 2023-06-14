package com.sweetievegan.domain.controller;

import com.sweetievegan.domain.dto.MemberDto;
import com.sweetievegan.domain.service.MemberService;
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
    public ResponseEntity<?> memberRegister(@RequestBody MemberDto memberDto) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.registerMember(memberDto));
    }
    @PutMapping("/{memberId}")
    public ResponseEntity<?> memberModify(@PathVariable("memberId") Long memberId, @RequestBody MemberDto memberDto) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.updateMemberDetail(memberId, memberDto));
    }
    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> memberDelete(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.removeMember(memberId));
    }
}