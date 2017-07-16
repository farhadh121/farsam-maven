package com.radio.svc.serviceinterface;

import com.radio.entity.hibernate.AlbumEntity;
import com.radio.entity.hibernate.ArtistEntity;
import com.radio.entity.hibernate.GenreEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.exceptions.*;
import org.apache.commons.fileupload.FileItem;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ISongServiceProvider {

    /**
     * We use this function for addition of song into repository
     * TODO: bitrate is going to be found automatically.
     * TODO: Categories is not considered yet. To be considered in the future.
     * TODO: Genres is not considered yet. To be considered in the future.
     *
     * @param songName          Name of this new song
     * @param songArtists       List of artists who have participated in this song
     * @param lyric             The whole lyric of this song
     * @param songFile          File which contains the whole song
     * @param artworkFile       File which contains the whole artwork
     * @param songGenre         Genre which was selected for the target song
     * @param albumName         Album which was selected for the target song
     * @param features          features assigned to the song
     * @throws SongExistException     Throw this only when we have the song already in our system
     * @throws AlbumNotExistException   Throw this only when we don't have the target album
     * @throws GenreNotExistsException  Throw this only when we don't have the genre
     * @throws ArtistNotExistException  Throw this only when the target artist does not exist
     * @throws FileExistException       Throw this only when the file regarding song or it's artwork exist
     */
	public void addNewSong( String songName, Set<String> songArtists, String lyric, String songGenre, String albumName, FileItem songFile, FileItem artworkFile, Map<String, String> features ) throws
            SongExistException,
            ArtistNotExistException,
            FileExistException,
            AlbumNotExistException,
            GenreNotExistsException;

    /**
     * We use this function for addition of song into repository
     * TODO: bitrate is going to be found automatically.
     * TODO: Categories is not considered yet. To be considered in the future.
     * TODO: Genres is not considered yet. To be considered in the future.
     *
     * @param songName          Name of this new song
     * @param songArtists       List of artists who have participated in this song
     * @param lyric             The whole lyric of this song
     * @param songFile          File which contains the whole song
     * @param artworkFile       File which contains the whole artwork
     * @param songGenre         Genre which was selected for the target song
     * @param albumName         Album which was selected for the target song
     * @param features          features assigned to the song
     * @throws SongExistException     Throw this only when we have the song already in our system
     * @throws AlbumNotExistException   Throw this only when we don't have the target album
     * @throws GenreNotExistsException  Throw this only when we don't have the genre
     * @throws ArtistNotExistException  Throw this only when the target artist does not exist
     * @throws FileExistException       Throw this only when the file regarding song or it's artwork exist
     * @throws FileNotExistsException   Throw this only when the file regarding song or its artwork does not exist.
     */
    public void addNewSong(String songName, Set<String> songArtists, String lyric, String songGenre, String albumName, String songFile, String artworkFile, Map<String, String> features) throws
            SongExistException,
            ArtistNotExistException,
            FileExistException,
            FileNotExistsException,
            AlbumNotExistException,
            GenreNotExistsException;


    /**
     * returns all song entities
     * @return  all song entities
     */
    public List<SongEntity> getAllSongs( );

    /**
     * Get artists of a song
     * @param songId                    Id of the target song
     * @return                          list of artist entities
     * @throws SongNotExistsException   throws when there is not song with such id
     */
    public List<ArtistEntity> getSongArtists( Long songId ) throws
            SongNotExistsException;

    /**
     * Get album of the song
     * @param songId                    Id of the target song
     * @return                          list of artist entities
     * @throws SongNotExistsException   throws when there is not song with such id
     */
    public AlbumEntity getSongAlbum( Long songId ) throws
            SongNotExistsException;

    /**
     * Get Genres of the song
     * @param songId                    Id of the target song
     * @return                          Genre entities
     * @throws SongNotExistsException   throws when there is not song with such id
     */
    public List<GenreEntity> getSongGenre( Long songId ) throws
            SongNotExistsException;

    /**
     * Delete song
     * @param songId                    Id of the target song
     * @throws SongNotExistsException   throws when there is no song with such id
     * @throws FileNotExistsException   throws when songs file not exists
     */
    public void deleteSong( Long songId ) throws
            SongNotExistsException,
            FileNotExistsException;

    /**
     * Edit song
     * @param oldSongId         Id of the target song
     * @param songName          Name of this new song
     * @param songArtists       List of artists who have participated in this song
     * @param lyric             The whole lyric of this song
     * @param songFile          File which contains the whole song
     * @param artworkFile       File which contains the whole artwork
     * @param songGenre         Genre which was selected for the target song
     * @param albumName         Album which was selected for the target song
     * @throws SongExistException     Throw this only when we have the new song already in our system
     * @throws AlbumNotExistException   Throw this only when we don't have the new target album
     * @throws GenreNotExistsException  Throw this only when we don't have the new genre
     * @throws ArtistNotExistException  Throw this only when the new artist does not exist
     * @throws FileExistException       Throw this only when the file regarding song or it's artwork exist
     * @throws SongNotExistsException   throws when there is no song with target id
     * @throws FileNotExistsException   throws when old songs file not exists
     */
    public void editSong (Long oldSongId, String songName, Set<String> songArtists, String lyric, String songGenre, String albumName, FileItem songFile, FileItem artworkFile) throws
            SongNotExistsException,
            FileNotExistsException,
            SongExistException,
            ArtistNotExistException,
            FileExistException,
            AlbumNotExistException,
            GenreNotExistsException;

    /**
     * Reaturns a link of a next song to the user who calls this function
     * @param stationID         ID of the station which we wanted to get a song related to it
     * @throws StationNotExistsException    Throws when there is no such an station with this ID
     * @throws Exception                    A general purpose exception
     */
    public String getNextSong( Long stationID ) throws
            StationNotExistsException,
            Exception;


    /**
     * Get song entity by song name
     * @param songName          A string of song name as input
     * @return                  returns the song entity with the specified song name
     * @throws SongNotExistsException       Thrown when
     */
    public SongEntity getSongByName( String songName ) throws
            SongNotExistsException;

    /**
     * Get song entity by ID
     * @param songId
     * @return
     * @throws SongNotExistsException
     */
    public SongEntity getSongByID ( Long songId) throws
            SongNotExistsException;

    /**
     * Change the name of the song with specified if to the new one
     * @param songID            ID of the song
     * @param songName          New name for the song
     * @return                  Returns the new name of the song
     * @throws SongNotExistsException       throws when there is no song with such a name
     */
    public String changeSongName( Long songID, String songName ) throws
            SongNotExistsException;


    /**
     * change the album name to the new one
     * @param songID                    ID of the target song
     * @param albumName                 new name for the album of the target song
     * @return                          returns the name of the new album
     * @throws SongNotExistsException   throws if there is no such a song with specified ID
     * @throws AlbumNotExistException   throws when there is no album with the specified name
     */
    public String changeSongAlbum( Long songID, String albumName ) throws
            SongNotExistsException,
            AlbumNotExistException;

    /**
     * change the lyric of the song to the new one
     * @param songID                    ID of the target song
     * @param lyric                     new lyric for the target song
     * @return                          returns the lyric
     * @throws SongNotExistsException   throws when there is no song with the specified ID
     */
    public String changeSongLyric( Long songID, String lyric ) throws
            SongNotExistsException;


    /**
     * Changes the genre assigned to one genre
     * @param songID                    ID of the target song
     * @param genre                     new genre for the target song
     * @return                          Returns the name of the genre
     * @throws SongNotExistsException   throws when there is no song with the specified ID
     * @throws GenreNotExistsException  throws when there is no genre with the specified name
     */
    public String changeSongGenre( Long songID, String genre ) throws
            SongNotExistsException,
            GenreNotExistsException;


    public int getNumberOfLikes (Long songID) throws
            SongNotExistsException;

    public int getNumberOfDislikes(Long songID) throws
            SongNotExistsException;
    /**
     * get most liked songs limit to 10
     * @return
     * @throws SongNotExistsException 
     */
    public List<SongEntity> getTopSongs() throws
            SongNotExistsException;
    /**
     * returns songs according to a bitrate
     * @param bitRate
     * @return
     * @throws SongNotExistsException 
     */
    public SongEntity getSongsByBitrate(int bitRate) throws
            SongNotExistsException;

}







