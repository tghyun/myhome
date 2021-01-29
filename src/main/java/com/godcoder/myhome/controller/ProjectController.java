package com.godcoder.myhome.controller;

import com.godcoder.myhome.model.Project;
import com.godcoder.myhome.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/proj")
public class ProjectController {

//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @GetMapping("/list")
//    public String list(Model model){
//        List<Project> proj = projectRepository.findAll();
//        model.addAttribute("proj",proj);
//        return "proj/proj_list";
//    }

}
