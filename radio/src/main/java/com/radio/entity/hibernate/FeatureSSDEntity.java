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
public class FeatureSSDEntity implements Serializable {
    private Long FeatureSSDID;
    private Timestamp version;
    private String ssd;

    public FeatureSSDEntity() {
    }
    
    public static FeatureSSDEntity create(final String... args) {
        if (args.length != 67) {
            return null; // or throw an exception
        }
        final FeatureSSDEntity rv = new FeatureSSDEntity();
        rv.setFeatureSSDID(Long.parseLong(args[0]));
        rv.setSsd(args[1]);
        // ...
        return rv;
    }

    public Long getFeatureSSDID() {
        return FeatureSSDID;
    }

    public void setFeatureSSDID(Long SongID) {
        this.FeatureSSDID = SongID;
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

    public void setSsd(String ssd) {
        
            this.ssd = ssd;
        
        /****
         * TODO: add everything comma seperated to an array
         */
    }
}
