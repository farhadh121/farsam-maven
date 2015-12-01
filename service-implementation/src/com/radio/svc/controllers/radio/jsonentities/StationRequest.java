package com.radio.svc.controllers.radio.jsonentities;

/**
 * Created by saman on 8/29/14.
 */
public class StationRequest {

    private String type;
    private String name;
    private Long id;
    private String lyrics;

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StationRequest(String type, String name, Long id, String lyrics) {
        this.type = type;
        this.name = name;
        this.id = id;
        this.lyrics = lyrics;
    }

    public StationRequest() {
    }
}
