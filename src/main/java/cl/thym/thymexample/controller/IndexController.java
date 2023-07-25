package cl.thym.thymexample.controller;

import cl.thym.thymexample.enums.Endpoints;
import cl.thym.thymexample.enums.Thymenum;
import cl.thym.thymexample.service.RoleService;
import cl.thym.thymexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(Endpoints.INDEX_GET)
    public String indexHome(Model model) {

        roleService.init();
        userService.init();

        model.addAttribute("title", Thymenum.TITLE.getValue());
        model.addAttribute("userList", null);
        return "index";
    }

    @GetMapping("/{userId}")
    public String indexHomePost(@PathVariable Long userId, Model model) throws Exception{

        userService.findUserById(userId);

        model.addAttribute("title",Thymenum.TITLE.getValue());
        return "index";
    }

}
