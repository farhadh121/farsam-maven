package com.radio.svc.searchentities;

/**
 * Created by farhad on 8/22/14.
 */
public class SearchResult {

    private String type;
    private String name;
    private Long id;
    private String artworkPath;
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

    public String getArtworkPath() {
        return artworkPath;
    }

    public void setArtworkPath(String artworkPath) {
        this.artworkPath = artworkPath;
    }

    public SearchResult(String type, String lyrics, String artworkPath, String name, Long id) {
        this.type = type;
        this.lyrics = lyrics;
        this.artworkPath = artworkPath;
        this.name = name;
        this.id = id;
    }

    public SearchResult() {
    }
}
