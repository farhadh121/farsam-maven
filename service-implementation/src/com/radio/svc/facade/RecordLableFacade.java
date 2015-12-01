package com.radio.svc.facade;

import com.radio.entity.hibernate.RecordLabelEntity;
import com.radio.svc.exceptions.FileExistException;
import com.radio.svc.exceptions.FileNotExistsException;
import com.radio.svc.exceptions.RecordLabelExistsException;
import com.radio.svc.exceptions.RecordLabelNotExistsException;
import com.radio.svc.logic.RecordLabelLogic;
import com.radio.svc.serviceinterface.IRecordLabelServiceProvider;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/26/14
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class RecordLableFacade implements IRecordLabelServiceProvider {

    public Log logger = new Log4JLogger(this.getClass().getName());

    ///////////////////////////////////////////////////////////////

    private RecordLabelLogic recordLabelLogic;

    public RecordLabelLogic getRecordLabelLogic() {
        return recordLabelLogic;
    }

    public void setRecordLabelLogic(RecordLabelLogic recordLabelLogic) {
        this.recordLabelLogic = recordLabelLogic;
    }

    //////////////////////////////////////////////////////////////////////////////

    @Override
    public void addNewRecordLabel(String name, FileItem recordLabelFile) throws
            RecordLabelExistsException,
            FileExistException{

        // creating temporary record label
        RecordLabelEntity recordLabelEntity = new RecordLabelEntity();
        recordLabelEntity.setName( name );

        // calling logic function
        recordLabelLogic.addNewRecordLabel(recordLabelEntity, recordLabelFile);

    }

    @Override
    public List<RecordLabelEntity> getAllRecordLabels() {

        return recordLabelLogic.getAllRecordLabels();

    }

    @Override
    public String getRecordLableLogoAbsolutePath(String name) throws RecordLabelNotExistsException {

        // Create temp record label entity
        RecordLabelEntity recordLabelEntity = new RecordLabelEntity();
        recordLabelEntity.setName(name);

        return recordLabelLogic.getRecordLableLogoAbsolutePath(recordLabelEntity);

    }

    @Override
    public void deleteRecordLabel(String name) throws RecordLabelNotExistsException, FileNotExistsException {

        // create temporary record lable file
        RecordLabelEntity recordLabelEntity = new RecordLabelEntity();
        recordLabelEntity.setName(name);

        recordLabelLogic.deleteRecordLabel(recordLabelEntity);

    }

    @Override
    public void addNewRecordLabel(String name, String recordLabelArtworkPath) throws RecordLabelExistsException, FileNotExistsException, FileExistException{

        //create temporary record label entity
        RecordLabelEntity recordLabelEntity = new RecordLabelEntity();
        recordLabelEntity.setName(name);

        recordLabelLogic.addNewRecordLabel(recordLabelEntity,recordLabelArtworkPath);
       }

    @Override
    public void deleteAllRecordLabels() {

        recordLabelLogic.deleteAllRecordLabels();

    }
}
