package com.crew92.doordie.member.api.controller;

import com.crew92.doordie.member.api.dto.MemberDto;
import com.crew92.doordie.member.api.service.MemberService;
import com.crew92.doordie.member.domain.provider.MemberProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberProvider memberProvider;

    @GetMapping("/api/v1/members")
    public List<MemberDto> getAll() {
        return memberProvider.findAll().stream().map(MemberDto::of).collect(toList());
    }

    @PostMapping("/api/v1/member/join")
    public MemberDto join(@RequestBody @Valid MemberCreateCondition condition) {
        return memberService.join(condition);
    }
}
