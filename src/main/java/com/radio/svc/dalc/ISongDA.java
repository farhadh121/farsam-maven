package com.radio.svc.dalc;

import com.radio.entity.hibernate.GenreEntity;
import com.radio.entity.hibernate.SongEntity;

import java.util.List;

public interface ISongDA extends IGenericDA<SongEntity, Long> {

    /**
     * This function would reaturn a song entity, if it could find a song
     * which has the same name with same artists.
     * @param songEntity    Contains information of the song we are going to search for
     * @return  Song entity if it found any
     */
    public SongEntity getSongBySongNameAndArtistNames( SongEntity songEntity );


    /**
     * Get all songs whose name has partially this string
     * @param partialName   the partial name that we are looking in the song name
     * @return              A list of songs whose names are satisfying what we said above
     */
    public List<SongEntity> getSongsByPartialName( String partialName );


    /**
     * search for a song with this name inside the database
     * @param songEntity    The target song entity
     * @return              Returns a song entity object
     */
    public SongEntity getSongByName( SongEntity songEntity );

    /**
     *
     * @param songEntity
     * @return
     */
    public SongEntity getSongByID (SongEntity songEntity);

    /**
     *
     * @param songEntity
     * @return
     */
    public SongEntity getSongByLyrics (SongEntity songEntity);

    /**
     *
     * @param partialName
     * @return     returns song by lyrics from search.
     */
    public List<SongEntity> getSongByLyricsPartialName (String partialName);

    /**
     *
     * @return   returns 10 most liked songs
     */
    public List<SongEntity> getTopSongs();
    
    /**
     * 
     * @param songEntity 
     * @return songs that are close to cenrtain bitrate
     */
    public SongEntity getSongsByBitrate(SongEntity songEntity);

}

