package com.example.librarysystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * ユーザーエンティティクラス
 * 
 * 「User」はSpringSecurityでも使用しているので別名にしたほうが無難
 *
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class CustomUser {

  /** ID */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  /** ユーザー名 */
  @NotBlank(message = "UserName Must Not Be Blank")
  private String username;
  /** パスワード */

  @Size(min = 8, max = 255,message="Password must be between 8 and 255")
  private String password;
  /** 権限 */
  private String role;
  /** 管理者フラグ */
  private boolean admin;

  // 以下、任意の項目・・・
  @Email(message = "Email Must Be A Well-Formed Email Address")
  private String email;

}
