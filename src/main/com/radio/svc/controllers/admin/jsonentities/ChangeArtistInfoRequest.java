package com.radio.svc.controllers.admin.jsonentities;

/**
 * Created by saman on 10/15/14.
 */
public class ChangeArtistInfoRequest {

    private Long id;
    private String info;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ChangeArtistInfoRequest(Long id, String info) {
        this.id = id;
        this.info = info;
    }

    public ChangeArtistInfoRequest() {
    }
}
