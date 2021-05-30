package com.crew92.doordie.member.api.service;

import static java.util.Objects.isNull;

import com.crew92.doordie.member.api.controller.MemberCreateCondition;
import com.crew92.doordie.member.api.controller.MemberLoginCondition;
import com.crew92.doordie.member.api.dto.MemberDto;
import com.crew92.doordie.member.api.exception.LoginFailException;
import com.crew92.doordie.member.domain.model.Member;
import com.crew92.doordie.member.domain.provider.MemberProvider;
import com.crew92.doordie.member.domain.repository.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberProvider memberProvider;

    public MemberDto join(MemberCreateCondition condition) {
        Member member = new Member();
        member.setEmail(condition.getEmail());
        member.setName(condition.getName());
        member.setPassword(condition.getPassword());

        log.info("MemberService.join - [input] email: {}, name: {}", condition.getEmail(), condition.getName());
        return MemberDto.of(memberProvider.create(member));
    }

    public boolean isNotDuplicated(String email) {
        log.info("MemberService.isNotDuplicated - [input] email: {}", email);
        return isNull(memberProvider.findByEmail(email));
    }

    public MemberDto login(MemberLoginCondition condition) {
        MemberEntity member = memberProvider.findByEmail(condition.getEmail());
        if (isNull(member)) {
            throw new LoginFailException(condition.getEmail() + "은 존재하지 않는 계정정보입니다.");
        }

        if (member.getPassword().equals(condition.getPassword())) {
            log.info("MemberService.login - success!! email: {}, name: {}", member.getEmail(), member.getName());
            return MemberDto.of(member);
        }

        log.error("MemberService.login - login fail!! [input] email: {}, pw: {}, [db] pw: {}", condition.getEmail(), condition.getPassword(), member.getPassword());
        throw new LoginFailException();
    }
}
