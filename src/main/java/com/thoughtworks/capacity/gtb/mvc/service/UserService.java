package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.CommonException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public void register(User user) throws CommonException {
        if (users.stream().anyMatch(item -> item.getUsername().equals(user.getUsername()))) {
            throw new CommonException("用户名已存在");
        }
        user.setId(users.size() + 1);
        users.add(user);
    }

    public User login(String username, String password) {
        for (User user :users){
            if (user.getUsername().equals(username)&&user.getPassword().equals(password)){
                return user;
            }
        }
        throw new CommonException("用户名或密码错误！");
    }
}
