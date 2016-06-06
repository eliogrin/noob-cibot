package com.github.eliogrin.controllers;

import com.github.eliogrin.controllers.core.WebController;
import com.github.eliogrin.models.EventsModel;
import com.github.eliogrin.models.core.ModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends WebController {

    @Autowired
    ModelFactory factory;

    @RequestMapping("/")
    public String getIndex(ModelMap model) {
        EventsModel events = factory.getModel(EventsModel.class);
        events.loadAll();
        model.addAttribute("events", events.data());
        return "index";
    }
}