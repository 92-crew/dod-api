package com.crew92.doordie.member.api.service;

import com.crew92.doordie.member.api.controller.MemberCreateCondition;
import com.crew92.doordie.member.api.dto.MemberDto;
import com.crew92.doordie.member.domain.provider.MemberProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberProvider memberProvider;

    public MemberDto join(MemberCreateCondition condition) {
        return null;
    }

}
