package com.github.eliogrin.dto;

import org.joda.time.DateTime;

public class EventDto {

    private int id;
    private String data;
    private DateTime timestamp;
    private int bot;

    public int getBot() {
        return bot;
    }

    public void setBot(int bot) {
        this.bot = bot;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }
}
