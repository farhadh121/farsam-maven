package com.radio.svc.controllers.radio.jsonentities;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 7/4/15
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class StationDeleteRequest {
    Long stationid;
    String username;

    public Long getStationid() {
        return stationid;
    }

    public void setStationid(Long stationid) {
        this.stationid = stationid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public StationDeleteRequest(Long stationid, String username) {
        this.stationid = stationid;
        this.username = username;
    }
    public StationDeleteRequest(){

    }
}
