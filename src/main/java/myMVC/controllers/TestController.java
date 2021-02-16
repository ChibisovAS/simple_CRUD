package myMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/view")
public class TestController {

    @GetMapping("/test")
    public String test(@RequestParam(value = "name",required = false) String name, Model model) {

        model.addAttribute("name",name);

        return "view-test-dir/view-example";
    }
}
