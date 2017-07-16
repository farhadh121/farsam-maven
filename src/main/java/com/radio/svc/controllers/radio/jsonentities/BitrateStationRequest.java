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
public class BitrateStationRequest {
    
    //private String genre;
    private int bitRate;

    public int getBitRate() {
        return bitRate;
    }

    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }

    public BitrateStationRequest(int bitRate) {
        this.bitRate = bitRate;
    }

    public BitrateStationRequest(){
        
    }
}
