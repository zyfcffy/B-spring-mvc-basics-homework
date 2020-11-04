package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.CommonException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping(value = "/users")
@Validated
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user) throws CommonException {
        userService.register(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestParam(value = "username") @Length(min = 3, max = 10, message = "用户名长度必须为3到10位")
                          @Pattern(regexp = "^\\w+$", message = "用户名只能包含数字、字母和下划线") String username,
                      @RequestParam(value = "password") @Length(min = 5, max = 12, message = "密码长度必须为5到12位") String password){
        return userService.login(username,password);
    }
}
