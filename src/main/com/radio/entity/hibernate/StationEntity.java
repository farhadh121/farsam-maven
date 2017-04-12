package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/9/14
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class StationEntity implements Serializable {

    private Timestamp version;
    private Long stationID;
    private UserEntity owner;
    private Set<UserEntity> subscribers;
    private Set<StationFeatureEntity> features;
    private Date creationDate;
    private Date lastAccessDate;
    private String stationArtwork;
    private String stationName;

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    public Long getStationID() {
        return stationID;
    }

    public void setStationID(Long stationID) {
        this.stationID = stationID;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public Set<UserEntity> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<UserEntity> subscribers) {
        this.subscribers = subscribers;
    }

    public StationEntity(Timestamp version, Long stationID, UserEntity owner) {
        this.version = version;
        this.stationID = stationID;
        this.owner = owner;
    }

    public Set<StationFeatureEntity> getFeatures() {
        return features;
    }

    public void setFeatures(Set<StationFeatureEntity> features) {
        this.features = features;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Date lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public String getStationArtwork() {
        return stationArtwork;
    }

    public void setStationArtwork(String stationArtwork) {
        this.stationArtwork = stationArtwork;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public StationEntity() {
    }


}
