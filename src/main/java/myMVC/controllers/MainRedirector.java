package myMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainRedirector {
    @GetMapping()
    public String redirector() {
        return "redirect:/people";
    }
}
