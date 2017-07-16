package com.radio.svc.controllers.radio.jsonentities;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 1/4/15
 * Time: 9:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class FacebookLoginResult {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FacebookLoginResult() {
    }

    public FacebookLoginResult(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
}
