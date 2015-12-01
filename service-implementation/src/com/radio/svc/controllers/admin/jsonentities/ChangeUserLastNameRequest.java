package com.radio.svc.controllers.admin.jsonentities;

/**
 * Created by saman on 11/12/14.
 */
public class ChangeUserLastNameRequest {

    private Long userID;
    private String LastName;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public ChangeUserLastNameRequest() {
    }
}
