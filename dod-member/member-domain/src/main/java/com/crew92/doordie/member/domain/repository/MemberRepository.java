package com.crew92.doordie.member.domain.repository;

import com.crew92.doordie.member.domain.repository.entity.MemberEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    List<MemberEntity> findAllByEmail(String email);

}