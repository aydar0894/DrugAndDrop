package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.service.UserService;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String getIndexPage() {
        return "redirect:/booking/";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String pageRender() {
        return "/errors/404";
    }

    @RequestMapping(value = "/permission_denied")
    public String getAccessDenyPage() {
        return "/errors/access-deny";
    }


}
