package com.crew92.doordie.member.domain.provider;

import com.crew92.doordie.member.domain.model.Member;
import com.crew92.doordie.member.domain.repository.MemberRepository;
import com.crew92.doordie.member.domain.repository.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberProvider {

    private final MemberRepository memberRepository;

    public List<MemberEntity> findAll() {
        return memberRepository.findAll();
    }

    public MemberEntity findById(long memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    public MemberEntity create(Member member) {
        return memberRepository.save(transfer(member));
    }

    private MemberEntity transfer(Member member) {
        MemberEntity entity = new MemberEntity();
        entity.setEmail(member.getEmail());
        entity.setPassword(member.getPassword());
        entity.setName(member.getName());

        return entity;
    }

}
