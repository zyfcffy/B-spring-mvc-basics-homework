package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.ExistedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public void register(User user) throws ExistedException {
        if (users.stream().anyMatch(item -> item.getUsername().equals(user.getUsername()))) {
            throw new ExistedException("用户名已存在");
        }
        users.add(user);
    }
}
