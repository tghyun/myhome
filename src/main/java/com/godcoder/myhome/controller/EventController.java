package com.godcoder.myhome.controller;

import com.godcoder.myhome.model.Event;
import com.godcoder.myhome.model.User;
import com.godcoder.myhome.repository.EventRepository;
import com.godcoder.myhome.repository.UserRepository;
import com.godcoder.myhome.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventService eventService;

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/event_home")
    public String home(Model model, Principal principal){

        List<User> users = userRepository.findByUsername(principal.getName());
        String event_num = eventRepository.findByUserId(users.get(0).getUser_id());
        model.addAttribute("name",users.get(0).getName());
        model.addAttribute("user_id",users.get(0).getUser_id());
        model.addAttribute("username",users.get(0).getUsername());
        model.addAttribute("event_num",event_num);

        return "event/event_home";
    }

    @GetMapping("/event01")
    public String event01(Model model,Principal principal){
        List<User> users = userRepository.findByUsername(principal.getName());
        model.addAttribute("user_id",users.get(0).getUser_id());
        return "event/event01";
    }

    @PostMapping("/event01")
    public String event01(Event event){
        System.out.println(">>>> "+event);
        eventService.save(event);
        return "redirect:/";
    }

    @GetMapping("/event02")
    public String event02(Model model,Principal principal){
        List<User> users = userRepository.findByUsername(principal.getName());
        model.addAttribute("user_id",users.get(0).getUser_id());
        return "event/event02";
    }

    @GetMapping("/event03")
    public String event03(Model model,Principal principal){
        List<User> users = userRepository.findByUsername(principal.getName());
        model.addAttribute("user_id",users.get(0).getUser_id());
        return "event/event03";
    }
}
