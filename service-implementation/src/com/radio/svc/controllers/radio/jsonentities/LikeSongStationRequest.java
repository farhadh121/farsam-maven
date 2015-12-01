/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radio.svc.controllers.radio.jsonentities;

/**
 *
 * @author fxh155
 */
public class LikeSongStationRequest {
    
    //private String genre;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LikeSongStationRequest(String username) {
        this.username = username;
    }

  public LikeSongStationRequest(){
      
  }    
}
