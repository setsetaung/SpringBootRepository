package com.example.librarysystem.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {

  /** ユーザー名で検索する */
  CustomUser findByUsername(String username);
}
