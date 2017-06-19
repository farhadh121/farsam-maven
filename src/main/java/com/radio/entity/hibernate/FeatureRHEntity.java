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
public class FeatureRHEntity implements Serializable {
    
    private Long FeatureRHID;
    private Timestamp version;
    private String rh;

    public FeatureRHEntity() {
    }

    public Long getFeatureRHID() {
        return FeatureRHID;
    }

    public void setFeatureRHID(Long FeatureRHID) {
        this.FeatureRHID = FeatureRHID;
    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    public String[] getRh() {
        // rh.split(",") to get a list of Strings, then typecast/parse them to Strings before returning or use Arrays.asList(arguments.split(","));
        return null;
    }

    public void setRh(String rh[]) {
        for ( String r : rh){
            this.rh = r;
        }
        /****
         * TODO: add everything comma seperated to an array
         */
    }
    
    
    
}
