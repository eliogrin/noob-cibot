package com.github.eliogrin.controllers.core;

import com.github.eliogrin.ConsumerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component
public class WebController {

    @Autowired
    private ConsumerData user;

    @ModelAttribute("username")
    protected String getUsername() {
        return user.getUsername();
    }
}
