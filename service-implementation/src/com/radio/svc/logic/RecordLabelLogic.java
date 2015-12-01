package com.radio.svc.logic;

import com.radio.entity.hibernate.RecordLabelEntity;
import com.radio.svc.common.CommonFile;
import com.radio.svc.common.ImageFormat;
import com.radio.svc.dalc.IRecordLabelDA;
import com.radio.svc.exceptions.FileExistException;
import com.radio.svc.exceptions.FileNotExistsException;
import com.radio.svc.exceptions.RecordLabelExistsException;
import com.radio.svc.exceptions.RecordLabelNotExistsException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/26/14
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class RecordLabelLogic {

    public Log logger = new Log4JLogger(this.getClass().getName());

    ///////////////////////////////////////////////////////////////

    IRecordLabelDA recordLabelDA;
    CommonFile commonFile;
    ImageFormat imageFormat;

    public ImageFormat getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(ImageFormat imageFormat) {
        this.imageFormat = imageFormat;
    }

    public CommonFile getCommonFile() {
        return commonFile;
    }

    public void setCommonFile(CommonFile commonFile) {
        this.commonFile = commonFile;
    }

    public IRecordLabelDA getRecordLabelDA() {
        return recordLabelDA;
    }

    public void setRecordLabelDA(IRecordLabelDA recordLabelDA) {
        this.recordLabelDA = recordLabelDA;
    }

    ////////////////////////////////////////////////////////////////////////

    public void addNewRecordLabel( RecordLabelEntity recordLabelEntity, FileItem file ) throws
            RecordLabelExistsException,
            FileExistException{

        // Check whether the record label exists or not
        RecordLabelEntity temp = recordLabelDA.getRecordLabelByName(recordLabelEntity);
        if( temp != null )
            throw new RecordLabelExistsException( "Record label with name " + recordLabelEntity.getName() + " does exist in the system!" );

        // checking existence of its artwork in the file system.
        String artworkPath = commonFile.getRecordLabelArtworkRepositoryBasePath() + commonFile.getSeparator() + recordLabelEntity.getName() + commonFile.getDot() + imageFormat.JPG;
        File artworkFile = new File(artworkPath);
        if( artworkFile.exists() )
            throw new FileExistException( "Artwork of record label " + recordLabelEntity.getName() + " does exist in the system!" );

        // writing file in the repository
        // TODO: need to handle this in the future
        try {
            file.write(artworkFile);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        recordLabelEntity.setLogoPath( recordLabelEntity.getName() + commonFile.getDot() + imageFormat.JPG );
        recordLabelDA.insert(recordLabelEntity);

    }

    public void addNewRecordLabel(RecordLabelEntity recordLabelEntity, String recordLabelArtworkPath) throws
            RecordLabelExistsException,
            FileNotExistsException,
            FileExistException{

        // Check whether the record label exists or not
        RecordLabelEntity temp =  recordLabelDA.getRecordLabelByName(recordLabelEntity);
        if( temp != null )
            throw new RecordLabelExistsException("The record label with name" + recordLabelEntity.getName() + " exist in the system");

        // Check existence of source and destination
        File source = new File(recordLabelArtworkPath);
        if(!source.exists())
            throw new FileNotExistsException("The file with path "+ recordLabelArtworkPath + " does not exist.");

        File destenation = new File(commonFile.getRecordLabelArtworkRepositoryBasePath() + commonFile.getSeparator() + recordLabelEntity.getName() + commonFile.getDot() + imageFormat.JPG);
        if(destenation.exists())
            throw new FileExistException( "The destination file with path " + commonFile.getRecordLabelArtworkRepositoryBasePath() + commonFile.getSeparator() + recordLabelEntity.getName() + commonFile.getDot() + imageFormat.JPG + " Does exist in the system!" );
        // Add file and entity
        recordLabelEntity.setLogoPath(recordLabelEntity.getName() + commonFile.getDot() + imageFormat.JPG);
        recordLabelDA.insert(recordLabelEntity);

        try{
            FileUtils.copyFile( source, destenation );
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public List<RecordLabelEntity> getAllRecordLabels(){

        return recordLabelDA.get();

    }

    public String getRecordLableLogoAbsolutePath( RecordLabelEntity recordLabelEntity ) throws
            RecordLabelNotExistsException{

        // Search for the record Label entity
        RecordLabelEntity result = recordLabelDA.getRecordLabelByName(recordLabelEntity);
        if( result == null )
            throw new RecordLabelNotExistsException( "Record label with name " + recordLabelEntity.getName() + " does not exists in the system!" );

        // Create an absolute path for the record label artwork
        String absolutePath = commonFile.getRecordLabelArtworkRepositoryBasePath() + commonFile.getSeparator() + result.getLogoPath();

        return absolutePath;

    }

    public void deleteRecordLabel( RecordLabelEntity recordLabelEntity ) throws
            RecordLabelNotExistsException,
            FileNotExistsException{

        // Search for the record label entity
        RecordLabelEntity result = recordLabelDA.getRecordLabelByName(recordLabelEntity);

        if( result == null )
            throw new RecordLabelNotExistsException( "Record label with name " + recordLabelEntity.getName() + " does not exist in the system!" );

        // Delete from database
        recordLabelDA.delete( result );

        File file = new File( commonFile.getRecordLabelArtworkRepositoryBasePath() + commonFile.getSeparator() + result.getLogoPath() );
        if( !file.exists() )
            throw new FileNotExistsException( "File with name " + result.getLogoPath() + " does not exist in the repository!" );

        file.delete();

    }

    public void deleteAllRecordLabels(){

        List<RecordLabelEntity> recordLabelEntities = recordLabelDA.get();
        Iterator itr = recordLabelEntities.iterator();

        while( itr.hasNext() ){
            RecordLabelEntity current = (RecordLabelEntity)itr.next();
            recordLabelDA.delete( current.getRecordLabelID() );
        }

    }

}
