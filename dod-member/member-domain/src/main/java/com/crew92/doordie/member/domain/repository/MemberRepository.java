package com.crew92.doordie.member.domain.repository;

import com.crew92.doordie.member.domain.repository.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
