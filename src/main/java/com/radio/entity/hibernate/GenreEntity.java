package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class GenreEntity implements Serializable {
	
	private Long genreID;
	private Timestamp version;
	private String name;
	private Set<SongEntity> songs = new HashSet<SongEntity>();
	
	public Long getGenreID() {
		return genreID;
	}
	public void setGenreID(Long genreID) {
		this.genreID = genreID;
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
	public GenreEntity() {

	}

}
