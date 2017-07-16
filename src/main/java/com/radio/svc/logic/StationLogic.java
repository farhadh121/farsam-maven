package com.radio.svc.logic;

import com.radio.entity.hibernate.*;
import com.radio.svc.common.CommonFile;
import com.radio.svc.common.CommonUI;
import com.radio.svc.dalc.*;
import com.radio.svc.exceptions.*;
import com.radio.svc.searchentities.SearchResult;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.*;

/**
 * Created by farhad on 8/27/14.
 */
public class StationLogic {

    private IStationDA stationDA;
    private ISongDA songDA;
    private IAlbumDA albumDA;
    private IArtistDA artistDA;
    private IUserDA userDA;
    private IStationFeatureDA stationFeatureDA;
    private CommonFile commonFile;
    private CommonUI commonUI;

    public CommonFile getCommonFile() {
        return commonFile;
    }

    public void setCommonFile(CommonFile commonFile) {
        this.commonFile = commonFile;
    }

    public IStationDA getStationDA() {
        return stationDA;
    }

    public void setStationDA(IStationDA stationDA) {
        this.stationDA = stationDA;
    }

    public ISongDA getSongDA() {
        return songDA;
    }

    public void setSongDA(ISongDA songDA) {
        this.songDA = songDA;
    }

    public IAlbumDA getAlbumDA() {
        return albumDA;
    }

    public void setAlbumDA(IAlbumDA albumDA) {
        this.albumDA = albumDA;
    }

    public IArtistDA getArtistDA() {
        return artistDA;
    }

    public void setArtistDA(IArtistDA artistDA) {
        this.artistDA = artistDA;
    }

    public IUserDA getUserDA() {
        return userDA;
    }

    public void setUserDA(IUserDA userDA) {
        this.userDA = userDA;
    }

    public CommonUI getCommonUI() {
        return commonUI;
    }

    public void setCommonUI(CommonUI commonUI) {
        this.commonUI = commonUI;
    }

    public IStationFeatureDA getStationFeatureDA() {
        return stationFeatureDA;
    }

    public void setStationFeatureDA(IStationFeatureDA stationFeatureDA) {
        this.stationFeatureDA = stationFeatureDA;
    }

    /////////////////////////////////////////////

    public Long createNewStationBySearchEntity( SearchResult searchResult, UserEntity userEntity ) throws
            TypeNotExistException,
            EntityNotExistsException,
            UserNotExistsException,
            FileNotExistsException,
            StationExistsException{

        UserEntity realUserEntity = userDA.getUserByUserName( userEntity );
        if( realUserEntity == null )
            throw new UserNotExistsException( "User with user id " + userEntity.getUserID() );

        if( searchResult.getType().equalsIgnoreCase("song") || searchResult.getType().equalsIgnoreCase("lyrics") ){

            SongEntity songEntity = songDA.get( searchResult.getId() );
            if( songEntity == null )
                throw new EntityNotExistsException( "There is no song entity with id " + searchResult.getId() );
            StationEntity stationEntity = new StationEntity();

            Set<StationFeatureEntity> stationFeatureEntities = new HashSet<StationFeatureEntity>();
            Iterator itr = songEntity.getFeatureEntities().iterator();
            while( itr.hasNext() ){

                SongFeatureEntity songFeatureEntity = (SongFeatureEntity)itr.next();
                StationFeatureEntity stationFeatureEntity = new StationFeatureEntity();
                stationFeatureEntity.setFeatureKey( songFeatureEntity.getFeatureKey() );
                stationFeatureEntity.setFeatureValue( songFeatureEntity.getFeatureValue() );
                stationFeatureEntity.setOwner( stationEntity );
                stationFeatureEntities.add( stationFeatureEntity );

            }

            stationEntity.setFeatures( stationFeatureEntities );
            stationEntity.setOwner(realUserEntity);
            Date date = new Date();
            stationEntity.setCreationDate( date );
            stationEntity.setLastAccessDate( date );
            stationEntity.setStationName( songEntity.getName() );

            StationEntity temp = stationDA.getStationByStationNameAndUsername( stationEntity, realUserEntity );

            if( temp != null ){
                //throw new StationExistsException( "Station with name " + stationEntity.getStationName() + " which belongs to " + realUserEntity.getEmail() + " Already exists in the system!" );
                return temp.getStationID();
            }

            Set<StationEntity> set = realUserEntity.getOwnedStations();
            if( set == null )
                realUserEntity.setOwnedStations( new HashSet<StationEntity>() );
            realUserEntity.getOwnedStations().add(stationEntity);
            stationEntity.setStationArtwork( songEntity.getArtworkPath() );


            // Copying song artwork to station artwork folder
            String sourceFile = commonFile.getSongArtworksRepositoryBasePath() + commonFile.getSeparator() + songEntity.getArtworkPath();
            String destinationFile = commonFile.getStationArtworkRepositoryBasePath() + commonFile.getSeparator() + songEntity.getArtworkPath();

            File source = new File( sourceFile );
            File destination = new File( destinationFile );

            try{
                FileUtils.copyFile( source, destination );
            }catch ( Exception e ){
                e.printStackTrace();
                throw new FileNotExistsException( "File cannot be copied to destination " + destinationFile );
            }

            stationEntity.setStationArtwork( songEntity.getArtworkPath() );

            stationDA.insert(stationEntity);
            userDA.update( realUserEntity );

            return stationEntity.getStationID();

        }else if( searchResult.getType().equalsIgnoreCase("artist") ){

            ArtistEntity artistEntity = artistDA.get( searchResult.getId() );
            if( artistEntity == null )
                throw new EntityNotExistsException( "There is no artist entity with id " + searchResult.getId() );
            StationEntity stationEntity = new StationEntity();

            Set<StationFeatureEntity> stationFeatureEntities = new HashSet<StationFeatureEntity>( );
            Iterator itr = artistEntity.getFeatureEntities().iterator();
            while( itr.hasNext() ){

                ArtistFeatureEntity artistFeatureEntity = (ArtistFeatureEntity)itr.next();
                StationFeatureEntity stationFeatureEntity = new StationFeatureEntity();
                stationFeatureEntity.setFeatureKey( artistFeatureEntity.getFeatureKey() );
                stationFeatureEntity.setFeatureValue( artistFeatureEntity.getFeatureValue() );
                stationFeatureEntity.setOwner( stationEntity );
                stationFeatureEntities.add( stationFeatureEntity );

            }

            stationEntity.setFeatures( stationFeatureEntities );
            stationEntity.setOwner( realUserEntity );
            Date date = new Date();
            stationEntity.setLastAccessDate( date );
            stationEntity.setCreationDate( date );
            stationEntity.setStationName( artistEntity.getArtistName() );

            StationEntity temp = stationDA.getStationByStationNameAndUsername( stationEntity, realUserEntity );

            if( stationDA.getStationByStationNameAndUsername( stationEntity, realUserEntity ) != null ){
                //throw new StationExistsException( "Station with name " + stationEntity.getStationName() + " which belongs to " + realUserEntity.getEmail() + " Already exists in the system!" );
                return temp.getStationID();
            }
            // Copying song artwork to station artwork folder
            String sourceFile = commonFile.getArtistArtworkRepositoryBasePath() + commonFile.getSeparator() + artistEntity.getArtistArtworkPath();
            String destinationFile = commonFile.getStationArtworkRepositoryBasePath() + commonFile.getSeparator() + artistEntity.getArtistArtworkPath();

            File source = new File( sourceFile );
            File destination = new File( destinationFile );

            try{
                FileUtils.copyFile( source, destination );

            }catch ( Exception e ){
                e.printStackTrace();
                throw new FileNotExistsException( "File cannot be copied to destination " + destinationFile );
            }

            stationEntity.setStationArtwork( artistEntity.getArtistArtworkPath() );

            stationDA.insert( stationEntity );
            userDA.update( realUserEntity );

            return stationEntity.getStationID();

        }else if( searchResult.getType().equalsIgnoreCase("album") ){

            AlbumEntity albumEntity = albumDA.get( searchResult.getId() );
            if( albumEntity == null )
                throw new EntityNotExistsException( "There is no album entity with id " + searchResult.getId() );
            StationEntity stationEntity = new StationEntity();

            Set<StationFeatureEntity> stationFeatureEntities = new HashSet<StationFeatureEntity>();
            Iterator itr = albumEntity.getFeatureEntities().iterator();
            while( itr.hasNext() ){

                AlbumFeatureEntity albumFeatureEntity = (AlbumFeatureEntity)itr.next();
                StationFeatureEntity stationFeatureEntity = new StationFeatureEntity();
                stationFeatureEntity.setFeatureKey( albumFeatureEntity.getFeatureKey() );
                stationFeatureEntity.setFeatureValue( albumFeatureEntity.getFeatureValue() );
                stationFeatureEntity.setOwner( stationEntity );
                stationFeatureEntities.add( stationFeatureEntity );

            }

            stationEntity.setFeatures( stationFeatureEntities );
            stationEntity.setOwner(realUserEntity);
            Date date = new Date();
            stationEntity.setCreationDate( date );
            stationEntity.setLastAccessDate( date );
            stationEntity.setStationName( albumEntity.getName() );

            StationEntity temp = stationDA.getStationByStationNameAndUsername( stationEntity, realUserEntity );

            if( stationDA.getStationByStationNameAndUsername( stationEntity, realUserEntity ) != null ){
                //throw new StationExistsException( "Station with name " + stationEntity.getStationName() + " which belongs to " + realUserEntity.getEmail() + " Already exists in the system!" );
                return temp.getStationID();
            }
            // Copying song artwork to station artwork folder
            String sourceFile = commonFile.getAlbumArtworkRepositoryBasePath() + commonFile.getSeparator() + albumEntity.getAlbumArtworkPath();
            String destinationFile = commonFile.getStationArtworkRepositoryBasePath() + commonFile.getSeparator() + albumEntity.getAlbumArtworkPath();

            File source = new File( sourceFile );
            File destination = new File( destinationFile );

            try{
                FileUtils.copyFile( source, destination );
            }catch ( Exception e ){
                e.printStackTrace();
                throw new FileNotExistsException( "File cannot be copied to destination " + destinationFile );
            }

            stationEntity.setStationArtwork( albumEntity.getAlbumArtworkPath() );

            stationDA.insert( stationEntity );
            userDA.update( realUserEntity );

            return stationEntity.getStationID();

        }else{
            throw new TypeNotExistException( "There is no type with name " + searchResult.getType() );
        }

    }

    public Long createNewStation(Map<String, String> features, StationEntity stationEntity, UserEntity userEntity ) throws
            UserNotExistsException,
            StationExistsException {

        UserEntity realUserEntity = userDA.getUserByUserName( userEntity );
        if( realUserEntity == null )
            throw new UserNotExistsException( "There is no user with name " + userEntity.getEmail() );

        StationEntity realStationEntity = stationDA.getStationByName( stationEntity );
        if( realStationEntity != null )
            throw new StationExistsException( "There is station with name " + stationEntity.getStationName() + " already in the system!" );

        stationEntity.setCreationDate( new Date() );

        Set<StationFeatureEntity> stationFeatureEntities = new HashSet<StationFeatureEntity>( );
        Iterator itr = features.keySet().iterator();
        while( itr.hasNext() ){
            StationFeatureEntity temp = (StationFeatureEntity)itr.next();
            stationFeatureEntities.add( temp );
        }
        stationEntity.setFeatures( stationFeatureEntities );

        stationEntity.setLastAccessDate( new Date() );
        stationEntity.setOwner( realUserEntity );
        stationEntity.setSubscribers( null );

        stationEntity = stationDA.update( stationEntity );
        return stationEntity.getStationID();
    }

    public List<StationEntity> getAllStations(){

        List<StationEntity> entities = stationDA.get();
        Iterator itr = entities.iterator();

        List<StationEntity> result = new LinkedList<StationEntity>();

        while( itr.hasNext() ){

            StationEntity newCreated = new StationEntity();
            StationEntity next = (StationEntity)itr.next();

            // Duplicating this station entity
            newCreated.setStationID( next.getStationID() );
            newCreated.setLastAccessDate( next.getLastAccessDate() );
            newCreated.setCreationDate( next.getCreationDate() );
            UserEntity userEntity = new UserEntity();
            userEntity.setUserID( next.getOwner().getUserID() );
            userEntity.setEmail( next.getOwner().getEmail() );
            newCreated.setOwner( userEntity );

            Set<StationFeatureEntity> featureEntities = new HashSet<StationFeatureEntity>();

            Iterator itr2 = next.getFeatures().iterator();
            while( itr2.hasNext() ){
                StationFeatureEntity stationFeatureEntity = (StationFeatureEntity)itr2.next();
                StationFeatureEntity feature = new StationFeatureEntity();
                feature.setFeatureKey( stationFeatureEntity.getFeatureKey() );
                feature.setFeatureValue( stationFeatureEntity.getFeatureValue() );

                featureEntities.add( feature );
            }

            newCreated.setFeatures( featureEntities );
            result.add( newCreated );

        }

        return result;

    }


    public List<StationEntity> getAllStationsByUsername(UserEntity userEntity) throws
            UserNotExistsException {

        UserEntity realUser = userDA.getUserByUserName( userEntity );
        if( realUser == null )
            throw new UserNotExistsException( "No user exists with user name " + userEntity.getEmail() );

        return stationDA.getStationsByUsername( realUser );

    }


    public void deleteStationById(StationEntity stationEntity) throws
            StationNotExistsException {

        StationEntity realStation = stationDA.get( stationEntity.getStationID() );
        if( realStation == null )
            throw new StationNotExistsException( "Station with id "+ stationEntity.getStationID() + " does not exist in the system!" );

        String stationArtworkPath = commonFile.getStationArtworkRepositoryBasePath() + commonFile.getSeparator() + stationEntity.getStationArtwork();
        File file = new File( stationArtworkPath );
        file.delete();

        // deleting all station features first
        Iterator itr = realStation.getFeatures().iterator();

        while( itr.hasNext() ){
            StationFeatureEntity feature = (StationFeatureEntity)itr.next();
            stationFeatureDA.delete( feature );
        }

        // deleting the station itself
        stationDA.delete( realStation );


    }

    public void deleteUserStationByUserid (StationEntity stationEntity, UserEntity userEntity) throws
            UserNotExistsException,
            StationNotExistsException{
        StationEntity realStation = stationDA.get( stationEntity.getStationID() );
        UserEntity realUser = userDA.getUserByUserName(userEntity);
        //UserEntity realUser = userDA.get( userEntity.getUserID());

        StationEntity stationEntity1 = stationDA.getStationByStationNameAndUsername(realStation, realUser);
        stationDA.delete(stationEntity1);

    }

}
