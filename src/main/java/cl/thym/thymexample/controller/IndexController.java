package cl.thym.thymexample.controller;

import cl.thym.thymexample.entity.UserPrivate;
import cl.thym.thymexample.enums.Endpoints;
import cl.thym.thymexample.enums.Thymenum;
import cl.thym.thymexample.service.RoleService;
import cl.thym.thymexample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(Endpoints.INDEX_GET)
    public String indexHome(Model model) {

        if (roleService.findAll().size()<=0) {
            roleService.init();
        }
        if (userService.findAll().size()<=0) {
            userService.init();
        }

        model.addAttribute("title", Thymenum.TITLE.getValue());
        model.addAttribute("userList", userService.findAll());
        return "index";
    }

    @GetMapping("/{userId}")
    public String indexHomePost(@PathVariable Long userId, Model model) throws Exception{

        /*
        For this particular case I will catch the Exception, since I'm working with Thymeleaf and not
        a REST API.
         */
        try {
            UserPrivate userFound = userService.findUserById(userId);
            model.addAttribute("userFound", userFound);
            log.info("User found with id: " +userId);
        } catch (Exception e) {
            log.error("User(s) not found with id : " + userId);
            model.addAttribute("userFound", null);
        }

        model.addAttribute("title",Thymenum.TITLE.getValue());
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("searchUser", true);

        return "index";
    }

}
