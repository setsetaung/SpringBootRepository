package com.example.librarysystem.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.librarysystem.model.CustomUser;
import com.example.librarysystem.model.CustomUserRepository;
import com.example.librarysystem.model.Role;
import lombok.RequiredArgsConstructor;

/**
 * 認証処理コントローラー
 */
@Controller
@RequiredArgsConstructor
public class AuthController {

  // パスワードエンコーダ
  private final BCryptPasswordEncoder passwordEncoder;
  private final CustomUserRepository userRep;

  @GetMapping("/login")
  public String login() {
    return "auth/login";
  }

  @GetMapping("/register")
  public String register(@ModelAttribute("user") CustomUser user) {
    return "auth/register";
  }

  @PostMapping("/register")
  public String createUser(@Validated @ModelAttribute("user") CustomUser user, BindingResult result) {
    if (result.hasErrors()) {
      return "auth/register";
    }
    // フォームで入力されたパスワードをエンコード
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    // 権限設定
    user.setRole(user.isAdmin() ? Role.ROLE_ADMIN.name() : Role.ROLE_USER.name());
    // 登録
    userRep.save(user);

    // ログイン画面にリダイレクト
    return "redirect:/login?register";
  }
}
