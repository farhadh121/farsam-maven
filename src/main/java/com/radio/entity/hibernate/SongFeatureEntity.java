package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/18/14
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class SongFeatureEntity implements Serializable {

    private Long songFeatureID;
    private Timestamp version;
    private String featureKey;
    private String featureValue;
    private SongEntity owner;

    public Long getSongFeatureID() {
        return songFeatureID;
    }

    public void setSongFeatureID(Long songFeatureID) {
        this.songFeatureID = songFeatureID;
    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    public String getFeatureKey() {
        return featureKey;
    }

    public void setFeatureKey(String featureKey) {
        this.featureKey = featureKey;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }

    public SongEntity getOwner() {
        return owner;
    }

    public void setOwner(SongEntity owner) {
        this.owner = owner;
    }

    public SongFeatureEntity(Long songFeatureID, Timestamp version, String featureKey, String featureValue, SongEntity owner) {
        this.songFeatureID = songFeatureID;
        this.version = version;
        this.featureKey = featureKey;
        this.featureValue = featureValue;
        this.owner = owner;
    }

    public SongFeatureEntity() {
    }

}
