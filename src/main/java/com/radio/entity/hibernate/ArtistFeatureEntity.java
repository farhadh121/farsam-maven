package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/18/14
 * Time: 10:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArtistFeatureEntity implements Serializable {

    private Long artistFeatureID;
    private Timestamp version;
    private String featureKey;
    private String featureValue;
    private ArtistEntity owner;

    public Long getArtistFeatureID() {
        return artistFeatureID;
    }

    public void setArtistFeatureID(Long artistFeatureID) {
        this.artistFeatureID = artistFeatureID;
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

    public ArtistEntity getOwner() {
        return owner;
    }

    public void setOwner(ArtistEntity owner) {
        this.owner = owner;
    }

    public ArtistFeatureEntity(Long artistFeatureID, Timestamp version, String featureKey, String featureValue, ArtistEntity owner) {
        this.artistFeatureID = artistFeatureID;
        this.version = version;
        this.featureKey = featureKey;
        this.featureValue = featureValue;
        this.owner = owner;
    }

    public ArtistFeatureEntity() {
    }

}
