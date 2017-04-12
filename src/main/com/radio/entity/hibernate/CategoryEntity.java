package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

public class CategoryEntity implements Serializable {
	
	private Long categoryID;
	private Timestamp version;
	private String name;
	private Set<SongEntity> songs;
	
	public Set<SongEntity> getSongs() {
		return songs;
	}
	public void setSongs(Set<SongEntity> songs) {
		this.songs = songs;
	}
	public Long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
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
	public CategoryEntity() {
	}
	
}
