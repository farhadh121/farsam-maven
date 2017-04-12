package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

public class UserEntity implements Serializable {

    private Timestamp version;
    private Long userID;
    private String email;
    private String password;
    private Date bornDate;
    private String firstName;
    private String lastName;
    private Set<RoleEntity> roles;
    private Set<StationEntity> ownedStations;
    private Set<StationEntity> suscribedStations;
    private String imageURL;
    private Set<SongEntity> likedSongs;
    private Set<SongEntity> dislikedSongs;

    public Set<SongEntity> getDislikedSongs() {
        return dislikedSongs;
    }

    public void setDislikedSongs(Set<SongEntity> dislikedSongs) {
        this.dislikedSongs = dislikedSongs;
    }

    public UserEntity(){

    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    public Set<SongEntity> getLikedSongs() {
        return likedSongs;
    }

    public void setLikedSongs(Set<SongEntity> likedSongs) {
        this.likedSongs = likedSongs;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public Set<StationEntity> getOwnedStations() {
        return ownedStations;
    }

    public void setOwnedStations(Set<StationEntity> ownedStations) {
        this.ownedStations = ownedStations;
    }

    public Set<StationEntity> getSuscribedStations() {
        return suscribedStations;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setSuscribedStations(Set<StationEntity> suscribedStations) {
        this.suscribedStations = suscribedStations;
    }
}
