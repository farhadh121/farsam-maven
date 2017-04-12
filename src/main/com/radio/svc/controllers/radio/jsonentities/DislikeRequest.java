package com.radio.svc.controllers.radio.jsonentities;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 1/10/15
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class DislikeRequest {
    private Long userid;
    private Long songid;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getSongid() {
        return songid;
    }

    public void setSongid(Long songid) {
        this.songid = songid;
    }

    public DislikeRequest(Long songid, String userName) {

    }
    //dummy constructor
    public DislikeRequest(){

    }
}
