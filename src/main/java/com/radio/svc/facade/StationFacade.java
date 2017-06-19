package com.radio.svc.facade;

import com.radio.entity.hibernate.StationEntity;
import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.exceptions.*;
import com.radio.svc.logic.StationLogic;
import com.radio.svc.searchentities.SearchResult;
import com.radio.svc.serviceinterface.IStationServiceProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by farhad on 8/27/14.
 */
public class StationFacade implements IStationServiceProvider {

    private StationLogic stationLogic;

    public StationLogic getStationLogic() {
        return stationLogic;
    }

    public void setStationLogic(StationLogic stationLogic) {
        this.stationLogic = stationLogic;
    }

    ////////////////////////////////////////////


    @Override
    public Long createNewStationBySearchEntity(String selectedSearchType, String selectedSearchName, Long selectedSearchID, String username, String selectedSearchLyrics) throws
            TypeNotExistException,
            EntityNotExistsException,
            UserNotExistsException,
            FileNotExistsException,
            StationExistsException{

        SearchResult searchResult = new SearchResult();
        searchResult.setType( selectedSearchType );
        searchResult.setName( selectedSearchName );
        searchResult.setId( selectedSearchID );
        searchResult.setLyrics( selectedSearchLyrics );

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail( username );


        return stationLogic.createNewStationBySearchEntity( searchResult, userEntity );

    }

    @Override
    public Long createNewStation(Map<String, String> features, String name, String username) throws
            UserNotExistsException,
            StationExistsException {

        StationEntity stationEntity = new StationEntity();
        stationEntity.setStationName( name );

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail( username );

        return stationLogic.createNewStation( features, stationEntity, userEntity );

    }

    @Override
    public List<StationEntity> getAllStations() {

        return stationLogic.getAllStations();

    }

    @Override
    public List<StationEntity> getAllStationsByUsername(String username) throws
            UserNotExistsException {

        UserEntity temp = new UserEntity();
        temp.setEmail( username );

        return stationLogic.getAllStationsByUsername( temp );

    }

    @Override
    public void deleteStationById(Long id) throws
            StationNotExistsException {

        StationEntity temp = new StationEntity();
        temp.setStationID( id );

        stationLogic.deleteStationById( temp );

    }

    @Override
    public void deleteUserSationById(Long stationid, String username)throws
        UserNotExistsException,
        StationNotExistsException {

        StationEntity stationEntity = new StationEntity();
        stationEntity.setStationID( stationid);

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(username);


        List<StationEntity> stations = stationLogic.getAllStationsByUsername(userEntity);
        Iterator iterator = stations.iterator();
        while(iterator.hasNext()){
            StationEntity newStationEntity = (StationEntity) iterator.next();
            if (newStationEntity.getStationID() == stationid ){
                stationLogic.deleteUserStationByUserid(newStationEntity,userEntity);
            }

        }


    }


}
