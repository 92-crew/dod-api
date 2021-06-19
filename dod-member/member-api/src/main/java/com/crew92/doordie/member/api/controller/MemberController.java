package com.crew92.doordie.member.api.controller;

import com.crew92.doordie.member.api.dto.MemberDto;
import com.crew92.doordie.member.api.exception.ErrorResponse;
import com.crew92.doordie.member.api.exception.LoginFailException;
import com.crew92.doordie.member.api.service.MemberService;
import com.crew92.doordie.member.domain.provider.MemberProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.crew92.doordie.member.api.exception.ErrorResponse.of;
import static java.util.stream.Collectors.toList;

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
    protected ResponseEntity<ErrorResponse> loginFailException(LoginFailException e) {
        final ErrorResponse response = of(HttpStatus.BAD_REQUEST, e.getMessage());
        log.error("LoginFailException caused !! - message: {}", e.getMessage(), e);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
