package com.radio.svc.facade;

import com.radio.entity.hibernate.*;
import com.radio.svc.exceptions.*;
import com.radio.svc.logic.SongLogic;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import com.radio.svc.songengine.ISongSelector;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import java.util.*;

public class SongFacede implements ISongServiceProvider {

    public Log logger = new Log4JLogger(this.getClass().getName());

    //////////////////////////////////////////

    private SongLogic songLogic;

    public SongLogic getSongLogic() {
        return songLogic;
    }

    public void setSongLogic(SongLogic songLogic) {
        this.songLogic = songLogic;
    }

    //////////////////////////////////////////

   // @Override
    public void addNewSong(String songName, Set<String> songArtists, String lyric, String songGenre, String albumName, FileItem songFile, FileItem artworkFile, Map<String, String> features) throws
            SongExistException,
            ArtistNotExistException,
            FileExistException,
            AlbumNotExistException,
            GenreNotExistsException{

        // Creating song entity
        SongEntity songEntity = new SongEntity();
        songEntity.setName(songName);
        songEntity.setLyric(lyric);

        // Creating genre Entity
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName( songGenre );

        Set<SongEntity> songEntities = new HashSet<SongEntity>();
        songEntities.add(songEntity);

        Set<GenreEntity> genreEntities = new HashSet<GenreEntity>();
        genreEntities.add(genreEntity);
        songEntity.setGenres(genreEntities);
        genreEntity.setSongs(songEntities);

        // Creating album entity
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName(albumName);

        // Creating artist entities
        Iterator itr = songArtists.iterator();
        Set<ArtistEntity> artists = new HashSet<ArtistEntity>();
        while( itr.hasNext() ){
            String artistName = (String)itr.next();
            ArtistEntity artistEntity = new ArtistEntity();
            artistEntity.setArtistName(artistName);
            artists.add(artistEntity);
        }
        songEntity.setArtists(artists);

        Set<SongFeatureEntity> songFeatureEntitySet = new HashSet<SongFeatureEntity>();

        for( Map.Entry<String, String> entry : features.entrySet() ){
            SongFeatureEntity songFeatureEntity = new SongFeatureEntity();
            songFeatureEntity.setFeatureKey( entry.getKey() );
            songFeatureEntity.setFeatureValue( entry.getValue() );
            songFeatureEntitySet.add( songFeatureEntity );
        }

        songLogic.addNewSong(songEntity, songFile, artworkFile, albumEntity, songFeatureEntitySet);

    }

    public void addNewSong(String songName, Set<String> songArtists, String lyric, String songGenre, String albumName, String songFile, String artworkFile, Map<String, String> features) throws
            SongExistException,
            ArtistNotExistException,
            FileExistException,
            FileNotExistsException,
            AlbumNotExistException,
            GenreNotExistsException{

        // Creating song entity
        SongEntity songEntity = new SongEntity();
        songEntity.setName(songName);
        songEntity.setLyric(lyric);

        // Creating genre Entity
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName( songGenre );

        Set<SongEntity> songEntities = new HashSet<SongEntity>();
        songEntities.add(songEntity);

        Set<GenreEntity> genreEntities = new HashSet<GenreEntity>();
        genreEntities.add(genreEntity);
        songEntity.setGenres(genreEntities);
        genreEntity.setSongs(songEntities);

        // Creating album entity
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName(albumName);

        // Creating artist entities
        Iterator itr = songArtists.iterator();
        Set<ArtistEntity> artists = new HashSet<ArtistEntity>();
        while( itr.hasNext() ){
            String artistName = (String)itr.next();
            ArtistEntity artistEntity = new ArtistEntity();
            artistEntity.setArtistName(artistName);
            artists.add(artistEntity);
        }
        songEntity.setArtists(artists);

        Set<SongFeatureEntity> songFeatureEntitySet = new HashSet<SongFeatureEntity>();

        for( Map.Entry<String, String> entry : features.entrySet() ){
            SongFeatureEntity songFeatureEntity = new SongFeatureEntity();
            songFeatureEntity.setFeatureKey( entry.getKey() );
            songFeatureEntity.setFeatureValue( entry.getValue() );
            songFeatureEntitySet.add( songFeatureEntity );
        }

        songLogic.addNewSong(songEntity, songFile, artworkFile, albumEntity, songFeatureEntitySet);


    }


    //@Override
    public List<SongEntity> getAllSongs() {

        return songLogic.getAllSongs();

    }

    //@Override
    public List<ArtistEntity> getSongArtists(Long songId) throws SongNotExistsException {

        SongEntity songEntity = new SongEntity();
        songEntity.setSongID( songId );

        return songLogic.getSongArtists(songEntity);

    }

    //@Override
    public AlbumEntity getSongAlbum(Long songId) throws SongNotExistsException {

        SongEntity songEntity = new SongEntity();
        songEntity.setSongID( songId );

        return songLogic.getSongAlbum(songEntity);

    }

    //@Override
    public List<GenreEntity> getSongGenre(Long songId) throws SongNotExistsException {

        SongEntity songEntity = new SongEntity();
        songEntity.setSongID( songId );

        return songLogic.getSongGenre(songEntity);

    }

   // @Override
    public void deleteSong(Long songId) throws
            SongNotExistsException,
            FileNotExistsException {

        SongEntity songEntity = new SongEntity();
        songEntity.setSongID( songId );

        songLogic.deleteSong( songEntity );

    }

   // @Override
    public void editSong (Long oldSongId, String songName, Set<String> songArtists, String lyric, String songGenre, String albumName, FileItem songFile, FileItem artworkFile) throws
            SongNotExistsException,
            FileNotExistsException,
            SongExistException,
            ArtistNotExistException,
            FileExistException,
            AlbumNotExistException,
            GenreNotExistsException{

        deleteSong(oldSongId);
        //addNewSong(songName, songArtists, lyric, songGenre, albumName, songFile, artworkFile);
    }

   // @Override
    public String getNextSong(Long stationID) throws
            StationNotExistsException,
            Exception {

        StationEntity stationEntity = new StationEntity();
        stationEntity.setStationID( stationID );

        return songLogic.getNextSong( stationEntity );

    }


  //  @Override
    public SongEntity getSongByName(String songName) throws
            SongNotExistsException {

        SongEntity temp = new SongEntity();
        temp.setName( songName );

        return songLogic.getSongByName( temp );

    }

    //@Override
    public SongEntity getSongByID(Long songId) throws SongNotExistsException {
        SongEntity temp = new SongEntity();
        temp.setSongID( songId );

        return songLogic.getSongByID( temp );

    }

  //  @Override
    public String changeSongName(Long songID, String songName) throws
            SongNotExistsException {

        SongEntity temp = new SongEntity();
        temp.setSongID(songID);
        return songLogic.changeSongName(temp, songName);

    }

   // @Override
    public String changeSongAlbum(Long songID, String albumName) throws
            SongNotExistsException,
            AlbumNotExistException {

        SongEntity temp = new SongEntity();
        AlbumEntity tempAlbum = new AlbumEntity();
        tempAlbum.setName( albumName );
        temp.setSongID( songID );

        return songLogic.changeSongAlbum( temp, tempAlbum );

    }

   // @Override
    public String changeSongLyric(Long songID, String lyric) throws
            SongNotExistsException {

        SongEntity temp = new SongEntity();
        temp.setSongID( songID );

        return songLogic.changeSongLyric( temp, lyric );

    }

  //  @Override
    public String changeSongGenre(Long songID, String genre) throws
            SongNotExistsException,
            GenreNotExistsException {

        SongEntity temp = new SongEntity();
        temp.setSongID( songID );

        GenreEntity tempGenre = new GenreEntity();
        tempGenre.setName( genre );

        return songLogic.changeSongGenre( temp, tempGenre );

    }

  //  @Override
    public int getNumberOfLikes (Long songID) throws
            SongNotExistsException{
        SongEntity temp = new SongEntity();
        temp.setSongID( songID );
        return songLogic.getNumberOfLikes(temp);

    }

    //@Override
    public int getNumberOfDislikes(Long songID) throws
            SongNotExistsException{
        SongEntity temp = new SongEntity();
        temp.setSongID( songID );
        return songLogic.getNumberOfDislikes(temp);

    }

    //@Override
    public List<SongEntity> getTopSongs() throws
            SongNotExistsException{
        return songLogic.getTopSongs();
    }
    
   // @Override
    public SongEntity getSongsByBitrate(int bitRate) throws
            SongNotExistsException{
        SongEntity temp = new SongEntity();
        temp.setBitrate(bitRate );

        return songLogic.getSongsByBitrate( temp );
    } 

}


