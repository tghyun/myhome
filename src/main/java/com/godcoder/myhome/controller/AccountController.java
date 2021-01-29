package com.godcoder.myhome.controller;

import com.godcoder.myhome.model.User;
import com.godcoder.myhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 로그인
    @GetMapping("/login")
    public String login(){
        return "account/login";
    }

    //회원기입
    @GetMapping("/register")
     public String register(){
        return "account/register";
    }
    //가입처리
    @PostMapping("/register")
    public String register(User user){
        userService.save(user);
        return "redirect:/";
    }

    //로그아웃결과페이지
    @GetMapping("/logout/result")
    public String logout(){
        return "account/result/logout";
    }
    //접근거부페이지
    @GetMapping("/denied")
    public String denied(){
        return "account/denied";
    }



}
