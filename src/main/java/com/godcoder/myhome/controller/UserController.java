package com.godcoder.myhome.controller;

import com.godcoder.myhome.model.User;
import com.godcoder.myhome.repository.UserRepository;
import com.godcoder.myhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/list")
    public String list(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);

        return "user/user_list";
    }

    @PostMapping("/list")
    public String register(User user){
        List<User> users = userRepository.findAll();
        System.out.println("users");
        int i;
        for( i=0 ; i < users.size(); i++){
            String password = passwordEncoder.encode(users.get(i).getPassword());;
            Integer user_id = users.get(i).getUser_id();
            userRepository.update(password,user_id);
        }
        return "redirect:/";
    }
}
