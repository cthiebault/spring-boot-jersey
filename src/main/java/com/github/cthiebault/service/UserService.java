package com.github.cthiebault.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.github.cthiebault.domain.User;

@Component
public class UserService {

  private final List<User> users = new ArrayList<>();

  @PostConstruct
  public void init() {
    users.add(new User("admin", "admin@admin.com"));
  }

  public List<User> getUsers() {
    return users;
  }

  public void addUser(User user) {
    users.add(user);
  }

}
