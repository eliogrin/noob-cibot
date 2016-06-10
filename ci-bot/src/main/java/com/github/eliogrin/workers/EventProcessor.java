package com.github.eliogrin.workers;

import com.github.eliogrin.EventsProvider;
import com.google.gson.JsonArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventProcessor {

    @Autowired
    private EventsProvider provider;

    private Logger log = LoggerFactory.getLogger(EventProcessor.class);

    /** Requests new events and process its on regular basis. */
    public void processEvents() {
        JsonArray eventsJson = provider.getEvents();
        if (eventsJson.size() != 0) {
            log.info("Processing events data: {}", eventsJson);
        }
    }
}
