/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radio.svc.dalc.hibernate;

import com.radio.entity.hibernate.FeatureSSDEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.dalc.IFeatureSSDDA;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author farhad
 */
public class FeatureSSDDA extends GenericDA<FeatureSSDEntity, Long> implements IFeatureSSDDA {

    @Override
    public FeatureSSDEntity getFeatureSSDBySongID(SongEntity songEntity) {
       Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add( Restrictions.eq( "featureSSDID", songEntity.getSongID() ) );

        return (FeatureSSDEntity)criteria.uniqueResult();
    }
    
}
