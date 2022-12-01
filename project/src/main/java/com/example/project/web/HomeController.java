package com.example.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "projectHome2";
    }
    
    @GetMapping("/yes")
    public String yes() {
        return "yes";
    }
    
    @GetMapping("/best")
    public String bestseller() {
        return "banner/best";
    }
    @GetMapping("/bslider")
    public String boot() {
        return "banner/bslider";
    }
    @GetMapping("/test")
    public String test() {
        return "test/testslider";
    }
    @GetMapping("/slider")
    public String slider() {
        return "banner/slider";
    }
    @GetMapping("/kyobo")
    public String kyobo() {
        return "kyobo";
    }
        
    @GetMapping("/footer")
    public String footer() {
            return "fragments/footer";
    }
    
    
    
}
