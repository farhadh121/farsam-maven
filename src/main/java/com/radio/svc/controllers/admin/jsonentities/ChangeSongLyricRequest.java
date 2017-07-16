package com.radio.svc.controllers.admin.jsonentities;

/**
 * Created by saman on 10/1/14.
 */
public class ChangeSongLyricRequest {

    private Long id;
    private String lyric;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public ChangeSongLyricRequest(Long id, String lyric) {
        this.id = id;
        this.lyric = lyric;
    }

    public ChangeSongLyricRequest() {
    }
}
