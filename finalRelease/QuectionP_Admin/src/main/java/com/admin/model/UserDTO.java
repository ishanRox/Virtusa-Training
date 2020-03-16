package com.admin.model;

public class UserDTO {
  private String username;
  private String password;
  private String email;
  private String gitname;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGitname() {
    return gitname;
  }

  public void setGitname(String gitname) {
    this.gitname = gitname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}