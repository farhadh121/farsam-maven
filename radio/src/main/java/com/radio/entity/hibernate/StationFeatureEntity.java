package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/9/14
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class StationFeatureEntity implements Serializable {

    private Timestamp version;
    private Long stationFeatureID;
    private String featureKey;
    private String featureValue;
    private StationEntity owner;

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    public Long getStationFeatureID() {
        return stationFeatureID;
    }

    public void setStationFeatureID(Long stationFeatureID) {
        this.stationFeatureID = stationFeatureID;
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

    public StationEntity getOwner() {
        return owner;
    }

    public void setOwner(StationEntity owner) {
        this.owner = owner;
    }

    public StationFeatureEntity(Timestamp version, Long stationFeatureID, String featureKey, String featureValue, StationEntity owner) {
        this.version = version;
        this.stationFeatureID = stationFeatureID;
        this.featureKey = featureKey;
        this.featureValue = featureValue;
        this.owner = owner;
    }

    public StationFeatureEntity() {
    }
}
