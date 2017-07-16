package com.radio.svc.dalc;

import com.radio.entity.hibernate.GenreEntity;
import com.radio.entity.hibernate.SongEntity;

import java.util.List;

/**
 * Created by mbani002 on 5/16/14.
 */
public interface IGenreDA extends IGenericDA<GenreEntity, Long> {

    /**
     * @param genreEntity  The genre entity which contains the name to search for
     * @return  returns the genre entity with the same name
     */
    public GenreEntity getGenreByName( GenreEntity genreEntity );

    /**
     * Returns a list of songs who has this specified genre
     * @param genreEntity   The specified genre entity
     * @return              A list of appropriate songs
     */
    public List<SongEntity> listSongsByGenreName( GenreEntity genreEntity );
}
