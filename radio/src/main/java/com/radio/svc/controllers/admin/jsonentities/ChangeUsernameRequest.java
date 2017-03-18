package com.radio.svc.controllers.admin.jsonentities;

/**
 * Created by saman on 11/12/14.
 */
public class ChangeUsernameRequest {

    private String userID;
    private String username;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ChangeUsernameRequest(String userID, String username) {
        this.userID = userID;
        this.username = username;
    }

}
