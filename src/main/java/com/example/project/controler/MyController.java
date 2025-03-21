package com.example.project.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class MyController {

    private final Queue queue = new Queue();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("queueSize", queue.getSize());
        return "index";
    }

    @PostMapping("/reserve")
    public String reserve(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("status") String status,
            Model model) {

        int position = queue.addPerson(firstName, lastName, status);
        model.addAttribute("queuePosition", position);
        model.addAttribute("queueSize", queue.getSize());

        return "index";
    }
}