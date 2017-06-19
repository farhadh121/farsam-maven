package com.radio.svc.dalc;

import com.radio.entity.hibernate.RoleEntity;
import com.radio.entity.hibernate.StationEntity;
import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.exceptions.EntityNotExistsException;
import com.radio.svc.exceptions.TypeNotExistException;

import java.util.List;

/**
 * Created by farhad on 8/27/14.
 */
public interface IStationDA extends IGenericDA<StationEntity, Long> {

    public List<StationEntity> getStationsByUsername( UserEntity userEntity );

    public StationEntity getStationByName( StationEntity stationEntity );

    public StationEntity getStationByStationNameAndUsername( StationEntity stationEntity, UserEntity userEntity );


}
