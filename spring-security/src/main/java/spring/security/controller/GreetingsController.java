package spring.security.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetingsController {
    @GetMapping("/")
    public String publicPage() {
        return "public";
    }

    @GetMapping("/private")
    public String privatePage() {
        return "This should be private";
    }

}
