package cl.thym.thymexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexHome(Model model) {
        model.addAttribute("title","Thymexample App");
        return "index";
    }

}
