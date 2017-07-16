package com.radio.svc.facade;

import com.radio.entity.hibernate.AlbumEntity;
import com.radio.entity.hibernate.ArtistEntity;
import com.radio.entity.hibernate.ArtistFeatureEntity;
import com.radio.svc.exceptions.*;
import com.radio.svc.logic.ArtistLogic;
import com.radio.svc.serviceinterface.IArtistServiceProvider;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import java.util.*;

public class ArtistFacede implements IArtistServiceProvider {


    public Log logger = new Log4JLogger(this.getClass().getName());

    ///////////////////////////////////////////////////////////////
	private ArtistLogic artistLogic;

    public ArtistLogic getArtistLogic() {
        return artistLogic;
    }

    public void setArtistLogic(ArtistLogic artistLogic) {
        this.artistLogic = artistLogic;
    }
    ///////////////////////////////////////////////////////////////

    @Override
    public void addNewArtist(String artistName, String artistInfo, FileItem artistArtwork, Map<String, String> features) throws
            ArtistExistException,
            FileExistException{

        // Creating Artist entity
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setArtistName(artistName);
        artistEntity.setArtistInfo(artistInfo);

        Set<ArtistFeatureEntity> artistFeatureEntitySet = new HashSet<ArtistFeatureEntity>();

        for( Map.Entry<String, String> entry : features.entrySet() ){
            ArtistFeatureEntity artistFeatureEntity = new ArtistFeatureEntity();
            artistFeatureEntity.setFeatureKey( entry.getKey() );
            artistFeatureEntity.setFeatureValue( entry.getValue() );
            artistFeatureEntitySet.add( artistFeatureEntity );
        }

        artistLogic.addNewArtist(artistEntity, artistArtwork, artistFeatureEntitySet);

    }

    @Override
    public void addNewArtist(String artistName, String artistInfo, String artistArtworkpath, Map<String, String> features) throws
            ArtistExistException,
            FileExistException,
            FileNotExistsException {

        //Creating Artist entity
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setArtistName(artistName);
        artistEntity.setArtistInfo(artistInfo);

        Set<ArtistFeatureEntity> artistFeatureEntitySet = new HashSet<ArtistFeatureEntity>();

        for( Map.Entry<String, String> entry : features.entrySet() ){
            ArtistFeatureEntity artistFeatureEntity = new ArtistFeatureEntity();
            artistFeatureEntity.setFeatureKey( entry.getKey() );
            artistFeatureEntity.setFeatureValue( entry.getValue() );
            artistFeatureEntitySet.add( artistFeatureEntity );
        }

        artistLogic.addNewArtist( artistEntity, artistArtworkpath, artistFeatureEntitySet);
    }

    @Override
    public List<ArtistEntity> getAllArtists() {
        return artistLogic.getAllArtists();
    }

    @Override
    public void deleteArtist(String artistName) throws ArtistNotExistException, FileNotExistsException {

        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setArtistName(artistName);
        artistLogic.deleteArtist( artistEntity );

    }
    /*
    @Override
    public ArtistEntity editArtist(Long artistId, String editArtistName, String editArtistInfo, FileItem editArtistArtwork) throws
            ArtistNotExistException,
            FileNotExistsException,
            FileExistException {

        // Create temporary artist entity
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setArtistID( artistId );
        artistEntity.setArtistName( editArtistName );
        artistEntity.setArtistInfo( editArtistInfo );



    }
    */

    @Override
    public void removeAlbumFromArtist(String artistName, String albumName) throws AlbumNotExistException, ArtistNotExistException {

        // create temporary objects
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setArtistName( artistName );

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName( albumName );

        artistLogic.removeAlbumFromArtist(artistEntity, albumEntity);

    }

    @Override
    public ArtistEntity getArtist(String artistName) throws
            ArtistNotExistException {

        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setArtistName( artistName );

        return artistLogic.getArtist( artistEntity );

    }

    @Override
    public String changeArtistName(Long artistID, String artistName) throws
            ArtistNotExistException {

        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setArtistID( artistID );
        artistEntity.setArtistName( artistName );

        return artistLogic.changeArtistName( artistEntity );

    }

    @Override
    public String changeArtistInfo(Long artistID, String artistInfo) throws
            ArtistNotExistException {

        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setArtistID( artistID );
        artistEntity.setArtistInfo( artistInfo );

        return artistLogic.changeArtistInfo( artistEntity );

    }
}
