package com.radio.svc.controllers.admin.jsonentities;

/**
 * Created by saman on 10/17/14.
 */
public class ChangeAlbumReleaseDate {

    private Long id;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ChangeAlbumReleaseDate(Long id, String date) {
        this.id = id;
        this.date = date;
    }

    public ChangeAlbumReleaseDate() {
    }
}
