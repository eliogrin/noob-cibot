package com.github.eliogrin.models;

import com.github.eliogrin.dto.EventDto;
import com.github.eliogrin.models.core.AbstractModel;
import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class EventsModel extends AbstractModel {

    private List<EventDto> events = new ArrayList<EventDto>();

    public List<EventDto> data() {
        return events;
    }

    public void data(List<EventDto> data) {
        this.events = data;
    }

    public void save() {
        String query = "INSERT INTO events (id, data, bot) values (:id, :data, :bot)";
        Connection connection = connector().beginTransaction();
        connection.setRollbackOnException(true);
        for (EventDto event : events) {
            connection.createQuery(query).bind(event).executeUpdate();
        }
        connection.commit();
    }

    public void loadAll() {
        String query = "SELECT * FROM events";
        events = connector().instance().createQuery(query).executeAndFetch(EventDto.class);
    }
}
