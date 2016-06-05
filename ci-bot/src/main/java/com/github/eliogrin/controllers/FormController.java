package com.github.eliogrin.controllers;

import com.github.eliogrin.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/form")
public class FormController {

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("userForm", new TestDto());
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postForm(@ModelAttribute("userForm") TestDto dao, ModelMap model) {
        model.addAttribute("userForm", dao);
        return "form";
    }
}