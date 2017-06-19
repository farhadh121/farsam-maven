package com.radio.svc.controllers.admin.jsonentities;

/**
 * Created by saman on 11/12/14.
 */
public class ChangeUserFirstNameRequest {

    private Long userID;
    private String FirstName;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public ChangeUserFirstNameRequest() {
    }
}
