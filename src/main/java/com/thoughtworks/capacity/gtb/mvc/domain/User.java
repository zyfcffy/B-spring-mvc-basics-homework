package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 3, max = 10, message = "用户名长度必须为3到10位")
    @Pattern(regexp = "^\\w+$", message = "用户名只能包含数字、字母和下划线")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 5, max = 12, message = "密码长度必须为5到12位")
    private String password;

    @Email(message = "邮箱不符合规范")
    private String email;
}
