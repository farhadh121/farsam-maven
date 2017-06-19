package com.radio.svc.logic;

import com.radio.entity.hibernate.AlbumEntity;
import com.radio.entity.hibernate.ArtistEntity;
import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.common.CommonFile;
import com.radio.svc.dalc.IAlbumDA;
import com.radio.svc.dalc.IArtistDA;
import com.radio.svc.dalc.ISongDA;
import com.radio.svc.searchentities.SearchResult;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by farhad on 8/22/14.
 */
public class SearchLogic {

    private ISongDA songDA;
    private IArtistDA artistDA;
    private IAlbumDA albumDA;
    private CommonFile commonFile;

    public ISongDA getSongDA() {
        return songDA;
    }

    public void setSongDA(ISongDA songDA) {
        this.songDA = songDA;
    }

    public IArtistDA getArtistDA() {
        return artistDA;
    }

    public void setArtistDA(IArtistDA artistDA) {
        this.artistDA = artistDA;
    }

    public IAlbumDA getAlbumDA() {
        return albumDA;
    }

    public void setAlbumDA(IAlbumDA albumDA) {
        this.albumDA = albumDA;
    }

    public CommonFile getCommonFile() {
        return commonFile;
    }

    public void setCommonFile(CommonFile commonFile) {
        this.commonFile = commonFile;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    public List<SearchResult> searchByPartialName(String partialName){

        List<SearchResult> searchResults = new LinkedList<SearchResult>();

        List<SongEntity> songEntities = songDA.getSongsByPartialName( partialName );
        List<SongEntity> lyricsEntities = songDA.getSongByLyricsPartialName( partialName );
        List<ArtistEntity> artistEntities = artistDA.getArtistsByPartialName( partialName );
        List<AlbumEntity> albumEntities = albumDA.getAlbumsByPartialName( partialName );


        System.out.println( "got all entities satisfying the condition" );

        //System.out.println( songEntities );
        //System.out.println( artistEntities );
        //System.out.println( albumEntities );
        Iterator itr = lyricsEntities.iterator();
        while( itr.hasNext() ){

            SongEntity songEntity = (SongEntity)itr.next();


            SearchResult searchResult = new SearchResult();
            searchResult.setType( "lyrics" );
            searchResult.setArtworkPath( commonFile.getDomain() + commonFile.getSeparator() + commonFile.getSongArtworksAlias() + commonFile.getSeparator() + commonFile.getSeparator() + songEntity.getArtworkPath() );
            searchResult.setId( songEntity.getSongID() );
            searchResult.setName( songEntity.getLyric() );
            searchResult.setLyrics(songEntity.getLyric());



            searchResults.add(  searchResult );
        }

         itr = songEntities.iterator();
        while( itr.hasNext() ){

            SongEntity songEntity = (SongEntity)itr.next();

            SearchResult searchResult = new SearchResult();
            searchResult.setArtworkPath( commonFile.getDomain() + commonFile.getSeparator() + commonFile.getSongArtworksAlias() + commonFile.getSeparator() + commonFile.getSeparator() + songEntity.getArtworkPath() );
            searchResult.setId( songEntity.getSongID() );
            searchResult.setName( songEntity.getName() );

            searchResult.setType( "song" );

            searchResults.add(  searchResult );
        }

        itr = artistEntities.iterator();
        while( itr.hasNext() ){

            ArtistEntity artistEntity = (ArtistEntity)itr.next();

            SearchResult searchResult = new SearchResult();
            searchResult.setType( "artist" );
            searchResult.setName( artistEntity.getArtistName() );
            searchResult.setId( artistEntity.getArtistID() );
            searchResult.setArtworkPath( commonFile.getDomain() + commonFile.getSeparator() + commonFile.getArtistaArtworksaAlias() + commonFile.getSeparator() + artistEntity.getArtistArtworkPath() );

            searchResults.add( searchResult );
        }

        itr = albumEntities.iterator();
        while( itr.hasNext() ) {

            AlbumEntity albumEntity = (AlbumEntity)itr.next();

            SearchResult searchResult = new SearchResult();
            searchResult.setType( "album" );
            searchResult.setId( albumEntity.getAlbumID() );
            searchResult.setArtworkPath( commonFile.getDomain() + commonFile.getSeparator() + commonFile.getAlbumArtworksAlias() + commonFile.getSeparator() + albumEntity.getAlbumArtworkPath() );
            searchResult.setName( albumEntity.getName() );

            searchResults.add( searchResult );

        }

        System.out.println( "returning result." );

        return  searchResults;

    }

}
