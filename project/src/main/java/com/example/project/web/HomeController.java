package com.example.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "main";
    }
    @GetMapping("/search")
    public void search() {
        
    }
    
    
    
    
    
}
