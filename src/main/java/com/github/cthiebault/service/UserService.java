package com.github.cthiebault.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.github.cthiebault.domain.User;

@Component
public class UserService {

  private final Map<String, User> users = new HashMap<>();

  @PostConstruct
  public void init() {
    users.put("admin", new User("admin", "admin@admin.com"));
  }

  public Collection<User> findAll() {
    return users.values();
  }

  public void addUser(User user) {
    users.put(user.getName(), user);
  }

  public void deleteUser(String name) {
    users.remove(name);
  }

  public User findByName(String name) {
    return users.get(name);
  }

}
