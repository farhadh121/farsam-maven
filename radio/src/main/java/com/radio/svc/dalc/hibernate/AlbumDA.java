package com.radio.svc.dalc.hibernate;

import com.radio.entity.hibernate.AlbumEntity;
import com.radio.entity.hibernate.ArtistEntity;
import com.radio.svc.dalc.IAlbumDA;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/14/14
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class AlbumDA extends GenericDA<AlbumEntity, Long> implements IAlbumDA {

    public Log logger = new Log4JLogger(this.getClass().getName());

    ///////////////////////////////////////////////////////////////

    @Override
    public AlbumEntity getAlbumByName(AlbumEntity albumEntity) {

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add(Restrictions.eq( "name", albumEntity.getName() ));

        return (AlbumEntity)criteria.uniqueResult();

    }

    @Override
    public AlbumEntity getAlbumByAlbumNameAndArtistNames( AlbumEntity albumEntity, Set<ArtistEntity> artistEntitySet ){

        Integer size = artistEntitySet.size();

        Criteria criteria = this.getSession().createCriteria( this.getType(), "albumEntity" );
        criteria.createAlias( "albumEntity.artists", "artists" );
        criteria.add( Restrictions.eq( "name", albumEntity.getName() ) );
        criteria.add( Restrictions.sizeEq( "artists", size ) );

        List<AlbumEntity> albums = criteria.list();

        Iterator itr = albums.iterator();

        while( itr.hasNext() ){
            AlbumEntity temp = (AlbumEntity)itr.next();
            int foundAll = 1;
            Iterator itrArtists = temp.getArtists().iterator();
            while( itrArtists.hasNext() ){
                int found = 0;
                ArtistEntity artistTemp = (ArtistEntity)itrArtists.next();

                Iterator itrInputArtists = artistEntitySet.iterator();
                while( itrInputArtists.hasNext() ){
                    ArtistEntity artistInputEntity = (ArtistEntity)itrInputArtists.next();
                    if( artistInputEntity.getArtistName().equals( artistTemp.getArtistName() ) ){
                        found = 1;
                        break;
                    }
                }

                if( found == 0 ){
                    foundAll = 0;
                    break;
                }

            }
            if( foundAll == 0 )
                continue;
            else
                return temp;
        }

        return null;

    }

    @Override
    public List<AlbumEntity> getAlbumsByPartialName(String partialName) {

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add( Restrictions.ilike( "name", partialName, MatchMode.ANYWHERE ) );



        return  criteria.list();

    }
}
