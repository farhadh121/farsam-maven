package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArtistEntity implements Serializable  {
	
	private Long artistID;
	private Timestamp version;
	private String artistName;
	private String artistInfo;
    private String artistArtworkPath;
	private Set<SongEntity> songs = new HashSet<SongEntity>();
	private Set<AlbumEntity> albums = new HashSet<AlbumEntity>();
    private Set<ArtistFeatureEntity> featureEntities;
	
	
	public Timestamp getVersion() {
		return version;
	}
	public void setVersion(Timestamp version) {
		this.version = version;
	}
	public Long getArtistID() {
		return artistID;
	}
	public void setArtistID(Long artistID) {
		this.artistID = artistID;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getArtistInfo() {
		return artistInfo;
	}
	public void setArtistInfo(String artistInfo) {
		this.artistInfo = artistInfo;
	}
	public Set<SongEntity> getSongs() {
		return songs;
	}
	public void setSongs(Set<SongEntity> songs) {
		this.songs = songs;
	}
	public Set<AlbumEntity> getAlbums() {
		return albums;
	}
	public void setAlbums(Set<AlbumEntity> albums) {
		this.albums = albums;
	}
    public String getArtistArtworkPath() {
        return artistArtworkPath;
    }
    public void setArtistArtworkPath(String artistArtworkPath) {
        this.artistArtworkPath = artistArtworkPath;
    }
    public Set<ArtistFeatureEntity> getFeatureEntities() {
        return featureEntities;
    }
    public void setFeatureEntities(Set<ArtistFeatureEntity> featureEntities) {
        this.featureEntities = featureEntities;
    }

    public ArtistEntity() {
	}

    public ArtistEntity( ArtistEntity entity ) {
        this.artistID = entity.artistID;
        this.version = entity.version;
        this.artistName = entity.artistName;
        this.artistInfo = entity.artistInfo;
        this.artistArtworkPath = entity.artistArtworkPath;
        this.songs = entity.songs;
        this.albums = entity.albums;
    }
}
