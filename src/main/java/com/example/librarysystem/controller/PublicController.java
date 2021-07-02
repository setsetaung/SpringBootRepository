package com.example.librarysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 一般公開（認証不要）URLのコントローラー
 */
@Controller
@RequestMapping("/")
public class PublicController {

  @GetMapping("")
  public String index() {
    return "index";
  }
}
