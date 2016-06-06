package com.github.eliogrin.controllers;

import com.github.eliogrin.controllers.core.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cars")
public class HelloController extends WebController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(@RequestParam(required = false) ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }

    @RequestMapping(value = "/path/{id}", method = RequestMethod.GET)
    public String printHelloPathParam(@PathVariable String id, ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        model.addAttribute("id", id);
        return "hello";
    }

    @RequestMapping(value = "/again", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("message", "Hello World Again, from Spring 4 MVC");
        return "hello";
    }
}