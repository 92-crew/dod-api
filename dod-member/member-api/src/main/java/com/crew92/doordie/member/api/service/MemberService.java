package com.crew92.doordie.member.api.service;

import static java.util.Objects.isNull;

import com.crew92.doordie.member.api.controller.MemberCreateCondition;
import com.crew92.doordie.member.api.dto.MemberDto;
import com.crew92.doordie.member.domain.model.Member;
import com.crew92.doordie.member.domain.provider.MemberProvider;
import com.crew92.doordie.member.domain.repository.entity.MemberEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberProvider memberProvider;

    public MemberDto join(MemberCreateCondition condition) {
        Member member = new Member();
        member.setEmail(condition.getEmail());
        member.setName(condition.getName());
        member.setPassword(condition.getPassword());

        return MemberDto.of(memberProvider.create(member));
    }

    public boolean isNotDuplicated(String email) {
        List<MemberEntity> members = memberProvider.findByEmail(email);

        return isNull(members) || members.isEmpty();
    }
}
