package com.crew92.doordie.member.api.controller;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginCondition implements Serializable {

    @NotNull(message = "이메일은 필수입니다.")
    @Email(message = "이메일의 형태가 아닙니다.")
    private String email;

    @NotNull(message = "비밀번호는 필수입니다.")
    private String password;

}
