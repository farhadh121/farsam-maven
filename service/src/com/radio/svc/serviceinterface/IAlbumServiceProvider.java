package com.radio.svc.serviceinterface;

import com.radio.entity.hibernate.AlbumEntity;
import com.radio.entity.hibernate.ArtistEntity;
import com.radio.entity.hibernate.RecordLabelEntity;
import com.radio.svc.exceptions.*;
import org.apache.commons.fileupload.FileItem;
import org.springframework.social.facebook.api.Album;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/27/14
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IAlbumServiceProvider extends Serializable {


    /**
     * Adds new album into the system
     * @param name                          name of the target album
     * @param releaseDate                   release date of the album
     * @param recordLabelName               record label name of the album
     * @param artistName                    name of the artists who ownes the album
     * @param albumArtwork                  artwork related to this album
     * @param features                      Map of features assigned to each album
     * @throws AlbumExistsException         throws when the album already exists in the system
     * @throws ArtistNotExistException      throws when one of the mentioned artists do not exists in the system
     * @throws RecordLabelNotExistsException    throws when the record label does not exist
     * @throws FileExistException           throws when the file does exist in the system
     */
    public void addNewAlbum( String name, Date releaseDate, String recordLabelName, List<String> artistName, FileItem albumArtwork, Map<String, String> features) throws
            AlbumExistsException,
            RecordLabelNotExistsException,
            ArtistNotExistException,
            FileExistException;

    /**
     * Adds new album into the system
     * @param name                          name of the target album
     * @param releaseDate                   release date of the album
     * @param recordLabelName               record label name of the album
     * @param artistName                    name of the artists who ownes the album
     * @param albumArtworkPath              artwork file related to this album
     * @param features                      Map of features assigned to each album
     * @throws AlbumExistsException         throws when the album already exists in the system
     * @throws ArtistNotExistException      throws when one of the mentioned artists do not exists in the system
     * @throws RecordLabelNotExistsException    throws when the record label does not exist
     * @throws FileExistException           throws when the file does exist in the system
     * @throws FileNotExistsException       throws when the file does not exist in the system
     */

    public void addNewAlbum(String name, Date releaseDate, String recordLabelName, List<String> artistName, String albumArtworkPath, Map<String, String> features)throws
            AlbumExistsException,
            RecordLabelNotExistsException,
            ArtistNotExistException,
            FileExistException,
            FileNotExistsException;

    /**
     * returns all albums
     * @return  list of all albums
     */
    public List<AlbumEntity> getAllAlbums();

    /**
     * delete an album from data base
     * @param name                      Name of the target album
     * @throws AlbumNotExistException   throws when the album does not exist in the system
     * @throws FileNotExistsException   throws when the artwork file does not exist in the system
     * @throws SongsListNotEmptyException   throws when the list of all songs is not empty
     * @throws ArtistNotExistException   comes from artistLogic.removeAlbumFromArtist()
     */
    public void deleteAlbum( String name ) throws
            AlbumNotExistException,
            FileNotExistsException,
            SongsListNotEmptyException,
            ArtistNotExistException;

    /**
     * Returns a list of all artists belong to an album
     * @param name                      name of the target album
     * @throws AlbumNotExistException   Throws when the album does not exist in the system
     * @return  list of all artists of an album
     */
    public List<ArtistEntity> getAllArtists( String name ) throws
            AlbumNotExistException;

    /**
     * Returns the record label belongs to the album
     * @param name                      name of the target album
     * @return                          returns the object representing the record label of that album
     * @throws AlbumNotExistException   throws when the album does not exist in the system
     */
    public RecordLabelEntity getRecordLabel( String name ) throws
            AlbumNotExistException;


    /**
     * changes the name of the current album with the id
     * @param id                        Id of the target album
     * @param name                      new name to be assigned to the album
     * @return                          returns the new name which has been assigned
     * @throws AlbumNotExistException   Throws when the album does not exist in the system
     */
    public String changeAlbumName( Long id, String name ) throws
            AlbumNotExistException;

    /**
     * change the record label of the current album with id
     * @param id                        Id of the target album
     * @param name                      new record label name to be assigned to the album
     * @return                          returns the record label which has been assigned
     * @throws AlbumNotExistException   Throws when the album does not exist in the system
     * @throws RecordLabelNotExistsException    Throws when the record label does not exist in the system
     */
    public String changeAlbumRecordLabel( Long id, String name ) throws
            AlbumNotExistException,
            RecordLabelNotExistsException;

    /**
     * Change the release date of the album
     * @param id                        Id of the target album
     * @param date                      New date to be assigned to the album
     * @return                          returns the date which has been assigned, as string
     * @throws AlbumNotExistException   Throws when the album does not exist in the system
     * @throws DateFormatWrongException Throws when date format is wrong
     */
    public String changeAlbumReleaseDate( Long id, String date ) throws
            AlbumNotExistException,
            DateFormatWrongException;

    /**
     * Get the album by the specified name
     * @param albumName                 name of the target album
     * @return                          returns the album entity
     * @throws AlbumNotExistException   Throws when the album does not exist with the specified name
     */
    public AlbumEntity getAlbumByName( String albumName ) throws
            AlbumNotExistException;

}
