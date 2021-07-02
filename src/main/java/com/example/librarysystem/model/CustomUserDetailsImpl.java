package com.example.librarysystem.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Spring SecurityのUserDetailsに項目を拡張するための実装
 * 
 * UserDetailsServiceImplで使用する
 */
public class CustomUserDetailsImpl extends User {

  private final CustomUser user;

  public CustomUserDetailsImpl(CustomUser user) {
    super(user.getUsername(), user.getPassword(), getAuthorities(user));
    this.user = user;
  }

  private static Collection<? extends GrantedAuthority> getAuthorities(CustomUser user) {
    Set<GrantedAuthority> authSet = new HashSet<>();
    authSet.add(new SimpleGrantedAuthority(user.getRole()));
    return authSet;
  }

  // 取得したい項目のgetメソッドを定義
  public long getUserId() {
    return user.getId();
  }

  public String getEmail() {
    return user.getEmail();
  }

}
