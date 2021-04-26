package com.crew92.doordie.member.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Member {

    private Long memberId;
    private String email;
    private String password;
    private String name;

}
