package com.radio.svc.controllers.admin.jsonentities;

/**
 * Created by saman on 11/12/14.
 */
public class ChangePasswordRequest {

    private String userID;
    private String oldPassword;
    private String newPassword;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public ChangePasswordRequest() {
    }
}
