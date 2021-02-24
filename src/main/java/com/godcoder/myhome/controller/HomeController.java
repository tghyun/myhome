package com.godcoder.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping
    public String index(Principal principal){

        if(principal == null){
            return "index";
        }else{
            return "redirect:/event/event_home";
        }
    }
}
