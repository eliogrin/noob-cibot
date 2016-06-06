package com.github.eliogrin.controllers.core;

import com.github.eliogrin.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component
public class WebController {

    @Autowired
    private UserData user;

    @ModelAttribute("username")
    protected String getUsername() {
        return user.getUsername();
    }
}
