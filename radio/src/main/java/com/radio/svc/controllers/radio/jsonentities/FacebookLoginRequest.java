package com.radio.svc.controllers.radio.jsonentities;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 1/4/15
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class FacebookLoginRequest {
    private String name;
    private String link;
    private String username;
    private String id;
    private String picture;
    private String birthday;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public FacebookLoginRequest() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public FacebookLoginRequest(String name, String link, String username, String id, String picture, String birthday, String email) {
        this.name = name;
        this.link = link;
        this.username = username;
        this.id = id;
        this.picture = picture;
        this.birthday = birthday;
        this.email = email;
    }

   
    
}
