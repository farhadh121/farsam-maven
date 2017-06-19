package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class AlbumEntity implements Serializable {
	
	private Long albumID;
	private Timestamp version;
	private String name;
	private Set<SongEntity> songs = new HashSet<SongEntity>();
	private Date releaseDate;
	private Set<ArtistEntity> artists = new HashSet<ArtistEntity>();
	private RecordLabelEntity recordLabelEntity;
	private String albumArtworkPath;
    private Set<AlbumFeatureEntity> featureEntities;
	
	public Long getAlbumID() {
		return albumID;
	}

	public void setAlbumID(Long albumID) {
		this.albumID = albumID;
	}

	public Timestamp getVersion() {
		return version;
	}



	public void setVersion(Timestamp version) {
		this.version = version;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Set<SongEntity> getSongs() {
		return songs;
	}



	public void setSongs(Set<SongEntity> songs) {
		this.songs = songs;
	}



	public Date getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}



	public Set<ArtistEntity> getArtists() {
		return artists;
	}



	public void setArtists(Set<ArtistEntity> artists) {
		this.artists = artists;
	}


	public String getAlbumArtworkPath() {
		return albumArtworkPath;
	}



	public void setAlbumArtworkPath(String albumArtworkPath) {
		this.albumArtworkPath = albumArtworkPath;
	}

    public Set<AlbumFeatureEntity> getFeatureEntities() {
        return featureEntities;
    }

    public void setFeatureEntities(Set<AlbumFeatureEntity> featureEntities) {
        this.featureEntities = featureEntities;
    }

    public AlbumEntity() {
		
	}

	/**
	 * @return the recordLabelEntity
	 */
	public RecordLabelEntity getRecordLabelEntity() {
		return recordLabelEntity;
	}

	/**
	 * @param recordLabelEntity the recordLabelEntity to set
	 */
	public void setRecordLabelEntity(RecordLabelEntity recordLabelEntity) {
		this.recordLabelEntity =recordLabelEntity;
	}
	
	
	
}
