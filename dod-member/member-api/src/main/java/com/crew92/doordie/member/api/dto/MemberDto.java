package com.crew92.doordie.member.api.dto;

import com.crew92.doordie.member.domain.repository.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private String email;
    private String name;

    public static MemberDto of(MemberEntity entity) {
        MemberDto dto = new MemberDto();
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());

        return dto;
    }
}
