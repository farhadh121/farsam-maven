package com.radio.svc.dalc.hibernate;

import com.radio.entity.hibernate.StationEntity;
import com.radio.entity.hibernate.StationFeatureEntity;
import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.dalc.IStationDA;
import com.radio.svc.exceptions.EntityNotExistsException;
import com.radio.svc.exceptions.TypeNotExistException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by saman on 8/27/14.
 */
public class StationDA extends GenericDA<StationEntity, Long> implements IStationDA {

    @Override
    public List<StationEntity> getStationsByUsername(UserEntity userEntity) {

        Criteria criteria = this.getSession().createCriteria(this.getType(), "stationEntity");
        criteria.createAlias( "stationEntity.owner", "owner" );
        criteria.add(Restrictions.eq("owner.email", userEntity.getEmail()));

        List<StationEntity> stations = criteria.list();
        for (int i =  0 ; i< stations.size(); i++ ){
            Set<StationFeatureEntity> stationFeatureEntitySet = stations.get(i).getFeatures();
            Iterator itr = stationFeatureEntitySet.iterator();
            while(itr.hasNext()){
                StationFeatureEntity temp = (StationFeatureEntity) itr.next();
            }

           /* Set<UserEntity> subscribers = stations.get(i).getSubscribers();
            Iterator itr2 = subscribers.iterator();
            while(itr2.hasNext()){
                UserEntity tempUser = (UserEntity) itr2.next();
            }*/

        }

        return stations;

    }


    @Override
    public StationEntity getStationByName(StationEntity stationEntity) {

        Criteria criteria = this.getSession().createCriteria( this.getType(), "stationEntity" );
        criteria.add( Restrictions.eq( "stationName", stationEntity.getStationName() ) );

        return (StationEntity)criteria.uniqueResult();

    }

    @Override
    public StationEntity getStationByStationNameAndUsername(StationEntity stationEntity, UserEntity userEntity) {

        Criteria criteria = this.getSession().createCriteria( this.getType(), "stationEntity" );
        criteria.createAlias( "stationEntity.owner", "owner" );
        criteria.add(Restrictions.eq("owner.email", userEntity.getEmail()));
        criteria.add(Restrictions.eq("stationName", stationEntity.getStationName()));

        return (StationEntity)criteria.uniqueResult();

    }


}

