package com.github.eliogrin.dto;

public class EventDto {

    private int id;
    private String data;

    public String getBot() {
        return bot;
    }

    public void setBot(String bot) {
        this.bot = bot;
    }

    private String bot;

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
}
