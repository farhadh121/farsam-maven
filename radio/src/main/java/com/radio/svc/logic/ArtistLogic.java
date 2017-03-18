package com.radio.svc.logic;

import com.radio.entity.hibernate.AlbumEntity;
import com.radio.entity.hibernate.ArtistEntity;
import com.radio.entity.hibernate.ArtistFeatureEntity;
import com.radio.svc.common.CommonFile;
import com.radio.svc.common.ImageFormat;
import com.radio.svc.dalc.IAlbumDA;
import com.radio.svc.dalc.IArtistDA;
import com.radio.svc.dalc.hibernate.ArtistFeatureDA;
import com.radio.svc.exceptions.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArtistLogic {

    public Log logger = new Log4JLogger(this.getClass().getName());

    /////////////////////////////////////////////////
	private IArtistDA artistDA;
    private IAlbumDA albumDA;
    private CommonFile commonFile;
    private ArtistFeatureDA artistFeatureDA;

    public ArtistFeatureDA getArtistFeatureDA() {
        return artistFeatureDA;
    }

    public void setArtistFeatureDA(ArtistFeatureDA artistFeatureDA) {
        this.artistFeatureDA = artistFeatureDA;
    }

    public CommonFile getCommonFile() {
        return commonFile;
    }

    public void setCommonFile(CommonFile commonFile) {
        this.commonFile = commonFile;
    }

    public IArtistDA getArtistDA() {
        return artistDA;
    }

    public void setArtistDA(IArtistDA artistDA) {
        this.artistDA = artistDA;
    }

    public Log getLogger() {
        return logger;
    }

    public void setLogger(Log logger) {
        this.logger = logger;
    }

    public IAlbumDA getAlbumDA() {
        return albumDA;
    }

    public void setAlbumDA(IAlbumDA albumDA) {
        this.albumDA = albumDA;
    }

    /////////////////////////////////////////////////

    public void addNewArtist( ArtistEntity artistEntity, FileItem artistArtwork, Set<ArtistFeatureEntity> features ) throws
            ArtistExistException,
            FileExistException{

        // check artist duplications
        if( artistDA.getArtistByName( artistEntity ) != null )
            throw new ArtistExistException( "Artist " + artistEntity.getArtistName() + " does exist." );

        // check whether artist artwork exists or not.
        String artistArtworkFile = commonFile.getArtistArtworkRepositoryBasePath() + commonFile.getSeparator() + artistEntity.getArtistName() + commonFile.getDot() + ImageFormat.JPG;
        File file = new File(artistArtworkFile);


        // Check whether file exists in the repository or not
        if( file.exists() ){
            throw new FileExistException( "File " + artistArtworkFile + " already exists in the repository of artist artworks." );
        }

        artistEntity.setArtistArtworkPath(artistEntity.getArtistName() + commonFile.getDot() + ImageFormat.JPG);

        // TODO: need to take care of this exception later.
        // write artwork into repository
        try{
            File finalArtistArtworkFile = new File( artistArtworkFile );
            artistArtwork.write(finalArtistArtworkFile);
        }catch ( Exception e ){
            e.printStackTrace();
        }

        Iterator itr = features.iterator();
        while( itr.hasNext() ){
            ArtistFeatureEntity artistFeatureEntity = (ArtistFeatureEntity)itr.next();
            artistFeatureEntity.setOwner( artistEntity );
        }

        artistEntity.setFeatureEntities( features );

        artistDA.insert( artistEntity );

    }

    public void addNewArtist(ArtistEntity artistEntity, String artistArtWorkPath, Set<ArtistFeatureEntity> features) throws
            ArtistExistException,
            FileExistException,
            FileNotExistsException {


        //Artist already Exist
        ArtistEntity realArtistEntity = artistDA.getArtistByName( artistEntity );
        if(  realArtistEntity != null )
            throw new ArtistExistException( "Artist with name " + artistEntity.getArtistName() + " does exist in the system!" );

        //Check to see if Artist Artwork file already exist
        File source = new File(artistArtWorkPath);
        if(!source.exists())
            throw new FileExistException("The file with path "+ artistArtWorkPath + " does not exist.");


        String artistArtworkFile = commonFile.getArtistArtworkRepositoryBasePath() + commonFile.getSeparator() + artistEntity.getArtistName() + commonFile.getDot() + ImageFormat.JPG;
        File file = new File(artistArtworkFile);


        // Check whether file exists in the repository or not
        if( file.exists() ){
            throw new FileExistException( "File " + artistArtworkFile + " already exists in the repository of artist artworks." );
        }

        artistEntity.setArtistArtworkPath(artistEntity.getArtistName() + commonFile.getDot() + ImageFormat.JPG);

        File sourceFile = new File( artistArtWorkPath );
        File destinationFile = new File( artistArtworkFile );

        try{
            FileUtils.copyFile( sourceFile, destinationFile );
        }catch ( Exception e ){
            e.printStackTrace();
        }

        Iterator itr = features.iterator();
        while( itr.hasNext() ){
            ArtistFeatureEntity artistFeatureEntity = (ArtistFeatureEntity)itr.next();
            artistFeatureEntity.setOwner( artistEntity );
        }

        artistEntity.setFeatureEntities( features );

        artistDA.insert( artistEntity );


    }

    public List<ArtistEntity> getAllArtists(){
        return artistDA.get();
    }

    public void deleteArtist( ArtistEntity artistEntity ) throws
            ArtistNotExistException,
            FileNotExistsException{

        // Check existence of artist
        ArtistEntity realArtistEntity = artistDA.getArtistByName(artistEntity);
        if( realArtistEntity == null )
            throw new ArtistNotExistException( "Artist " + artistEntity.getArtistName() + " does not exist in the system" );

        // Check existence of it's artwork
        String artworkPath = commonFile.getArtistArtworkRepositoryBasePath() + commonFile.getSeparator() + realArtistEntity.getArtistArtworkPath();
        File file = new File( artworkPath );
        if( !file.exists() )
            throw new FileNotExistsException( "File " + realArtistEntity.getArtistArtworkPath() + " does not exist in the system!" );

        // delete artist from DB
        artistDA.delete( realArtistEntity );

        // delete artist artwork from storage
        file.delete();

    }

    public void removeAlbumFromArtist( ArtistEntity artistEntity, AlbumEntity albumEntity ) throws
            AlbumNotExistException,
            ArtistNotExistException{

        // get real artist entity
        ArtistEntity realArtistEntity = artistDA.getArtistByName( artistEntity );
        AlbumEntity realAlbumEntity = albumDA.getAlbumByName( albumEntity );

        if( realAlbumEntity == null )
            throw new AlbumNotExistException( "There is no album with name " + albumEntity.getName() );

        if( realArtistEntity == null )
            throw new ArtistNotExistException( "There is no artist with name " + artistEntity.getArtistName() );


        Iterator itr = realArtistEntity.getAlbums().iterator();
        while( itr.hasNext() ){
            AlbumEntity temp = (AlbumEntity)itr.next();
            if( temp.getName().equals( realAlbumEntity.getName() ) ){
                realArtistEntity.getAlbums().remove(temp);
                realAlbumEntity.getArtists().remove(realArtistEntity);
                break;
            }
        }

        artistDA.update(realArtistEntity);
        albumDA.update(realAlbumEntity);

    }

    public ArtistEntity getArtist(ArtistEntity artistEntity) throws
            ArtistNotExistException {

        ArtistEntity realArtistEntity = artistDA.getArtistByName( artistEntity );
        if( realArtistEntity == null )
            throw new ArtistNotExistException( "There is no artist with name " + artistEntity.getArtistName() );

        ArtistEntity result = new ArtistEntity();

        result.setArtistID( realArtistEntity.getArtistID() );
        result.setArtistName( realArtistEntity.getArtistName() );
        result.setArtistArtworkPath( realArtistEntity.getArtistArtworkPath() );
        result.setArtistInfo( realArtistEntity.getArtistInfo() );

        return result;

    }

    public String changeArtistName(ArtistEntity artistEntity) throws
            ArtistNotExistException{

        ArtistEntity realArtistEntity = artistDA.get( artistEntity.getArtistID() );
        if( realArtistEntity == null )
            throw new ArtistNotExistException( "There is no artist with id " + artistEntity.getArtistID() );

        realArtistEntity.setArtistName( artistEntity.getArtistName() );

        artistDA.update( realArtistEntity );

        return artistEntity.getArtistName();

    }

    public String changeArtistInfo( ArtistEntity artistEntity ) throws
            ArtistNotExistException{

        ArtistEntity realArtistEntity = artistDA.get( artistEntity.getArtistID() );
        if( realArtistEntity == null )
            throw new ArtistNotExistException( "There is not artist with id " + artistEntity.getArtistID() );

        realArtistEntity.setArtistInfo( artistEntity.getArtistInfo() );

        artistDA.update( realArtistEntity );

        return artistEntity.getArtistInfo();

    }

}
