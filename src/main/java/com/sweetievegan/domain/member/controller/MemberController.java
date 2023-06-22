package com.sweetievegan.domain.member.controller;

import com.sweetievegan.domain.member.dto.MembeRequestrDto;
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
    public ResponseEntity<?> memberRegister(@RequestBody MembeRequestrDto membeRequestrDto) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.registerMember(membeRequestrDto));
    }
    @PutMapping("/{memberId}")
    public ResponseEntity<?> memberModify(@PathVariable("memberId") Long memberId, @RequestBody MembeRequestrDto membeRequestrDto) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.updateMemberDetail(memberId, membeRequestrDto));
    }
    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> memberDelete(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.removeMember(memberId));
    }
}