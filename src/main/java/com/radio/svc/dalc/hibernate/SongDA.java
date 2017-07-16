package com.radio.svc.dalc.hibernate;

import com.radio.entity.hibernate.ArtistEntity;
import com.radio.entity.hibernate.SongFeatureEntity;
import com.radio.svc.exceptions.SongNotExistsException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.google.common.base.Splitter;

import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.dalc.ISongDA;
import com.radio.svc.common.CommonFile;

import java.util.*;

public class SongDA extends GenericDA<SongEntity, Long> implements ISongDA {

    public Log logger = new Log4JLogger(this.getClass().getName());
    private CommonFile commonFile = new CommonFile();

    public CommonFile getCommonFile() {
        return commonFile;
    }

    public void setCommonFile(CommonFile commonFile) {
        this.commonFile = commonFile;
    }
    /////////////////////////////////////////////////////////////////

    @Override
    public SongEntity getSongBySongNameAndArtistNames(SongEntity songEntity) {

        Integer artistSize = songEntity.getArtists().size();

        Criteria criteria = this.getSession().createCriteria(this.getType(), "songEntity");
        criteria.createAlias("songEntity.artists", "artists");
        criteria.add( Restrictions.eq("songEntity.name", songEntity.getName()) );
        criteria.add( Restrictions.sizeEq("artists", artistSize) );

        List<SongEntity> list = (List<SongEntity>)criteria.list();

        // now check if it has all specified artists
        Iterator itr = list.iterator();
        while( itr.hasNext() ){

            SongEntity song = ( SongEntity )itr.next();
            boolean result = false;

            Iterator targetArtists = songEntity.getArtists().iterator();
            while( targetArtists.hasNext() ){
                ArtistEntity targetArtist = (ArtistEntity)targetArtists.next();
                if( !song.hasArtist(targetArtist.getArtistName()) ){
                    result = true;
                    break;
                }
            }

            if( result == false )
                return song;
        }

        return null;

    }

    @Override
    public List<SongEntity> getSongsByPartialName(String partialName) {
        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add( Restrictions.ilike( "name", partialName, MatchMode.ANYWHERE ) );

        return criteria.list();
    }

    @Override
    public SongEntity getSongByName(SongEntity songEntity) {

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add( Restrictions.eq( "name", songEntity.getName() ) );

        return (SongEntity)criteria.uniqueResult();

    }

    @Override
    public SongEntity getSongByID(SongEntity songEntity) {

        //System.out.println( "nena" );

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add( Restrictions.eq( "songID", songEntity.getSongID() ) );

        return (SongEntity)criteria.uniqueResult();

    }
    @Override
    public SongEntity getSongByLyrics(SongEntity songEntity){

        Criteria criteria = this.getSession().createCriteria( this.getType() );
        criteria.add( Restrictions.eq( "Lyrics", songEntity.getSongID() ) );

        return (SongEntity)criteria.uniqueResult();

    }
    @Override
    public List<SongEntity> getSongByLyricsPartialName(String partialName){

        Criteria lyricsCriteria = this.getSession().createCriteria( this.getType() );
        lyricsCriteria.add( Restrictions.ilike("lyric", partialName, MatchMode.ANYWHERE) );

        return lyricsCriteria.list();

    }

    @Override
    public List<SongEntity> getTopSongs(){
        String sql = "SELECT SongID, COUNT(SongID) AS action_count FROM user_like GROUP BY SongID ORDER BY action_count DESC LIMIT 10";
        SQLQuery query =  this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<SongEntity> songs = new ArrayList<SongEntity>();
        List result = query.list();
        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            String str = itr.next().toString();
            String strWithoutCurlyBraces = str.replaceAll("[{}]", " ");
            Map<String, String> mapOfTopSongIDs = commonFile.splitToMap(strWithoutCurlyBraces);
            //System.out.println("Printing " + mapOfTopSongIDs.keySet());

            String id = "";
            if(mapOfTopSongIDs.containsKey(" SongID"))
                id = ((String) mapOfTopSongIDs.get(" SongID")).trim();

            /*/parsing the returned string
            String s = str.substring(str.indexOf("=") + 1);
            s = s.substring(0, s.indexOf(","));
            String segments[] = str.split("=");
            String songIDFromQuery = segments[segments.length - 1];

            long songID = Long.parseLong(songIDFromQuery.replace("}", ""));*/
            long songID = Long.parseLong(id);
            SongEntity tempSOngEntity = new SongEntity();
            tempSOngEntity.setSongID(songID);
            SongEntity song = getSongByID(tempSOngEntity);
            // if( song == null )
            //  throw new SongNotExistsException( "There is no song in database with ID " + song.getSongID() );
            Set<ArtistEntity> artistEntity = song.getArtists();
            songs.add(song);
        }
        return   songs;
    }

    @Override       
    public SongEntity getSongsByBitrate(SongEntity songEntity){
            Criteria criteria = this.getSession().createCriteria( this.getType() );
            criteria.add( Restrictions.eq( "bitrate", songEntity.getBitrate()));

            return (SongEntity)criteria.uniqueResult();
    }


}
