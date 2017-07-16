package com.radio.svc.controllers.radio.jsonentities;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 2/15/15
 * Time: 1:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class PickSongRequest {

    private String genre;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PickSongRequest(String genre) {
        this.genre = genre;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public PickSongRequest(){

    }
}
