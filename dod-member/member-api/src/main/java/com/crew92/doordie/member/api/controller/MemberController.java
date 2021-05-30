package com.crew92.doordie.member.api.controller;

import static java.util.stream.Collectors.toList;

import com.crew92.doordie.member.api.dto.MemberDto;
import com.crew92.doordie.member.api.exception.LoginFailException;
import com.crew92.doordie.member.api.service.MemberService;
import com.crew92.doordie.member.domain.provider.MemberProvider;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberProvider memberProvider;

    @GetMapping("/api/v1/members")
    public List<MemberDto> getAll() {
        return memberProvider.findAll().stream().map(MemberDto::of).collect(toList());
    }

    @GetMapping("/api/v1/member/check/duplicate")
    public boolean checkDuplicate(@RequestParam String email) {
        return memberService.isNotDuplicated(email);
    }

    @PostMapping("/api/v1/member/join")
    public MemberDto join(@RequestBody @Valid MemberCreateCondition condition) {
        return memberService.join(condition);
    }

    @PostMapping("/api/v1/member/login")
    public MemberDto login(@RequestBody @Valid MemberLoginCondition condition) {
        return memberService.login(condition);
    }

    @ExceptionHandler(LoginFailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String loginFailException(LoginFailException e) {
        log.error("LoginFailException caused !! - message; {}", e.getMessage());
        return e.getMessage();
    }
}
