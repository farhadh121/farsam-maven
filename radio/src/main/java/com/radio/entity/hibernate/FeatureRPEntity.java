/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author farhad
 */
public class FeatureRPEntity implements Serializable {
    
       private Long FeatureRPID;
    private Timestamp version;
    private String rp;

    public FeatureRPEntity() {
    }

    public Long getFeatureRHID() {
        return FeatureRPID;
    }

    public void setFeatureRHID(Long SongID) {
        this.FeatureRPID = SongID;
    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    public String[] getSsd() {
        // rh.split(",") to get a list of Strings, then typecast/parse them to Strings before returning or use Arrays.asList(arguments.split(","));
        return null;
    }

    public void setSsd(String ssd[]) {
        for ( String s : ssd){
            this.rp = s;
        }
        /****
         * TODO: add everything comma seperated to an array        /****
         * TODO: add everything comma seperated to an array
         */
    }
}
