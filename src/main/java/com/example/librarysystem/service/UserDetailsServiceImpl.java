package com.example.librarysystem.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.librarysystem.model.CustomUser;
import com.example.librarysystem.model.CustomUserDetailsImpl;
import com.example.librarysystem.model.CustomUserRepository;
import lombok.RequiredArgsConstructor;

/**
 * Spring Securityで使用するユーザー情報（UserDetails）を取得するためのサービスクラス
 *
 * DBに登録されているユーザー情報をUserDetailsに変換している
 *
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  /** DBのユーザー情報にアクセスするためのリポジトリ */
  private final CustomUserRepository rep;

  /** ユーザー名からユーザー情報を取得する */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // DB検索
    CustomUser user = rep.findByUsername(username);
    if (user == null) {
      // 見つからない場合は例外をスロー
      throw new UsernameNotFoundException(username + " not found.");
    }
    // UserDetailsオブジェクトを作成
    // カスタム実装クラスを使用
    return new CustomUserDetailsImpl(user);
  }
}
