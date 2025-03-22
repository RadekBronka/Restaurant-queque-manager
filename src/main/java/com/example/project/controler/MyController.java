package com.example.project.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class MyController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    @GetMapping("/reserve")
    public String reserve(Model model) {
        return "reserve";
    }
}