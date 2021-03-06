package com.radio.svc.controllers.admin.jsonentities;

/**
 * Created by saman on 10/15/14.
 */
public class ChangeArtistNameRequest {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChangeArtistNameRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ChangeArtistNameRequest() {
    }

}
