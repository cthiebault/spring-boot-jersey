package com.github.cthiebault.domain;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

  private static final long serialVersionUID = -5144714862816502186L;

  private String name;

  private String email;

  public User() {
  }

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) {
      return true;
    }
    if(obj == null || getClass() != obj.getClass()) {
      return false;
    }
    User other = (User) obj;
    return Objects.equals(name, other.name);
  }
}
