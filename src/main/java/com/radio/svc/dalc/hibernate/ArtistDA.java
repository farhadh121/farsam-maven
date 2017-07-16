package com.radio.svc.dalc.hibernate;

import com.radio.entity.hibernate.ArtistEntity;
import com.radio.svc.dalc.IArtistDA;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ArtistDA extends GenericDA<ArtistEntity, Long> implements IArtistDA {

    public Log logger = new Log4JLogger(this.getClass().getName());

    ///////////////////////////////////////////////////////////////

    @Override
    public ArtistEntity getArtistByName(ArtistEntity artistEntity) {

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add(Restrictions.eq("artistName", artistEntity.getArtistName()));

        return (ArtistEntity)criteria.uniqueResult();

    }

    @Override
    public List<ArtistEntity> getArtistsByPartialName(String partialName) {

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add( Restrictions.ilike("artistName", partialName, MatchMode.ANYWHERE) );

        return criteria.list();

    }
}