package com.github.eliogrin.controllers.rest;

import com.github.eliogrin.controllers.core.ApiController;
import com.github.eliogrin.dto.EventDto;
import com.github.eliogrin.models.EventsModel;
import com.github.eliogrin.models.core.ModelFactory;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class SkypeRestController extends ApiController {

    @Autowired
    private ModelFactory factory;

    private Logger log = LoggerFactory.getLogger(SkypeRestController.class);

    @RequestMapping(path = "/skype/{botId}", method = RequestMethod.POST, consumes = "application/json")
    public void postEvent(@PathVariable String botId, HttpEntity<String> httpEntity) {
        log.info("Event for {}, content {}", botId, httpEntity.getBody());
        EventsModel model = factory.getModel(EventsModel.class);
        model.data(asDtoList(botId, httpEntity.getBody()));
        model.save();
    }

    private List<EventDto> asDtoList(String botName, String stringData) {
        List<EventDto> events = new ArrayList<EventDto>();
        Iterator<JsonElement> iterator = new Gson().fromJson(stringData, JsonArray.class).iterator();
        while (iterator.hasNext()) {
            EventDto eventDto = new EventDto();
            eventDto.setBot(botName);
            eventDto.setData(iterator.next().toString());
            events.add(eventDto);
        }
        return events;
    }
}
