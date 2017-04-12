package com.radio.svc.serviceinterface;

import com.radio.entity.hibernate.ArtistEntity;
import com.radio.svc.exceptions.*;
import org.apache.commons.fileupload.FileItem;

import java.util.List;
import java.util.Map;


public interface IArtistServiceProvider {
/**
 * We use this function for addition of new Artist into repository
 * TODO: For now we do not consider song-Artist table
 *
 * @param artistName        Name of the artist
 * @param artistInfo        Information of the Artist
 * @param features          features assigned to the artist entity

     * @throws com.radio.svc.exceptions.ArtistExistException     Throw this only when we have the Artist already in our system
     */
    public void addNewArtist( String artistName, String artistInfo, FileItem artistArtwork, Map<String, String> features) throws
            ArtistExistException,
            FileExistException;

    /**
     *
     * @param artistName            Name of the Artist
     * @param artistInfo            Artist Information
     * @param artistArtworkpath     Path to the Artist Art work
     * @param features              Features on artist
     * @throws ArtistExistException  Artist already Exist
     * @throws FileExistException    Art work with the same name exists
     * @throws FileNotExistsException    The file path does not exist.
     */


    public void addNewArtist( String artistName, String artistInfo, String artistArtworkpath, Map<String, String> features) throws
            ArtistExistException,
            FileExistException,
            FileNotExistsException;

    /**
     * returns a list of artists
     * @return  returns a list of all artists
     */
    public List<ArtistEntity> getAllArtists();


    /**
     * deletes and artist from the database and it's artwork from storage
     * @param artistName                name of the target artist
     * @throws ArtistNotExistException  throws when the artist with specified name does not exist
     * @throws FileNotExistsException   throws when the artwork for artist not exists
     */
    public void deleteArtist( String artistName ) throws
            ArtistNotExistException,
            FileNotExistsException;

    /**
     * edit artist information
     * @param artistId                  the artist id which we are going to search for
     * @param editArtistName            New name for artist( Null, if no new name )
     * @param editArtistInfo            New info for artist( Null, if no new info )
     * @param editArtistArtwork         New artwork file( Null, if no new artwork )
     * @return                          return the newly created artist
     * @throws ArtistNotExistException  Throws, if there is no artist with specified id
     * @throws FileNotExistsException   Throws, if there is no artwork already in the system
     * @throws FileExistException       Throws if new file name has interference with another artwork file name
     */
    /*
    public ArtistEntity editArtist( Long artistId ,String editArtistName, String editArtistInfo, FileItem editArtistArtwork ) throws
            ArtistNotExistException,
            FileNotExistsException,
            FileExistException;
    */

    /**
     * Removes an album entity from an artist
     * @param artistName                name of the target artist
     * @param albumName                 name of the target album
     * @throws AlbumNotExistException   throws if no album with albumName exists
     * @throws ArtistNotExistException  throws if no artist with artistName exists
     */
    public void removeAlbumFromArtist( String artistName, String albumName ) throws
            AlbumNotExistException,
            ArtistNotExistException;

    /**
     * returns the artist entity by artist name
     * @param artistName                Name of the target artist
     * @return                          Returns an artist entity representing the specified artist
     * @throws ArtistNotExistException  Throws when there is no artist with the specified name
     */
    public ArtistEntity getArtist( String artistName ) throws
            ArtistNotExistException;

    /**
     * returns the new name
     * @param artistID                  ID of the target artist to change the name
     * @param artistName                New name for the artist
     * @return                          Returns the new name on success
     * @throws ArtistNotExistException  Throws when the artist with the specified name does not exist
     */
    public String changeArtistName( Long artistID, String artistName ) throws
            ArtistNotExistException;

    /**
     * returns the new info
     * @param artistID                  ID of the target artist to change the info
     * @param artistInfo                New info for the artist
     * @return                          Returns the new info on success
     * @throws ArtistNotExistException  Throws when the artist with the specified name does not exist
     */
    public String changeArtistInfo( Long artistID, String artistInfo ) throws
            ArtistNotExistException;

}
