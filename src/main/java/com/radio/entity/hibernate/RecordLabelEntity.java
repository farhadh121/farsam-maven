package com.radio.entity.hibernate;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class RecordLabelEntity {
	
	private Long recordLabelID;
	private Timestamp version;
	private String name;
	private String logoPath;
	private Set<AlbumEntity> albums = new HashSet<AlbumEntity>();
	
	public Long getRecordLabelID() {
		return recordLabelID;
	}
	public void setRecordLabelID(Long recordLabelID) {
		this.recordLabelID = recordLabelID;
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
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public Set<AlbumEntity> getAlbums() {
		return albums;
	}
	public void setAlbums(Set<AlbumEntity> albums) {
		this.albums = albums;
	}
	public RecordLabelEntity() {
		
	}
    public RecordLabelEntity(RecordLabelEntity recordLabelEntity) {
        this.recordLabelID = recordLabelEntity.recordLabelID;
        this.version = recordLabelEntity.version;
        this.name = recordLabelEntity.name;
        this.logoPath = recordLabelEntity.logoPath;
        this.albums = recordLabelEntity.albums;
    }
}
