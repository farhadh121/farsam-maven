/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radio.svc.controllers.admin;

import com.radio.svc.exceptions.FeatureExistException;
import com.radio.svc.exceptions.FileExistException;
import com.radio.svc.exceptions.RecordLabelExistsException;
import com.radio.svc.serviceinterface.IFeatureSSDServiceProvider;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author farhad
 */
public class AddFeatureSSDController extends AbstractController {

    IFeatureSSDServiceProvider featureSSDServiceProvider;
    ISongServiceProvider songServiceProvider;

    public IFeatureSSDServiceProvider getFeatureSSDServiceProvider() {
        return featureSSDServiceProvider;
    }

    public void setFeatureSSDServiceProvider(IFeatureSSDServiceProvider featureSSDServiceProvider) {
        this.featureSSDServiceProvider = featureSSDServiceProvider;
    }

    public ISongServiceProvider getSongServiceProvider() {
        return songServiceProvider;
    }

    public void setSongServiceProvider(ISongServiceProvider songServiceProvider) {
        this.songServiceProvider = songServiceProvider;
    }
    
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
         //To change body of generated methods, choose Tools | Templates.
        String[] ssdFeatures = null;
        FileItem ssdFeatureFile = null;
        String songName = null;

        if( ServletFileUpload.isMultipartContent(request) ){

            try{
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for( FileItem item : multiparts ){
                    if( !item.isFormField() ){

                        if( item.getFieldName().equals("ssdFeatureUpload") ){
                            ssdFeatureFile = item;
                            
                        }

                    }else{
                        if( item.getFieldName().equals("songname") ){
                            songName = item.getString();
                            //System.out.println( "Album Name  " + item.getString() );
                        }
                    }
                }
            }catch ( Exception e ){
                e.printStackTrace();
            }

        }

        ModelAndView model;
        model = new ModelAndView("/admin/featureSSDAdmin");
        model.addObject("controller", "addfeaturessd");
        featureSSDServiceProvider.addNewFeatureSSD(songName, ssdFeatureFile);
        model.addObject("msg", "success");

        return model;

    }
    
}
