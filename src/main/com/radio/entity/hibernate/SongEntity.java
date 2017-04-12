package com.radio.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SongEntity implements Serializable  {

	private Long songID;
	private Timestamp version;
	private String name;
	private Set<ArtistEntity> artists = new HashSet<ArtistEntity>();
	private String mp3Path;
	private String artworkPath;
	private Set<CategoryEntity> categories = new HashSet<CategoryEntity>(); // TODO: not included yet. To be considered for future
	private Integer duration;
	private String lyric;		
	private Set<GenreEntity> genres =  new HashSet<GenreEntity>(); // TODO: not included yet. To be considered for future.
    private Integer bitrate;
    private AlbumEntity album;
    private Set<SongFeatureEntity> featureEntities;
    private Set<UserEntity> likers;

    public Set<UserEntity> getDislikers() {
        return dislikers;
    }

    public void setDislikers(Set<UserEntity> dislikers) {
        this.dislikers = dislikers;
    }

    private Set<UserEntity> dislikers;

    public Set<UserEntity> getLikers() {
        return likers;
    }

    public void setLikers(Set<UserEntity> likers) {
        this.likers = likers;
    }

    public Set<GenreEntity> getGenres() {
		return genres;
	}
	public void setGenres(Set<GenreEntity> genres) {
		this.genres = genres;
	}
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getMp3Path() {
		return mp3Path;
	}
	public void setMp3Path(String mp3Path) {
		this.mp3Path = mp3Path;
	}
	public String getArtworkPath() {
		return artworkPath;
	}
	public void setImagePath(String artworkPath) {
		this.artworkPath = artworkPath;
	}
	public Timestamp getVersion() {
		return version;
	}
	public void setVersion(Timestamp version) {
		this.version = version;
	}
	public Long getSongID() {
		return songID;
	}
	public void setSongID(Long songID) {
		this.songID = songID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<ArtistEntity> getArtists() {
		return artists;
	}
	public void setArtists(Set<ArtistEntity> artists) {
		this.artists = artists;
	}
	public Set<CategoryEntity> getCategories() {
		return categories;
	}
	public void setCategories(Set<CategoryEntity> categories) {
		this.categories = categories;
	}
	public void setArtworkPath(String artworkPath) {
		this.artworkPath = artworkPath;
	}
    public Integer getBitrate() {
        return bitrate;
    }
    public void setBitrate(Integer bitrate) {
        this.bitrate = bitrate;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }

    public SongEntity() {
		
	}

    public Set<SongFeatureEntity> getFeatureEntities() {
        return featureEntities;
    }

    public void setFeatureEntities(Set<SongFeatureEntity> featureEntities) {
        this.featureEntities = featureEntities;
    }

    ///////////////////////////////////////////////////////////////
    // Helper Functions

    /**
     *
     *
     * @param artistName    Name of the target artist to find
     * @return
     */

    public boolean hasArtist( String artistName ){

        boolean result = false;

        Iterator itr = this.artists.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            if( artistEntity.getArtistName().equals(artistName) ){
                result = true;
                break;
            }
        }

        return result;

    }

    public boolean hasGenre( String genreName){

        boolean result = false;

        Iterator itr = this.genres.iterator();
        while( itr.hasNext() ){
            GenreEntity genreEntity = (GenreEntity)itr.next();
            if( genreEntity.getName().equals(genreName) ){
                result = true;
                break;
            }
        }

        return result;


    }

}
