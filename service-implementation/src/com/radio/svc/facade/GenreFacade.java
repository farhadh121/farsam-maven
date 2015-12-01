package com.radio.svc.facade;

import com.radio.entity.hibernate.GenreEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.exceptions.GenreExistException;
import com.radio.svc.exceptions.GenreNotExistsException;
import com.radio.svc.logic.GenreLogic;
import com.radio.svc.serviceinterface.IGenreServiceProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/22/14
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenreFacade implements IGenreServiceProvider {

    public Log logger = new Log4JLogger(this.getClass().getName());

    ///////////////////////////////////////////////////////////////

    GenreLogic genreLogic;

    public GenreLogic getGenreLogic() {
        return genreLogic;
    }

    public void setGenreLogic(GenreLogic genreLogic) {
        this.genreLogic = genreLogic;
    }

    //////////////////////////////////////////////////////////////////////

    @Override
    public void addNewGenre(String name) throws GenreExistException {

        // Creating Genre entity
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName(name);

        // insert new genre
        genreLogic.addNewGenre(genreEntity);

    }

    @Override
    public List<GenreEntity> getAllGenres() {

        // call genre logic and return all genres
        return genreLogic.getAllGenres();

    }

    @Override
    public void deleteGenre(String genreName) throws GenreNotExistsException {

        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName(genreName);

        genreLogic.deleteGenre(genreEntity);

    }

    @Override
    public GenreEntity getGenreByName(String genreName) throws GenreNotExistsException {

        // Create temporary object
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName( genreName );

        return genreLogic.getGenreByName(genreEntity);

    }

    @Override
    public GenreEntity modifyGenre(Long genreId, String editGenreName) throws GenreNotExistsException {

        // Create temporary genre entity
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setGenreID(genreId);
        genreEntity.setName(editGenreName);

        return genreLogic.modifyGenre( genreEntity );

    }

    @Override
    public List<SongEntity> listSongsByGenreName( String genreName ) throws
            GenreNotExistsException{
        GenreEntity genreEntity =  new GenreEntity();
        genreEntity.setName(genreName);
        return genreLogic.listSongsByGenreName (genreEntity);
    }
}
