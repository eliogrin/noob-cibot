package com.github.eliogrin.controllers;

import com.github.eliogrin.controllers.core.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController extends WebController {
    @RequestMapping(method = RequestMethod.GET)
    public String showWebForm() {
        return "login";
    }
}