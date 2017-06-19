package com.radio.svc.serviceinterface;

import com.radio.entity.hibernate.StationEntity;
import com.radio.svc.exceptions.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by farhad on 8/22/14.
 */
public interface IStationServiceProvider extends Serializable {

    /**
     * Creates a new station for the user with owner ID. Other fields indicate the search result object which has been
     * passed to the search result, when user was searching for something
     * @param selectedSearchType                Type of the search result selected. This could be "song", "artist" or "album"
     * @param selectedSearchName                Name of the entity
     * @param selectedSearchID                  ID of that entity
     * @param username                          User name of the owner of the station
     * @throws TypeNotExistException            Throws when the type is not one of the song, artist or album
     * @throws EntityNotExistsException         Throws when the entity of that type does not exist in the system, based
     *                                          on its ID.
     * @throws StationExistsException           Throws when there is one exception the same as the new one you want to add.
     * @return the ID of the newly created station
     */
    public Long createNewStationBySearchEntity( String selectedSearchType, String selectedSearchName, Long selectedSearchID, String username, String selectedSearchLyrics ) throws
            TypeNotExistException,
            EntityNotExistsException,
            UserNotExistsException,
            FileNotExistsException,
            StationExistsException;

    /**
     * Creates a new station, with user specified set of features.
     * @param features                          A Map of all features.
     * @param name                              A Name assigned to the station.
     * @param username                          The username who is creating the station
     * @return                                  Returns the id of the new created station
     * @throws UserNotExistsException           Throws when there is no user with the specified username
     * @throws StationExistsException           Throws when there is one station with the specified name
     */
    public Long createNewStation( Map<String, String> features, String name, String username ) throws
            UserNotExistsException,
            StationExistsException;

    /**
     * Returns a list of all stations exist inside the system.
     * This function may not be a appropriate function
     * @return                  List of all stations
     */
    public List<StationEntity> getAllStations();

    /**
     * Returns all stations assigned to one user
     * @param username                          this is the input as string, which is username
     * @return                                  returns a list of all stations assigned to that user
     * @throws UserNotExistsException           Throws when there is no user with that username
     */
    public List<StationEntity> getAllStationsByUsername( String username ) throws
            UserNotExistsException;


    /**
     * Delete and station by provided id
     * @param id            id of the target station
     * @throws StationNotExistsException        throws when there is no such station with such id
     */
    public void deleteStationById( Long stationid ) throws
            StationNotExistsException;

    /**
     * Delete station according stationid and userID
     * @param stationid     id for the station
     * @param username        id for the user who is the owner
     * @throws StationNotExistsException
     * @throws UserNotExistsException
     */
    public void deleteUserSationById ( Long stationid, String username) throws
            UserNotExistsException,
            StationNotExistsException;



}
