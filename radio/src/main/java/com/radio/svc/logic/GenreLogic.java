package com.radio.svc.logic;

import com.radio.entity.hibernate.GenreEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.dalc.IGenreDA;
import com.radio.svc.exceptions.ArtistExistException;
import com.radio.svc.exceptions.GenreExistException;
import com.radio.svc.exceptions.GenreNotExistsException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import java.util.List;

/**
 * Created by mbani002 on 5/16/14.
 */
public class GenreLogic {

    public Log logger = new Log4JLogger(this.getClass().getName());

    ////////////////////////////////////////////////

    private IGenreDA genreDA;

    public IGenreDA getGenreDA() {
        return genreDA;
    }

    public void setGenreDA(IGenreDA genreDA) {
        this.genreDA = genreDA;
    }

    ////////////////////////////////////////////////

    public void addNewGenre( GenreEntity genreEntity) throws GenreExistException {

        // First we check to see if we have the same Genre with the same name
        GenreEntity genre = genreDA.getGenreByName(genreEntity);
        if( genre != null )
            throw new GenreExistException( "Genre already Exists!" );

        // Adding the genre to the system
        genreDA.insert( genreEntity );

    }

    public List<GenreEntity> getAllGenres(){

        // calls genreDA and gets all genres
        return genreDA.get();

    }

    public void deleteGenre( GenreEntity genreEntity ) throws GenreNotExistsException{

        // first check whether the genre exists or not
        GenreEntity temp = genreDA.getGenreByName(genreEntity);
        if( temp == null )
            throw new GenreNotExistsException( "Genre with name " + genreEntity.getName() + " does not exist." );

        genreDA.delete(temp);

    }

    public GenreEntity getGenreByName( GenreEntity genreEntity ) throws
            GenreNotExistsException{

        GenreEntity realGenreEntity = genreDA.getGenreByName(genreEntity);
        if( realGenreEntity == null )
            throw new GenreNotExistsException( "Genre with name " + genreEntity.getName() + " does not exist in the system!" );

        return realGenreEntity;

    }

    public GenreEntity modifyGenre( GenreEntity genreEntity ) throws
            GenreNotExistsException{

        // check existence of genre with specified id
        GenreEntity realGenreEntity = genreDA.get( genreEntity.getGenreID() );

        if( realGenreEntity == null )
            throw new GenreNotExistsException( "There is no genre in database with id " + genreEntity.getGenreID() );

        // Change content
        if( genreEntity.getName() != null )
            realGenreEntity.setName( genreEntity.getName() );

        // Updating genre entity inside database
        realGenreEntity = genreDA.update( realGenreEntity );

        return realGenreEntity;

    }

    public List<SongEntity> listSongsByGenreName(GenreEntity genreEntity) throws
    GenreNotExistsException{

        // check existence of genre with specified name
        GenreEntity realGenreEntity = genreDA.getGenreByName(genreEntity);

        if( realGenreEntity == null )
            throw new GenreNotExistsException( "There is no genre in database with name " + genreEntity.getName() );

        return genreDA.listSongsByGenreName(realGenreEntity);

    }
}
