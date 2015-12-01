package com.radio.svc.serviceinterface;

import com.radio.entity.hibernate.RecordLabelEntity;
import com.radio.svc.exceptions.FileExistException;
import com.radio.svc.exceptions.FileNotExistsException;
import com.radio.svc.exceptions.RecordLabelExistsException;
import com.radio.svc.exceptions.RecordLabelNotExistsException;
import org.apache.commons.fileupload.FileItem;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/26/14
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IRecordLabelServiceProvider extends Serializable {


    /**
     * Adds a new record label into the system
     * @param name                  name of the target record label
     * @param recordLabelFile       Image file of the target record label
     * @throws RecordLabelExistsException   throws when the record label already exists in the system
     */
    public void addNewRecordLabel( String name, FileItem recordLabelFile ) throws
            RecordLabelExistsException,
            FileExistException;
    /**
     * Adds a new record label into the system
     * @param name                          name of the target record label
     * @param recordLabelArtworkPath        Image file of the target record label
     * @throws RecordLabelExistsException   throws when the record label already exists in the system
     * @throws FileNotExistsException       throws when the file does not exist
     */
     public void addNewRecordLabel(String name, String recordLabelArtworkPath) throws
            RecordLabelExistsException,
            FileNotExistsException,
            FileExistException;


    /**
     * Returns a list of all record labels in the system
     * @return  list of all record labels
     */
    public List<RecordLabelEntity> getAllRecordLabels();

    /**
     * return absolute path of a record label entity
     * @param name                      input record label entity name
     * @return                          absolute path of the logo
     * @throws RecordLabelNotExistsException    throws when the record label does not exists
     */
    public String getRecordLableLogoAbsolutePath( String name ) throws
            RecordLabelNotExistsException;

    /**
     * deletes a record label from the system
     * @param name                              name of the target record label to be deleted
     * @throws RecordLabelNotExistsException    throws when the record label does not exists in the system
     * @throws FileNotExistsException           throws when the artwork file of the record label is not in the system
     */
    public void deleteRecordLabel( String name ) throws
            RecordLabelNotExistsException,
            FileNotExistsException;

    /**
     * Deletes all record labels
     */
    public void deleteAllRecordLabels( );


}

