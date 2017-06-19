package com.radio.svc.controllers.admin;

import com.radio.svc.exceptions.ArtistExistException;
import com.radio.svc.exceptions.FileExistException;
import com.radio.svc.exceptions.RecordLabelExistsException;
import com.radio.svc.serviceinterface.IRecordLabelServiceProvider;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/26/14
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddRecordLabelController extends AbstractController {

    IRecordLabelServiceProvider recordLabelServiceProvider;

    public IRecordLabelServiceProvider getRecordLabelServiceProvider() {
        return recordLabelServiceProvider;
    }

    public void setRecordLabelServiceProvider(IRecordLabelServiceProvider recordLabelServiceProvider) {
        this.recordLabelServiceProvider = recordLabelServiceProvider;
    }

    //////////////////////////////////////////////////////////////////////

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String recordLabelName = null;
        FileItem recordLabelArtworkFile = null;

        if( ServletFileUpload.isMultipartContent(request) ){

            try{
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for( FileItem item : multiparts ){
                    if( !item.isFormField() ){

                        if( item.getFieldName().equals("recordlabelupload") ){
                            recordLabelArtworkFile = item;
                        }

                    }else{
                        if( item.getFieldName().equals("recordlabelname") ){
                            recordLabelName = item.getString();
                            //System.out.println( "Record Label Name " + item.getString() );
                        }
                    }
                }
            }catch ( Exception e ){
                e.printStackTrace();
            }

        }

        ModelAndView model;
        model = new ModelAndView("/admin/recordlabeladmin");
        model.addObject("controller", "addrecordlabel");
        try{
            recordLabelServiceProvider.addNewRecordLabel(recordLabelName, recordLabelArtworkFile);
            model.addObject("msg", "success");
        }catch ( RecordLabelExistsException e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage() );
        }catch ( FileExistException e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage() );
        }

        return model;

    }

}
