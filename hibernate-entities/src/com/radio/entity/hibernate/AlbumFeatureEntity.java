package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/18/14
 * Time: 10:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class AlbumFeatureEntity implements Serializable {

    private Long albumFeatureID;
    private Timestamp version;
    private String featureKey;
    private String featureValue;
    private AlbumEntity owner;

    public Long getAlbumFeatureID() {
        return albumFeatureID;
    }

    public void setAlbumFeatureID(Long albumFeatureID) {
        this.albumFeatureID = albumFeatureID;
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

    public AlbumEntity getOwner() {
        return owner;
    }

    public void setOwner(AlbumEntity owner) {
        this.owner = owner;
    }

    public AlbumFeatureEntity(Long albumFeatureID, Timestamp version, String featureKey, String featureValue, AlbumEntity owner) {
        this.albumFeatureID = albumFeatureID;
        this.version = version;
        this.featureKey = featureKey;
        this.featureValue = featureValue;
        this.owner = owner;
    }

    public AlbumFeatureEntity() {
    }

}
