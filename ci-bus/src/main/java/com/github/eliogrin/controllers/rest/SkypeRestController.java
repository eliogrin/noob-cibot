package com.github.eliogrin.controllers.rest;

import com.github.eliogrin.controllers.core.ApiController;
import com.github.eliogrin.dto.EventDto;
import com.github.eliogrin.models.EventsModel;
import com.github.eliogrin.models.ConsumerModel;
import com.github.eliogrin.models.core.ModelFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class SkypeRestController extends ApiController {

    @Autowired
    private ModelFactory factory;

    @RequestMapping(path = "/skype/{botHash}", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Void> postEvent(@PathVariable String botHash, HttpEntity<JsonArray> httpEntity) {
        ConsumerModel consumerModel = factory.getModel(ConsumerModel.class);
        consumerModel.load(botHash);
        if (consumerModel.isLoaded()) {
            EventsModel model = factory.getModel(EventsModel.class);
            model.data(asDtoList(consumerModel.data().getId(), httpEntity.getBody()));
            model.save();
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
    }

    private List<EventDto> asDtoList(int botId, JsonArray arrayData) {
        List<EventDto> events = new ArrayList<EventDto>();
        Iterator<JsonElement> iterator = arrayData.iterator();
        while (iterator.hasNext()) {
            EventDto eventDto = new EventDto();
            eventDto.setBot(botId);
            eventDto.setData(iterator.next().toString());
            events.add(eventDto);
        }
        return events;
    }
}
