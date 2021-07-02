package com.example.librarysystem.model;

/**
 * ユーザー権限（ロール）
 *
 * SpringSecurityで使用する権限は「ROLE_～」の形式にしておく
 *
 */
public enum Role {
  /** 管理者権限 */
  ROLE_ADMIN,
  /** 一般権限 */
  ROLE_USER
}
