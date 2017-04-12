package com.radio.svc.serviceinterface;

import com.radio.entity.hibernate.GenreEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.exceptions.GenreExistException;
import com.radio.svc.exceptions.GenreNotExistsException;

import java.util.List;

/**
 * Created by mbani002 on 5/16/14.
 */
public interface IGenreServiceProvider {
    /**
     * We use this function for addition of new Genre into repository
     *
     * @param name        Name of the genre
     * @throws com.radio.svc.exceptions.GenreExistException     Throw this only when we have the Genre already in our system
     */
    public void addNewGenre(String name) throws GenreExistException;

    /**
     * returns a list of all genres in the system
     * @return returns a list of all genres in the system
     */
    public List<GenreEntity> getAllGenres();

    /**
     * delete one genre from the database
     * @param genreName name of the genre to be deleted
     * @throws GenreNotExistsException  Throws this, when there is no genre with the specified name
     */
    public void deleteGenre( String genreName ) throws GenreNotExistsException;

    /**
     * Searcg for a genre with a specific name and returns it
     * @param genreName                 name of the target genre
     * @return                          returns the genre entity, if anything has been found
     * @throws GenreNotExistsException  throws when there is no genre with that specific name
     */
    public GenreEntity getGenreByName( String genreName ) throws
            GenreNotExistsException;

    /**
     * Modify the content of an existing genre
     * @param genreId                       ID of the genre we are going to modify
     * @param editGenreName                 New name for the genre( Null if no modification )
     * @return                              Return the new modified genre
     * @throws GenreNotExistsException      throws when there is no genre with the specified ID
     */
    public GenreEntity modifyGenre( Long genreId, String editGenreName ) throws
            GenreNotExistsException;


    /**
     *
     * @param genreName
     * @return
     * @throws GenreNotExistsException
     */
    public List<SongEntity> listSongsByGenreName( String genreName ) throws
        GenreNotExistsException;
}
