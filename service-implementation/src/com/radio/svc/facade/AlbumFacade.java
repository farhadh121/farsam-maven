package com.radio.svc.facade;

import com.radio.entity.hibernate.*;
import com.radio.svc.exceptions.*;
import com.radio.svc.logic.AlbumLogic;
import com.radio.svc.serviceinterface.IAlbumServiceProvider;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/27/14
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class AlbumFacade implements IAlbumServiceProvider {

    public Log logger = new Log4JLogger(this.getClass().getName());

    ////////////////////////////////////////////////////////////////////

    AlbumLogic albumLogic;

    public AlbumLogic getAlbumLogic() {
        return albumLogic;
    }

    public void setAlbumLogic(AlbumLogic albumLogic) {
        this.albumLogic = albumLogic;
    }

    //////////////////////////////////////////////////////////////////////

    @Override
    public void addNewAlbum(String name, Date releaseDate, String recordLabelName, List<String> artistName, FileItem albumArtworkFile, Map<String, String> features) throws
            AlbumExistsException,
            RecordLabelNotExistsException,
            ArtistNotExistException,
            FileExistException {

        // Creating temporary album object
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName(name);
        albumEntity.setReleaseDate(releaseDate);

        // Creating temporary record label object
        RecordLabelEntity recordLabelEntity = new RecordLabelEntity();
        recordLabelEntity.setName(recordLabelName);
        albumEntity.setRecordLabelEntity(recordLabelEntity);

        // Creating list of artist entities
        Set<ArtistEntity> list = new HashSet<ArtistEntity>();
        Iterator itr = artistName.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = new ArtistEntity();
            artistEntity.setArtistName((String)itr.next());
            list.add(artistEntity);
        }

        albumEntity.setArtists(list);

        Set<AlbumFeatureEntity> albumFeatureEntities = new HashSet<AlbumFeatureEntity>();

        for( Map.Entry<String, String> entry : features.entrySet() ){
            AlbumFeatureEntity albumFeatureEntity = new AlbumFeatureEntity();
            albumFeatureEntity.setFeatureKey( entry.getKey() );
            albumFeatureEntity.setFeatureValue( entry.getValue() );
            albumFeatureEntities.add( albumFeatureEntity );
        }

        albumLogic.addNewAlbum(albumEntity, recordLabelEntity, list, albumArtworkFile, albumFeatureEntities );
    }

    @Override
    public void addNewAlbum(String name, Date releaseDate, String recordLabelName, List<String> artistName, String albumArtworkPath, Map<String, String> features) throws
            AlbumExistsException,
            RecordLabelNotExistsException,
            ArtistNotExistException,
            FileExistException,
            FileNotExistsException {

        // Creating temporary album object
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName(name);
        albumEntity.setReleaseDate(releaseDate);

        // Creating temporary record label object
        RecordLabelEntity recordLabelEntity = new RecordLabelEntity();
        recordLabelEntity.setName(recordLabelName);
        albumEntity.setRecordLabelEntity(recordLabelEntity);

        // Creating list of artist entities
        Set<ArtistEntity> list = new HashSet<ArtistEntity>();
        Iterator itr = artistName.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = new ArtistEntity();
            artistEntity.setArtistName((String)itr.next());
            list.add(artistEntity);
        }

        albumEntity.setArtists(list);

        Set<AlbumFeatureEntity> albumFeatureEntities = new HashSet<AlbumFeatureEntity>();

        for( Map.Entry<String, String> entry : features.entrySet() ){
            AlbumFeatureEntity albumFeatureEntity = new AlbumFeatureEntity();
            albumFeatureEntity.setFeatureKey( entry.getKey() );
            albumFeatureEntity.setFeatureValue( entry.getValue() );
            albumFeatureEntities.add( albumFeatureEntity );
        }

        albumLogic.addNewAlbum(albumEntity, recordLabelEntity, list, albumArtworkPath, albumFeatureEntities );
    }



    @Override
    public List<AlbumEntity> getAllAlbums() {

        return albumLogic.getAllAlbums();

    }

    @Override
    public void deleteAlbum(String name) throws
            AlbumNotExistException,
            FileNotExistsException,
            SongsListNotEmptyException,
            ArtistNotExistException{

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName(name);

        albumLogic.deleteAlbum(albumEntity);

    }

    @Override
    public List<ArtistEntity> getAllArtists(String name) throws AlbumNotExistException {

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName( name );
        return albumLogic.getAllArtists( albumEntity );

    }

    @Override
    public RecordLabelEntity getRecordLabel(String name) throws AlbumNotExistException {

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName( name );
        return albumLogic.getRecordLabel( albumEntity );

    }

    @Override
    public String changeAlbumName(Long id, String name) throws AlbumNotExistException {

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setAlbumID( id );
        albumEntity.setName( name );

        return albumLogic.changeAlbumName( albumEntity );

    }

    @Override
    public String changeAlbumRecordLabel(Long id, String name) throws
            AlbumNotExistException,
            RecordLabelNotExistsException {

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setAlbumID( id );

        RecordLabelEntity recordLabelEntity = new RecordLabelEntity();
        recordLabelEntity.setName( name );

        return albumLogic.changeAlbumRecordLabel( albumEntity, recordLabelEntity );

    }

    @Override
    public String changeAlbumReleaseDate(Long id, String date) throws
            AlbumNotExistException,
            DateFormatWrongException {

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setAlbumID( id );
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date albumReleaseDate;

        try {
            albumReleaseDate = formatter.parse(date);
        }catch ( Exception e ){
            throw new DateFormatWrongException( "Date " + date + " format is wrong!" );
        }
        albumEntity.setReleaseDate( albumReleaseDate );

        return  albumLogic.changeAlbumReleaseDate( albumEntity, albumReleaseDate );

    }

    @Override
    public AlbumEntity getAlbumByName(String albumName) throws
            AlbumNotExistException {

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName( albumName );

        return  albumLogic.getAlbumByName( albumEntity );

    }
}
