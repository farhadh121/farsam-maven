package com.radio.svc.logic;

import com.radio.entity.hibernate.AlbumEntity;
import com.radio.entity.hibernate.AlbumFeatureEntity;
import com.radio.entity.hibernate.ArtistEntity;
import com.radio.entity.hibernate.RecordLabelEntity;
import com.radio.svc.common.CommonFile;
import com.radio.svc.common.ImageFormat;
import com.radio.svc.dalc.IAlbumDA;
import com.radio.svc.dalc.IArtistDA;
import com.radio.svc.dalc.IRecordLabelDA;
import com.radio.svc.exceptions.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import java.io.File;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/27/14
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class AlbumLogic {

    public Log logger = new Log4JLogger(this.getClass().getName());

    ///////////////////////////////////////////////////////////////

    private IAlbumDA albumDA;
    private IRecordLabelDA recordLabelDA;
    private IArtistDA artistDA;
    private CommonFile commonFile;
    private ImageFormat imageFormat;
    private ArtistLogic artistLogic;

    public ImageFormat getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(ImageFormat imageFormat) {
        this.imageFormat = imageFormat;
    }

    public IAlbumDA getAlbumDA() {
        return albumDA;
    }

    public void setAlbumDA(IAlbumDA albumDA) {
        this.albumDA = albumDA;
    }

    public IRecordLabelDA getRecordLabelDA() {
        return recordLabelDA;
    }

    public void setRecordLabelDA(IRecordLabelDA recordLabelDA) {
        this.recordLabelDA = recordLabelDA;
    }

    public IArtistDA getArtistDA() {
        return artistDA;
    }

    public void setArtistDA(IArtistDA artistDA) {
        this.artistDA = artistDA;
    }

    public CommonFile getCommonFile() {
        return commonFile;
    }

    public void setCommonFile(CommonFile commonFile) {
        this.commonFile = commonFile;
    }

    public Log getLogger() {
        return logger;
    }

    public void setLogger(Log logger) {
        this.logger = logger;
    }

    public ArtistLogic getArtistLogic() {
        return artistLogic;
    }

    public void setArtistLogic(ArtistLogic artistLogic) {
        this.artistLogic = artistLogic;
    }

    ////////////////////////////////////////////////////////////////////////


    public void addNewAlbum(AlbumEntity albumEntity, RecordLabelEntity recordLabelEntity, Set<ArtistEntity> artistEntitySet, FileItem albumArtworkFile, Set<AlbumFeatureEntity> features) throws
            AlbumExistsException,
            RecordLabelNotExistsException,
            ArtistNotExistException,
            FileExistException{

        // Check Existence of record label entity
        RecordLabelEntity realRecordLabel = recordLabelDA.getRecordLabelByName(recordLabelEntity);
        if( realRecordLabel == null )
            throw new RecordLabelNotExistsException( "There is no record label with name " + recordLabelEntity.getName() );

        // Check for existence of all artists
        Set<ArtistEntity> realArtistEntities = new HashSet<ArtistEntity>();
        Iterator itr = artistEntitySet.iterator();
        while( itr.hasNext() ){
            ArtistEntity temp = (ArtistEntity)itr.next();
            ArtistEntity realTemp = artistDA.getArtistByName( temp );
            if( realTemp == null )
                throw new ArtistNotExistException( "Artist " + temp.getArtistName() + " does not exist in the system!" );

            realArtistEntities.add(realTemp);
        }

        // check for existence of such an album with the same name and same artists
        AlbumEntity temp = albumDA.getAlbumByAlbumNameAndArtistNames(albumEntity, realArtistEntities);
        if( temp != null )
            throw new AlbumExistsException( "Album with name " + temp.getName() + " does exist in the system!" );

        // Check for existence of artwork file
        String fileName = albumEntity.getName();
        itr = realArtistEntities.iterator();
        while( itr.hasNext() ){
            fileName = fileName + commonFile.getDash() + ((ArtistEntity)itr.next()).getArtistName();
        }
        fileName += commonFile.getDot();
        fileName += imageFormat.JPG;

        String absoluteFileName = commonFile.getAlbumArtworkRepositoryBasePath() + commonFile.getSeparator() + fileName;

        File tempFile = new File( absoluteFileName );
        if( tempFile.exists() )
            throw new FileExistException( "File name " + fileName + " does exist in the system!" );

        // Writing artwork file on the disk
        // TODO: We need to handle this exception in the future
        try {
            albumArtworkFile.write(tempFile);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        albumEntity.setAlbumArtworkPath(fileName);
        albumEntity.setArtists(realArtistEntities);
        albumEntity.setRecordLabelEntity(realRecordLabel);

        itr = features.iterator();
        while( itr.hasNext() ){
            AlbumFeatureEntity featureEntity = (AlbumFeatureEntity)itr.next();
            featureEntity.setOwner( albumEntity );
        }
        albumEntity.setFeatureEntities( features );

        albumDA.insert(albumEntity);

        realRecordLabel.getAlbums().add(albumEntity);
        itr = realArtistEntities.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            artistEntity.getAlbums().add(albumEntity);
            artistDA.update( artistEntity );
        }

        recordLabelDA.update(realRecordLabel);

    }

    public void addNewAlbum(AlbumEntity albumEntity, RecordLabelEntity recordLabelEntity, Set<ArtistEntity> artistEntitySet, String albumArtworkPath, Set<AlbumFeatureEntity> features) throws
            AlbumExistsException,
            RecordLabelNotExistsException,
            ArtistNotExistException,
            FileExistException,
            FileNotExistsException{

        // Check Existence of record label entity
        RecordLabelEntity realRecordLabel = recordLabelDA.getRecordLabelByName(recordLabelEntity);
        if( realRecordLabel == null )
            throw new RecordLabelNotExistsException( "There is no record label with name " + recordLabelEntity.getName() );

        // Check for existence of all artists
        Set<ArtistEntity> realArtistEntities = new HashSet<ArtistEntity>();
        Iterator itr = artistEntitySet.iterator();
        while( itr.hasNext() ){
            ArtistEntity temp = (ArtistEntity)itr.next();
            ArtistEntity realTemp = artistDA.getArtistByName( temp );
            if( realTemp == null )
                throw new ArtistNotExistException( "Artist " + temp.getArtistName() + " does not exist in the system!" );

            realArtistEntities.add(realTemp);
        }

        // check for existence of such an album with the same name and same artists
        AlbumEntity temp = albumDA.getAlbumByAlbumNameAndArtistNames(albumEntity, realArtistEntities);
        if( temp != null )
            throw new AlbumExistsException( "Album with name " + temp.getName() + " does exist in the system!" );

        // Check for existence of artwork file
        String fileName = albumEntity.getName();
        itr = realArtistEntities.iterator();
        while( itr.hasNext() ){
            fileName = fileName + commonFile.getDash() + ((ArtistEntity)itr.next()).getArtistName();
        }
        fileName += commonFile.getDot();
        fileName += imageFormat.JPG;

        String absoluteFileName = commonFile.getAlbumArtworkRepositoryBasePath() + commonFile.getSeparator() + fileName;

        File tempFile = new File( absoluteFileName );
        if( tempFile.exists() )
            throw new FileExistException( "File name " + fileName + " does exist in the system!" );

        //Copy the original file to the base folder
        String sourcePath =  albumArtworkPath;
        String destinationPath = absoluteFileName;

        File source = new File(sourcePath);
        if( !source.exists() )
            throw new FileNotExistsException( "Source file with name " + sourcePath + " does not exist in the system!" );
        File destination = new File( destinationPath );
        try{
            FileUtils.copyFile(source, destination);
        }catch (Exception e){
            e.printStackTrace();
        }

         //Final adding shit to database
        albumEntity.setAlbumArtworkPath(fileName);
        albumEntity.setArtists(realArtistEntities);
        albumEntity.setRecordLabelEntity(realRecordLabel);

        itr = features.iterator();
        while( itr.hasNext() ){
            AlbumFeatureEntity featureEntity = (AlbumFeatureEntity)itr.next();
            featureEntity.setOwner( albumEntity );
        }
        albumEntity.setFeatureEntities( features );

        albumDA.insert(albumEntity);

        realRecordLabel.getAlbums().add(albumEntity);
        itr = realArtistEntities.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            artistEntity.getAlbums().add(albumEntity);
            artistDA.update( artistEntity );
        }

        recordLabelDA.update(realRecordLabel);

    }

    public List<AlbumEntity> getAllAlbums(){

        return albumDA.get();

    }

    public void deleteAlbum( AlbumEntity albumEntity ) throws
            AlbumNotExistException,
            FileNotExistsException,
            SongsListNotEmptyException,
            ArtistNotExistException{

        // First check existence of the album
        AlbumEntity realAlbumEntity = albumDA.getAlbumByName( albumEntity );
        if( realAlbumEntity == null )
            throw new AlbumNotExistException( "Album " + albumEntity.getName() + " does not exist in the system!" );

        // Check to see whether it has any other songs or not
        if( realAlbumEntity.getSongs().size() > 0 )
            throw new SongsListNotEmptyException( "Song list of album " + albumEntity.getName() + " is not empty. First all it's songs should be deleted." );

        // check existence of album artwork
        String albumArtworkAddress = commonFile.getAlbumArtworkRepositoryBasePath() + commonFile.getSeparator() + realAlbumEntity.getAlbumArtworkPath();
        File artwork = new File( albumArtworkAddress );
        if( !artwork.exists() )
            throw new FileNotExistsException( "File " + realAlbumEntity.getAlbumArtworkPath() + " does not exist in the system!" );

        // deleting file from storage
        artwork.delete();

        // detaching artists from this album

        Set<ArtistEntity> albumArtists = realAlbumEntity.getArtists();
        Iterator itr = albumArtists.iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            artistLogic.removeAlbumFromArtist(artistEntity, albumEntity);
            //System.out.println( "number of albums is:" + artistEntity.getAlbums().size() );
            //artistDA.update(artistEntity);
            itr = albumArtists.iterator();
        }


        // delete its object from database
        albumDA.delete( realAlbumEntity );

    }

    public List<ArtistEntity> getAllArtists( AlbumEntity albumEntity ) throws AlbumNotExistException {

        AlbumEntity realAlbumEntity = albumDA.getAlbumByName( albumEntity );
        if( realAlbumEntity == null )
            throw new AlbumNotExistException( "Album " + albumEntity.getName() + " does not exist in the system!" );

        List<ArtistEntity> artists = new LinkedList<ArtistEntity>();

        Iterator itr = realAlbumEntity.getArtists().iterator();
        while( itr.hasNext() ){
            ArtistEntity artistEntity = (ArtistEntity)itr.next();
            artists.add(new ArtistEntity(artistEntity));
        }

        //System.out.println( "number of artists is " + artists.size() );

        return artists;

    }

    public RecordLabelEntity getRecordLabel( AlbumEntity albumEntity ) throws AlbumNotExistException {

        AlbumEntity realAlbumEntity = albumDA.getAlbumByName( albumEntity );
        if( realAlbumEntity == null )
            throw new AlbumNotExistException( "Album " + albumEntity.getName() + " does not exist in the system!" );

        RecordLabelEntity recordLabelEntity = new RecordLabelEntity(realAlbumEntity.getRecordLabelEntity());

        return recordLabelEntity;

    }

    public String changeAlbumName(AlbumEntity albumEntity) throws AlbumNotExistException{

        AlbumEntity realAlbumEntity = albumDA.get( albumEntity.getAlbumID() );
        if( realAlbumEntity == null )
            throw new AlbumNotExistException( "There is no album with id " + albumEntity.getAlbumID() );

        realAlbumEntity.setName( albumEntity.getName() );

        albumDA.update( realAlbumEntity );

        return albumEntity.getName();

    }

    public String changeAlbumRecordLabel(AlbumEntity albumEntity, RecordLabelEntity recordLabelEntity) throws
            AlbumNotExistException,
            RecordLabelNotExistsException {

        AlbumEntity realAlbumEntity = albumDA.get( albumEntity.getAlbumID() );
        if( realAlbumEntity == null )
            throw new AlbumNotExistException( "There is not album with id " + albumEntity.getAlbumID() );

        RecordLabelEntity realRecordLabel = recordLabelDA.getRecordLabelByName( recordLabelEntity );
        if( realRecordLabel == null )
            throw new RecordLabelNotExistsException( "There is no record label name " + recordLabelEntity.getName() );


        RecordLabelEntity currentRecordLabel = realAlbumEntity.getRecordLabelEntity();
        currentRecordLabel.getAlbums().remove( realAlbumEntity );

        realAlbumEntity.setRecordLabelEntity( null );

        albumDA.update( realAlbumEntity );
        recordLabelDA.update( currentRecordLabel );

        realAlbumEntity.setRecordLabelEntity( realRecordLabel );
        realRecordLabel.getAlbums().add( realAlbumEntity );

        albumDA.update( realAlbumEntity );
        recordLabelDA.update( currentRecordLabel );

        return realRecordLabel.getName();

    }


    public String changeAlbumReleaseDate(AlbumEntity albumEntity, Date releaseDate) throws
            AlbumNotExistException{

        AlbumEntity realAlbumEntity = albumDA.get( albumEntity.getAlbumID() );
        if( realAlbumEntity == null )
            throw new AlbumNotExistException( "There is no album with id " + albumEntity.getAlbumID() );

        realAlbumEntity.setReleaseDate( releaseDate );
        albumDA.update( realAlbumEntity );

        return releaseDate.toString();

    }

    public AlbumEntity getAlbumByName( AlbumEntity albumEntity ) throws
            AlbumNotExistException{

        AlbumEntity realAlbumEntity = albumDA.getAlbumByName( albumEntity );
        if( realAlbumEntity == null )
            throw new AlbumNotExistException( "There is not album with name " + albumEntity.getName() );

        return realAlbumEntity;

    }


}
