package com.radio.svc.common;

import com.google.common.base.Splitter;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/14/14
 * Time: 10:19 PM
 * To change this template use CommonFile | Settings | CommonFile Templates.
 */
public class CommonFile {


    //////////////////////////////////////////////////////
    /**
     * Specifies the dash character which by default should be "-"
     */
    private String dash;
    /**
     * Base address of the repository of all songs
     */
    private String songsRepositoryBasePath;
    /**
     * Base address of the repository of all song artworks
     */
    private String songArtworksRepositoryBasePath;
    /**
     * Base address of the repository of all artist artworks
     */
    private String artistArtworkRepositoryBasePath;
    /**
     * Base address of the repository of all record label artworks
     */
    private String recordLabelArtworkRepositoryBasePath;
    /**
     * Base address of the repository of all album artworks
     */
    private String albumArtworkRepositoryBasePath;
    /**
     * Base address of the repository of all station artworks
     */
    private String stationArtworkRepositoryBasePath;
    /**
     * Base address of the repository of all user images
     */
    private String userImageRepositoryBasePath;
    /**
     * The address from tomcat to songs folder
     */
    private String songsPathAlias;
    /**
     * The address from tomcat to song artwork folder
     */
    private String songArtworksAlias;
    /**
     * The address from tomcat to artist artwork folder
     */
    private String artistaArtworksaAlias;
    /**
     * The address from tomcat to record label artwork
     */
    private String recordlabelArtworkAlias;
    /**
     * The address from tomcat to album artwork
     */
    private String albumArtworksAlias;
    /**
     * The address from tomcat to station artwork
     */
    private String stationArtworkAlias;
    /**
     * the address from tomcat to user image
     */
    private String userImageAlias;
    /**
     * domain of the radio site
     */
    private String domain;
    /**
     * separator character which is used for separating directories
     */
    private String separator;
    /**
     * dot character which is by default "."
     */
    private String dot;

    /**
     * song path repository for initialization
     */
    private String initsongpath;

    /**
     * song artwork path for initialization
     */
    private String initsongartworkpath;

    /**
     * record label artwork path for initialization
     */
    private String initrecordlabelartworkpath;

    /**
     * album artwork path for initialization
     */
    private String initalbumartworkpath;

    /**
     * artist artwork path for initialization
     */
    private  String initartistartworkpath;




    //////////////////////////////////////////////////////

    public String getDash() {
        return dash;
    }

    public void setDash(String dash) {
        this.dash = dash;
    }

    public String getSongsRepositoryBasePath() {
        return songsRepositoryBasePath;
    }

    public void setSongsRepositoryBasePath(String songsRepositoryBasePath) {
        this.songsRepositoryBasePath = songsRepositoryBasePath;
    }

    public String getSongArtworksRepositoryBasePath() {
        return songArtworksRepositoryBasePath;
    }

    public void setSongArtworksRepositoryBasePath(String songArtworksRepositoryBasePath) {
        this.songArtworksRepositoryBasePath = songArtworksRepositoryBasePath;
    }

    public String getArtistArtworkRepositoryBasePath() {
        return artistArtworkRepositoryBasePath;
    }

    public void setArtistArtworkRepositoryBasePath(String artistArtworkRepositoryBasePath) {
        this.artistArtworkRepositoryBasePath = artistArtworkRepositoryBasePath;
    }

    public String getRecordLabelArtworkRepositoryBasePath() {
        return recordLabelArtworkRepositoryBasePath;
    }

    public void setRecordLabelArtworkRepositoryBasePath(String recordLabelArtworkRepositoryBasePath) {
        this.recordLabelArtworkRepositoryBasePath = recordLabelArtworkRepositoryBasePath;
    }

    public String getAlbumArtworkRepositoryBasePath() {
        return albumArtworkRepositoryBasePath;
    }

    public void setAlbumArtworkRepositoryBasePath(String albumArtworkRepositoryBasePath) {
        this.albumArtworkRepositoryBasePath = albumArtworkRepositoryBasePath;
    }

    public String getSongsPathAlias() {
        return songsPathAlias;
    }

    public void setSongsPathAlias(String songsPathAlias) {
        this.songsPathAlias = songsPathAlias;
    }

    public String getSongArtworksAlias() {
        return songArtworksAlias;
    }

    public void setSongArtworksAlias(String songArtworksAlias) {
        this.songArtworksAlias = songArtworksAlias;
    }

    public String getArtistaArtworksaAlias() {
        return artistaArtworksaAlias;
    }

    public void setArtistaArtworksaAlias(String artistaArtworksaAlias) {
        this.artistaArtworksaAlias = artistaArtworksaAlias;
    }

    public String getRecordlabelArtworkAlias() {
        return recordlabelArtworkAlias;
    }

    public void setRecordlabelArtworkAlias(String recordlabelArtworkAlias) {
        this.recordlabelArtworkAlias = recordlabelArtworkAlias;
    }

    public String getAlbumArtworksAlias() {
        return albumArtworksAlias;
    }

    public void setAlbumArtworksAlias(String albumArtworksAlias) {
        this.albumArtworksAlias = albumArtworksAlias;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getDot() {
        return dot;
    }

    public void setDot(String dot) {
        this.dot = dot;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getStationArtworkRepositoryBasePath() {
        return stationArtworkRepositoryBasePath;
    }

    public void setStationArtworkRepositoryBasePath(String stationArtworkRepositoryBasePath) {
        this.stationArtworkRepositoryBasePath = stationArtworkRepositoryBasePath;
    }

    public String getStationArtworkAlias() {
        return stationArtworkAlias;
    }

    public void setStationArtworkAlias(String stationArtworkAlias) {
        this.stationArtworkAlias = stationArtworkAlias;
    }

    public String getInitsongpath() {
        return initsongpath;
    }

    public void setInitsongpath(String initsongpath) {
        this.initsongpath = initsongpath;
    }

    public String getInitsongartworkpath() {
        return initsongartworkpath;
    }

    public void setInitsongartworkpath(String initsongartworkpath) {
        this.initsongartworkpath = initsongartworkpath;
    }

    public String getInitrecordlabelartworkpath() {
        return initrecordlabelartworkpath;
    }

    public void setInitrecordlabelartworkpath(String initrecordlabelartworkpath) {
        this.initrecordlabelartworkpath = initrecordlabelartworkpath;
    }

    public String getInitalbumartworkpath() {
        return initalbumartworkpath;
    }

    public void setInitalbumartworkpath(String initalbumartworkpath) {
        this.initalbumartworkpath = initalbumartworkpath;
    }

    public String getInitartistartworkpath() {
        return initartistartworkpath;
    }

    public void setInitartistartworkpath(String initartistartworkpath) {
        this.initartistartworkpath = initartistartworkpath;
    }

    public String getUserImageRepositoryBasePath() {
        return userImageRepositoryBasePath;
    }

    public void setUserImageRepositoryBasePath(String userImageRepositoryBasePath) {
        this.userImageRepositoryBasePath = userImageRepositoryBasePath;
    }

    public String getUserImageAlias() {
        return userImageAlias;
    }

    public void setUserImageAlias(String userImageAlias) {
        this.userImageAlias = userImageAlias;
    }
    //splits string into Map
    public Map<String, String> splitToMap(String in) {
        return Splitter.on(",").withKeyValueSeparator("=").split(in);
    }



}
