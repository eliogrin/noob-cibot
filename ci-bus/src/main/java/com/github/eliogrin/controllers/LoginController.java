package com.github.eliogrin.controllers;

import com.github.eliogrin.controllers.core.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController extends WebController {
    @RequestMapping(method = RequestMethod.GET)
    public String showWebForm(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return "login";
    }
}