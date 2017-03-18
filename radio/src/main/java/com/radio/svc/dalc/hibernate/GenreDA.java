package com.radio.svc.dalc.hibernate;

import com.radio.entity.hibernate.GenreEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.dalc.IGenreDA;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mbani002 on 5/16/14.
 */
public class GenreDA extends GenericDA<GenreEntity, Long> implements IGenreDA {

    public Log logger = new Log4JLogger(this.getClass().getName());

    /////////////////////////////////////////////////////////////////

    @Override
    public GenreEntity getGenreByName(GenreEntity genreEntity) {

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add(Restrictions.eq("name", genreEntity.getName()));
        return (GenreEntity)criteria.uniqueResult();

    }

    @Override
    public List<SongEntity> listSongsByGenreName( GenreEntity genreEntity ){

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add( Restrictions.eq("name", genreEntity.getName()) );
        GenreEntity tempEntity = (GenreEntity)criteria.uniqueResult();

        List<SongEntity> songs = new LinkedList<SongEntity>();
        songs.addAll( tempEntity.getSongs() );

        return songs;

    }
}
