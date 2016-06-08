package com.github.eliogrin.controllers;

import com.github.eliogrin.controllers.core.WebController;
import com.github.eliogrin.dto.UserDto;
import com.github.eliogrin.models.AgentModel;
import com.github.eliogrin.models.AgentsModel;
import com.github.eliogrin.models.core.ModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@Controller
@RequestMapping("/agents")
public class AgentController extends WebController {

    @Autowired
    private ModelFactory factory;

    @Autowired
    private ShaPasswordEncoder encoder;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllAgents(Model model) {
        AgentsModel agentsModel = factory.getModel(AgentsModel.class);
        agentsModel.load();
        model.addAttribute("agentsList", agentsModel.data());
        return "agents";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String newAgent(@ModelAttribute("agentForm") UserDto agentDto) {
        String encodedPassword = encoder.encodePassword(agentDto.getPassword(), null);
        agentDto.setPassword(encodedPassword);
        AgentModel agentModel = factory.getModel(AgentModel.class);
        agentModel.data(agentDto);
        agentModel.save();
        return "redirect:/agents";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String getNewAgent(@ModelAttribute("agentForm") UserDto agentDto) {
        agentDto.setHash(UUID.randomUUID().toString());
        return "agent";
    }

    @RequestMapping(path = "/{agentId}", method = RequestMethod.GET)
    public String showEditAgentForm(@PathVariable int agentId, @ModelAttribute("agentForm") UserDto agentDto) {
        AgentModel agentModel = factory.getModel(AgentModel.class);
        agentModel.data().setId(agentId);
        agentModel.load();
        agentDto.setId(agentId);
        agentDto.setName(agentModel.data().getName());
        agentDto.setHash(agentModel.data().getHash());
        return "agent";
    }

    @RequestMapping(path = "/{agentId}/remove", method = RequestMethod.GET)
    public String getAgent(@PathVariable int agentId) {
        AgentModel agentModel = factory.getModel(AgentModel.class);
        agentModel.data().setId(agentId);
        agentModel.remove();
        return "redirect:/agents";
    }
}
