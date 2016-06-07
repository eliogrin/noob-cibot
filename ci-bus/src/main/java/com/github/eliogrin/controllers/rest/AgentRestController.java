package com.github.eliogrin.controllers.rest;

import com.github.eliogrin.controllers.core.ApiController;
import com.github.eliogrin.dto.EventDto;
import com.github.eliogrin.models.EventsModel;
import com.github.eliogrin.models.core.ModelFactory;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentRestController extends ApiController {

    @Autowired
    private ModelFactory factory;

    @Autowired
    private Gson gson;

    @RequestMapping(path = "/agent/{botId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<JsonArray> postEvent(@PathVariable String botId, @RequestParam int limit) {
        EventsModel events = factory.getModel(EventsModel.class);
        events.load(botId, limit);
        if (events.data().isEmpty()) {
            return new ResponseEntity<JsonArray>(HttpStatus.NO_CONTENT);
        }
        events.delete();
        return new ResponseEntity<JsonArray>(asJsonArray(events.data()), HttpStatus.OK);
    }

    private JsonArray asJsonArray(List<EventDto> events) {
        JsonArray jsonArray = new JsonArray();
        for (EventDto event : events) {
            jsonArray.add(gson.fromJson(event.getData(), JsonElement.class));
        }
        return jsonArray;
    }
}
