package com.radio.svc.logic;

import com.radio.entity.hibernate.*;
import com.radio.svc.common.CommonFile;
import com.radio.svc.common.ImageFormat;
import com.radio.svc.common.SongFormat;
import com.radio.svc.dalc.*;
import com.radio.svc.dalc.hibernate.GenreDA;
import com.radio.svc.exceptions.*;
import com.radio.svc.songengine.ISongSelector;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.social.facebook.api.Album;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.util.*;

public class SongLogic {

    public Log logger = new Log4JLogger(this.getClass().getName());

    //////////////////////////////////////////
	private ISongDA songDA;
    private IArtistDA artistDA;
    private IAlbumDA albumDA;
    private IGenreDA genreDA;
    private CommonFile commonFile;
    private ISongSelector songSelector;
    private IStationDA stationDA;

    public ISongSelector getSongSelector() {
        return songSelector;
    }

    public void setSongSelector(ISongSelector songSelector) {
        this.songSelector = songSelector;
    }

    public ISongDA getSongDA() {
        return songDA;
    }

    public void setSongDA(ISongDA songDA) {
        this.songDA = songDA;
    }

    public IArtistDA getArtistDA() {
        return artistDA;
    }

    public void setArtistDA(IArtistDA artistDA) {
        this.artistDA = artistDA;
    }

    public IAlbumDA getAlbumDA() {
        return albumDA;
    }

    public void setAlbumDA(IAlbumDA albumDA) {
        this.albumDA = albumDA;
    }

    public CommonFile getCommonFile() {
        return commonFile;
    }

    public void setCommonFile(CommonFile commonFile) {
        this.commonFile = commonFile;
    }

    public IGenreDA getGenreDA() {
        return genreDA;
    }

    public void setGenreDA(IGenreDA genreDA) {
        this.genreDA = genreDA;
    }

    public IStationDA getStationDA() {
        return stationDA;
    }

    public void setStationDA(IStationDA stationDA) {
        this.stationDA = stationDA;
    }

    ////////////////////////////////////////////////

    public void addNewSong( SongEntity songEntity, FileItem songFile, FileItem artworkFile, AlbumEntity albumEntity, Set<SongFeatureEntity> features)throws
            SongExistException,
            ArtistNotExistException,
            FileExistException,
            AlbumNotExistException,
            GenreNotExistsException{

        // First we check to see if we have the same song with the same name and same artists
        SongEntity song = songDA.getSongBySongNameAndArtistNames(songEntity);
        if( song != null )
            throw new SongExistException( "Song already Exists!" );

        // Checking whether all artists do exist in the system
        Iterator itr = songEntity.getArtists().iterator();
        List<ArtistEntity> realArtists = new LinkedList<ArtistEntity>();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            realArtists.add( artistDA.getArtistByName( artistEntity ) );
            if( artistDA.getArtistByName( artistEntity ) == null )
                throw new ArtistNotExistException( "Artist with name " + artistEntity.getArtistName() + " Does not exist!" );

        }
        //itr.remove();

        // Checking whether the album exists in the system
        AlbumEntity realAlbumEntity = albumDA.getAlbumByName( albumEntity );
        if( realAlbumEntity == null )
            throw new AlbumNotExistException( "Album " + realAlbumEntity.getName() + " does not exist in the system!" );

        GenreEntity finalGenreEntity = null;

        // Checking the existence of the genre in our system
        // TODO: Remember, in this function we considered we only added one genre to song
        itr = songEntity.getGenres().iterator();
        if( itr.hasNext() ){
            GenreEntity genreEntity = (GenreEntity)itr.next();
            if( genreDA.getGenreByName(genreEntity) == null )
                throw new GenreNotExistsException("Genre with name " + genreEntity.getName() + " does not exist!");
            else
                finalGenreEntity = genreDA.getGenreByName(genreEntity);
        }


        // Specifying the song name to be stored in repository which is songEntity.getName() + name of artists
        // This also could be used for the artwork name
        String filename = songEntity.getName();

        itr = songEntity.getArtists().iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            filename += commonFile.getDash() + artistEntity.getArtistName();
        }
        //itr.remove();

        // Full song path
        // TODO: Here we considered we only have mp3 files in the system
        // TODO: Here we considered we only have jpg files in the system
        String songFullPath = commonFile.getSongsRepositoryBasePath() + commonFile.getSeparator() + filename + commonFile.getDot() + SongFormat.MP3;
        String artworkFullPath = commonFile.getSongArtworksRepositoryBasePath() + commonFile.getSeparator() + filename + commonFile.getDot() + ImageFormat.JPG;

        // Here we check to make sure the commonFile for both song and artwork do not exist in the system.
        File file = new File( songFullPath );
        if( file.exists() ){
            throw new FileExistException( "File " + songFullPath + " already exists in the repository of songs." );
        }

        file = new File( artworkFullPath );
        if( file.exists() ){
            throw new FileExistException( "File " + artworkFullPath + " already exists in the repository of artworks." );
        }

        // Now writing files in the repository
        File finalSongFile = new File( songFullPath );
        File finalArtworkFile = new File( artworkFullPath );
        // TODO: We should think about how to handle these below exceptions
        try{
            songFile.write( finalSongFile );
            artworkFile.write( finalArtworkFile );
        }catch ( Exception e ){
            e.printStackTrace();
        }

        // Finally add the song and related artists into the database
        SongEntity finalSongEntity = new SongEntity();
        finalSongEntity.setName( songEntity.getName() );
        finalSongEntity.setLyric( songEntity.getLyric() );
        finalSongEntity.setImagePath( filename + commonFile.getDot() + ImageFormat.JPG );
        finalSongEntity.setMp3Path( filename + commonFile.getDot() + SongFormat.MP3 );

        if( finalGenreEntity != null ){
            finalSongEntity.getGenres().add(finalGenreEntity);
            finalGenreEntity.getSongs().add(finalSongEntity);
        }

        itr = realArtists.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            finalSongEntity.getArtists().add( artistEntity );

        }

        //itr.remove();

        finalSongEntity.setAlbum( realAlbumEntity );

        itr = features.iterator();
        while( itr.hasNext() ){
            SongFeatureEntity songFeatureEntity = (SongFeatureEntity)itr.next();
            songFeatureEntity.setOwner( finalSongEntity );
        }
        finalSongEntity.setFeatureEntities( features );

        songDA.insert( finalSongEntity );
        realAlbumEntity.getSongs().add( finalSongEntity );
        genreDA.update( finalGenreEntity );
        albumDA.update(realAlbumEntity);

        itr = realArtists.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            artistEntity.getSongs().add( finalSongEntity );
            artistDA.update( artistEntity );
        }

    }

    public void addNewSong( SongEntity songEntity, String songFile, String artworkFile, AlbumEntity albumEntity, Set<SongFeatureEntity> features)throws
            SongExistException,
            ArtistNotExistException,
            FileExistException,
            FileNotExistsException,
            AlbumNotExistException,
            GenreNotExistsException{

        // First we check to see if we have the same song with the same name and same artists
        SongEntity song = songDA.getSongBySongNameAndArtistNames(songEntity);
        if( song != null )
            throw new SongExistException( "Song already Exists!" );

        // Checking whether all artists do exist in the system
        Iterator itr = songEntity.getArtists().iterator();
        List<ArtistEntity> realArtists = new LinkedList<ArtistEntity>();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            realArtists.add( artistDA.getArtistByName( artistEntity ) );
            if( artistDA.getArtistByName( artistEntity ) == null )
                throw new ArtistNotExistException( "Artist with name " + artistEntity.getArtistName() + " Does not exist!" );

        }
        //itr.remove();

        // Checking whether the album exists in the system
        AlbumEntity realAlbumEntity = albumDA.getAlbumByName( albumEntity );
        if( realAlbumEntity == null )
            throw new AlbumNotExistException( "Album " + albumEntity.getName() + " does not exist in the system!" );

        GenreEntity finalGenreEntity = null;

        // Checking the existence of the genre in our system
        // TODO: Remember, in this function we considered we only added one genre to song
        itr = songEntity.getGenres().iterator();
        if( itr.hasNext() ){
            GenreEntity genreEntity = (GenreEntity)itr.next();
            if( genreDA.getGenreByName(genreEntity) == null )
                throw new GenreNotExistsException("Genre with name " + genreEntity.getName() + " does not exist!");
            else
                finalGenreEntity = genreDA.getGenreByName(genreEntity);
        }


        // Specifying the song name to be stored in repository which is songEntity.getName() + name of artists
        // This also could be used for the artwork name
        String filename = songEntity.getName();

        itr = songEntity.getArtists().iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            filename += commonFile.getDash() + artistEntity.getArtistName();
        }
        //itr.remove();

        // Full song path
        // TODO: Here we considered we only have mp3 files in the system
        // TODO: Here we considered we only have jpg files in the system
        String songFullPath = commonFile.getSongsRepositoryBasePath() + commonFile.getSeparator() + filename + commonFile.getDot() + SongFormat.MP3;
        String artworkFullPath = commonFile.getSongArtworksRepositoryBasePath() + commonFile.getSeparator() + filename + commonFile.getDot() + ImageFormat.JPG;

        // Here we check to make sure the commonFile for both song and artwork do not exist in the system.
        File file = new File( songFullPath );
        if( file.exists() ){
            throw new FileExistException( "File " + songFullPath + " already exists in the repository of songs." );
        }

        file = new File( artworkFullPath );
        if( file.exists() ){
            throw new FileExistException( "File " + artworkFullPath + " already exists in the repository of artworks." );
        }


        String songSourcePath = /*commonFile.getInitsongpath() + commonFile.getSeparator() + */songFile;
        String artworkSourcePath = /*commonFile.getInitsongartworkpath() + commonFile.getSeparator() +*/ artworkFile;

        File songSourceFile = new File( songSourcePath );
        File artworkSourceFile = new File( artworkSourcePath );

        if( !songSourceFile.exists() )
            throw new FileNotExistsException( "Source song file " + songSourceFile + " does not exist in the system!" );
        if( !artworkSourceFile.exists() )
            throw new FileNotExistsException( "Source artwork file " + artworkSourceFile + " does not exist in the system!" );

        try{
            File songDestinationFile = new File( songFullPath );
            File artworkDestinationFile = new File( artworkFullPath );

            FileUtils.copyFile( songSourceFile, songDestinationFile );
            FileUtils.copyFile( artworkSourceFile, artworkDestinationFile );
        }catch (Exception e){
            e.printStackTrace();
        }

        // Finally add the song and related artists into the database
        SongEntity finalSongEntity = new SongEntity();
        finalSongEntity.setName( songEntity.getName() );
        finalSongEntity.setLyric( songEntity.getLyric() );
        finalSongEntity.setImagePath( filename + commonFile.getDot() + ImageFormat.JPG );
        finalSongEntity.setMp3Path( filename + commonFile.getDot() + SongFormat.MP3 );

        if( finalGenreEntity != null ){
            finalSongEntity.getGenres().add(finalGenreEntity);
            finalGenreEntity.getSongs().add(finalSongEntity);
        }

        itr = realArtists.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            finalSongEntity.getArtists().add( artistEntity );

        }

        //itr.remove();

        finalSongEntity.setAlbum( realAlbumEntity );

        itr = features.iterator();
        while( itr.hasNext() ){
            SongFeatureEntity songFeatureEntity = (SongFeatureEntity)itr.next();
            songFeatureEntity.setOwner( finalSongEntity );
        }
        finalSongEntity.setFeatureEntities( features );

        songDA.insert( finalSongEntity );
        realAlbumEntity.getSongs().add( finalSongEntity );
        genreDA.update( finalGenreEntity );
        albumDA.update(realAlbumEntity);

        itr = realArtists.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            artistEntity.getSongs().add( finalSongEntity );
            artistDA.update( artistEntity );
        }


    }


    public List<SongEntity> getAllSongs(){

        return songDA.get();

    }

    public AlbumEntity getSongAlbum( SongEntity songEntity ) throws
            SongNotExistsException{

        SongEntity realSongEntity = songDA.get( songEntity.getSongID() );
        if( realSongEntity == null )
            throw new SongNotExistsException( "Song with id " + songEntity.getSongID() + " does not exist in the system!" );

        return realSongEntity.getAlbum();

    }

    public List<ArtistEntity> getSongArtists( SongEntity songEntity ) throws
            SongNotExistsException{

        SongEntity realSongEntity = songDA.get( songEntity.getSongID() );
        if( realSongEntity == null )
            throw new SongNotExistsException( "Song with id " + songEntity.getSongID() + " does not exist in the system!" );

        List<ArtistEntity> artistEntities = new LinkedList<ArtistEntity>();

        Iterator itr = realSongEntity.getArtists().iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            artistEntities.add( artistEntity );
        }

        return artistEntities;

    }


    public List<GenreEntity> getSongGenre( SongEntity songEntity ) throws
            SongNotExistsException{

        SongEntity realSongEntity = songDA.get( songEntity.getSongID() );
        if( realSongEntity == null )
            throw new SongNotExistsException( "Song with id " + songEntity.getSongID() + " does not exist in the system!" );

        List<GenreEntity> genreEntities = new LinkedList<GenreEntity>();

        Iterator itr = realSongEntity.getGenres().iterator();
        while( itr.hasNext() ){
            GenreEntity genreEntity = (GenreEntity)itr.next();
            genreEntities.add(genreEntity);
        }

        return genreEntities;

    }


    public void deleteSong( SongEntity songEntity ) throws
        SongNotExistsException,
        FileNotExistsException{

        SongEntity realSongEntity = songDA.get( songEntity.getSongID() );

        if( realSongEntity == null )
            throw new SongNotExistsException( "Song with id " + songEntity.getSongID() + " does not exist!" );

        AlbumEntity realAlbumEntity = realSongEntity.getAlbum();
        Set<ArtistEntity> realArtistEntities = realSongEntity.getArtists();
        Set<GenreEntity> realGenreEntity = realSongEntity.getGenres();

        // removing song relation from album
        realAlbumEntity.getSongs().remove( realSongEntity );

        // removing song relation from artists
        Iterator itr = realArtistEntities.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            artistEntity.getSongs().remove( realSongEntity );
        }

        // removing song relation from genre
        itr = realGenreEntity.iterator();
        while( itr.hasNext() ){
            GenreEntity genreEntity = (GenreEntity)itr.next();
            genreEntity.getSongs().remove( realSongEntity );
        }

        String songName = realSongEntity.getName();
        itr = realSongEntity.getArtists().iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            songName += commonFile.getDash() + artistEntity.getArtistName();
        }

        String songFileAddress = commonFile.getSongsRepositoryBasePath() + commonFile.getSeparator() + songName + commonFile.getDot() + SongFormat.MP3;
        String songArtworkAddress = commonFile.getSongArtworksRepositoryBasePath() + commonFile.getSeparator() + songName + commonFile.getDot() + ImageFormat.JPG;

        File songMp3File = new File( songFileAddress );
        File songArtworkFile = new File( songArtworkAddress );

        if( !songMp3File.exists() )
            throw new FileNotExistsException( "File " + songFileAddress );
        if( !songArtworkFile.exists() )
            throw new FileNotExistsException( "File " + songArtworkAddress );

        songMp3File.delete();
        songArtworkFile.delete();

        songDA.delete( realSongEntity );
        albumDA.update( realAlbumEntity );

        itr = realArtistEntities.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            artistDA.update( artistEntity );
        }

        itr = realGenreEntity.iterator();
        while( itr.hasNext() ){
            GenreEntity genreEntity = (GenreEntity)itr.next();
            genreDA.update( genreEntity );
        }

    }

    public List<SongEntity> listSongsByGenre( String genreName )
        throws GenreNotExistsException{

        // Checking existence of genre
        GenreEntity tempGenre = new GenreEntity();
        tempGenre.setName( genreName );
        GenreEntity realGenre = genreDA.getGenreByName( tempGenre );
        if( realGenre == null )
            throw new GenreNotExistsException( "Genre with name " + genreName + " does not exist in the system!" );

        // Listing songs with the genre name
        List<SongEntity> songEntities = genreDA.listSongsByGenreName( realGenre );

        return songEntities;

    }

    public String getNextSong(StationEntity stationEntity) throws
            StationNotExistsException,
            Exception{

        StationEntity realStationEntity = stationDA.get( stationEntity.getStationID() );

        Map<String, String> features = new HashMap<String, String>();

        Set<StationFeatureEntity> stationFeatureEntities = realStationEntity.getFeatures();
        Iterator itr = stationFeatureEntities.iterator();
        while( itr.hasNext() ){
            StationFeatureEntity stationFeatureEntity = (StationFeatureEntity)itr.next();
            features.put( stationFeatureEntity.getFeatureKey(), stationFeatureEntity.getFeatureValue() );
        }

        return songSelector.getNextSongByFeature( features );

    }

    public SongEntity getSongByName( SongEntity songEntity ) throws
            SongNotExistsException{

        SongEntity realSongEntity = songDA.getSongByName( songEntity );
        if( realSongEntity == null )
            throw new SongNotExistsException( "There is no song in database with name " + songEntity.getName() );

        return realSongEntity;

    }



    public String changeSongName(SongEntity songEntity, String songName) throws
            SongNotExistsException{

        SongEntity realSongEntity = songDA.get(songEntity.getSongID());
        if( realSongEntity == null )
            throw new SongNotExistsException( "There is no song with id " + songEntity.getSongID() );

        realSongEntity.setName( songName );
        songDA.update( realSongEntity );

        return songName;

    }

    public String changeSongAlbum( SongEntity songEntity, AlbumEntity albumEntity ) throws
            SongNotExistsException,
            AlbumNotExistException{

        SongEntity realSongEntity = songDA.get( songEntity.getSongID() );
        if( realSongEntity == null )
            throw new SongNotExistsException( "There is no song with id " + songEntity.getSongID() );

        AlbumEntity realAlbumEntity = albumDA.getAlbumByName( albumEntity );
        if( realAlbumEntity == null )
            throw new AlbumNotExistException( "There is no album with name " + albumEntity.getName() );

        // Removing the song from the current album and vice versa
        AlbumEntity currentAlbum = realSongEntity.getAlbum();
        realSongEntity.setAlbum( null );
        Iterator itr = currentAlbum.getSongs().iterator();
        SongEntity foundSong = null;
        while( itr.hasNext() ){
            SongEntity temp = (SongEntity)itr.next();
            if( temp.getName().equals( songEntity.getName() ) ){
                foundSong = temp;
                break;
            }
        }
        currentAlbum.getSongs().remove( foundSong );

        // Updating
        songDA.update( realSongEntity );
        albumDA.update( currentAlbum );

        // connecting the song and the new album

        realSongEntity.setAlbum( realAlbumEntity );
        realAlbumEntity.getSongs().add( realSongEntity );

        songDA.update(realSongEntity);
        albumDA.update( realAlbumEntity );

        return albumEntity.getName();

    }

    public String changeSongLyric( SongEntity songEntity, String lyric ) throws
            SongNotExistsException{

        SongEntity realSongEntity = songDA.get(songEntity.getSongID());
        if( realSongEntity == null ){
            throw new SongNotExistsException( "There is no song with the specified ID." );
        }

        realSongEntity.setLyric( lyric );
        songDA.update( realSongEntity );

        return lyric;

    }

    public String changeSongGenre( SongEntity songEntity, GenreEntity genreEntity ) throws
            SongNotExistsException,
            GenreNotExistsException{

        SongEntity realSongEntity = songDA.get( songEntity.getSongID() );
        GenreEntity realGenreEntity = genreDA.getGenreByName(genreEntity);

        if( realSongEntity == null )
            throw new SongNotExistsException( "There is no song with the specific ID." );

        if( realGenreEntity == null )
            throw new GenreNotExistsException( "There is no genre with the specified name " + genreEntity.getName()  );

        // Detaching genre from the song
        GenreEntity previousGenre = (GenreEntity)realSongEntity.getGenres().toArray()[0];
        realSongEntity.setGenres(null);
        Iterator itr = previousGenre.getSongs().iterator();
        SongEntity foundedSong = null;
        while( itr.hasNext() ){
            SongEntity temp = (SongEntity)itr.next();
            if( temp.getName().equals( temp.getName() ) ){
                foundedSong = temp;
                break;
            }
        }

        previousGenre.getSongs().remove( foundedSong );

        songDA.update( realSongEntity );
        genreDA.update( previousGenre );

        Set<GenreEntity> newGenres = new HashSet<GenreEntity>();
        newGenres.add( realGenreEntity );

        realGenreEntity.getSongs().add( realSongEntity );
        realSongEntity.setGenres( newGenres );

        songDA.update( realSongEntity );
        genreDA.update( realGenreEntity );

        return genreEntity.getName();
    }

    public SongEntity getSongByID(SongEntity songEntity) throws SongNotExistsException{
        SongEntity realSongEntity = songDA.getSongByID( songEntity );
        if( realSongEntity == null )
            throw new SongNotExistsException( "There is no song in database with ID " + songEntity.getSongID() );

        return realSongEntity;

    }

    public int getNumberOfLikes(SongEntity songEntity) throws SongNotExistsException {
        SongEntity realSongEntity = songDA.getSongByID( songEntity );
        if( realSongEntity == null )
            throw new SongNotExistsException( "There is no song in database with ID " + songEntity.getSongID() );
        return realSongEntity.getLikers().size();
    }

    public int getNumberOfDislikes(SongEntity songEntity) throws SongNotExistsException {
        SongEntity realSongEntity = songDA.getSongByID( songEntity );
        if( realSongEntity == null )
            throw new SongNotExistsException( "There is no song in database with ID " + songEntity.getSongID() );
        return realSongEntity.getDislikers().size();
    }

    public List<SongEntity> getTopSongs() throws  SongNotExistsException{


        List<SongEntity> topSongs = songDA.getTopSongs();
        if(topSongs.size() == 0 )
            throw new SongNotExistsException( "There is no song with highest number of likes.");
        return topSongs;
    }
    
    public SongEntity getSongsByBitrate(SongEntity songEntity) throws 
            SongNotExistsException{
        SongEntity realSongEntity = songDA.getSongsByBitrate( songEntity );
        if( realSongEntity == null )
            throw new SongNotExistsException( "There is no song in database with ID " + songEntity.getSongID() );

        return realSongEntity;
    }
}