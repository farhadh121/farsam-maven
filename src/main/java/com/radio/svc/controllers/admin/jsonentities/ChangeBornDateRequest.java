package com.radio.svc.controllers.admin.jsonentities;

/**
 * Created by saman on 11/12/14.
 */
public class ChangeBornDateRequest {

    private Long userID;
    private String bornDate;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public ChangeBornDateRequest() {
    }
}
