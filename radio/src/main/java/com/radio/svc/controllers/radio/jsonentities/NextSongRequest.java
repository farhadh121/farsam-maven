package com.radio.svc.controllers.radio.jsonentities;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 10/26/14
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class NextSongRequest {

    private int stationid;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStationid() {
        return stationid;
    }

    public void setStationid(int stationid) {
        this.stationid = stationid;
    }

    public NextSongRequest() {
    }

    public NextSongRequest(int stationid, String username) {
        this.stationid = stationid;
        this.username = username;
    }
}
