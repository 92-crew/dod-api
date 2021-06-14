package com.crew92.doordie.member.api.controller;

import com.crew92.doordie.member.api.validator.ValidPassword;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateCondition implements Serializable {

    @Size(max = 200, message = "이메일은 200자 이내여야 합니다.")
    @NotNull(message = "이메일은 필수입니다.")
    @Email(message = "이메일의 형태가 아닙니다.")
    private String email;

    @Size(min = 8, max = 200, message = "비밀번호는 8자 이상이어야 합니다.")
    @NotNull(message = "비밀번호는 필수입니다.")
    @ValidPassword
    private String password;

    @NotNull(message = "이름은 필수값입니다.")
    private String name;

}
