package com.radio.svc.controllers.radio.jsonentities;

import com.radio.entity.hibernate.ArtistEntity;

/**
 * Created by saman on 8/24/14.
 */
public class NextSongResult {

    private String url;
    private String artWorkUrl;
    //FH added this to show the song title in player.
    private String title;
    private String artist;
    private String artistInfo;
    private Long songID;
    private boolean likeStatus;
    private boolean dislikeStatus;
    private int likeCount;

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    private int dislikeCount;

    public boolean getDislikeStatus() {
        return dislikeStatus;
    }

    public void setDislikeStatus(boolean dislikeStatus) {
        this.dislikeStatus = dislikeStatus;
    }

    public boolean getLikeStatus() {

        return likeStatus;
    }

    public void setLikeStatus(boolean likeStatus) {
        this.likeStatus = likeStatus;
    }

    public Long getSongID() {
        return songID;
    }

    public void setSongID(Long songID) {
        this.songID = songID;
    }

    public String getArtistInfo() {
        return artistInfo;
    }

    public void setArtistInfo(String artistInfo) {
        this.artistInfo = artistInfo;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtWorkUrl() {
        return artWorkUrl;
    }

    public void setArtWorkUrl(String artWorkUrl) {
        this.artWorkUrl = artWorkUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public NextSongResult(String url, String artWorkUrl, String title, String artist, String artistInfo, Long songID, boolean likeStatus) {
        this.url = url;
        this.artWorkUrl = artWorkUrl;
        this.title = title;
        this.artist = artist;
        this.artistInfo = artistInfo;
        this.songID = songID;
        this.likeStatus= likeStatus;
    }
    public NextSongResult(){

    }

}
