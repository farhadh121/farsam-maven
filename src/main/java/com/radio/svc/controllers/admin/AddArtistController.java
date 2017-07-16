package com.radio.svc.controllers.admin;

import com.radio.svc.exceptions.ArtistExistException;
import com.radio.svc.exceptions.FileExistException;
import com.radio.svc.serviceinterface.IArtistServiceProvider;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/17/14
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddArtistController extends AbstractController {

    private IArtistServiceProvider artistServiceProvider;

    public IArtistServiceProvider getArtistServiceProvider() {
        return artistServiceProvider;
    }

    public void setArtistServiceProvider(IArtistServiceProvider artistServiceProvider) {
        this.artistServiceProvider = artistServiceProvider;
    }

    //////////////////////////////////////////////////////////////////////////////

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String artistName = null;
        String artistInfo = null;
        FileItem artistArtworkFile = null;
        int featuresCount = 0;
        Map<String, String> features = null;
        List<String> keys = new LinkedList<String>();
        List<String> values = new LinkedList<String>();

        if( ServletFileUpload.isMultipartContent(request) ){

            try{
                List<FileItem>  multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for( FileItem item : multiparts ){
                    if( !item.isFormField() ){

                        if( item.getFieldName().equals("artistupload") ){
                            //System.out.println( "artist upload." );
                            artistArtworkFile = item;
                        }

                    }else{
                        if( item.getFieldName().equals("artistname") ){
                            artistName = item.getString();
                            //System.out.println( "Artist Name  " + item.getString() );
                        }else if( item.getFieldName().equals("artistinformation") ){
                            artistInfo = item.getString();
                            //System.out.println( "Artist name " + item.getString() );
                        }else if( item.getFieldName().equals("featurescount") ){
                            featuresCount = Integer.valueOf(item.getString());
                        }else if (item.getFieldName().startsWith("featureartistkey") ){
                            featuresCount = 1;
                            int featureType = 0;
                           if ( item.getFieldName().equals("featureartistkey0"))
                               featureType = 1;
                           else
                               featureType = 2;
                            switch(featureType){
                                case 1:keys.add( item.getString() );
                                    break;
                                case 2: values.add( item.getString() ); 
                                    break;
                            }
                        }
                    }
                }

                

                for( FileItem item : multiparts ){
                    if( item.isFormField() ){
                        for( int i = 0; i < featuresCount; i++ ){
                            if( item.getFieldName().equals("featureartistkey"+i) ){
                                keys.add(i, item.getString());
                            }
                            else if( item.getFieldName().equals("featureartistvalue"+i) ){
                                values.add(i, item.getString());
                            }
                        }
                    }
                }

                features = new HashMap<String, String>();

                for( int i = 0; i < featuresCount; i++ ){
                    features.put(keys.get(i), values.get(i));
                }

            }catch ( Exception e ){
                e.printStackTrace();
            }

        }

        ModelAndView model;
        model = new ModelAndView("/admin/artistadmin");
        model.addObject("controller", "addartist");
        try{
            artistServiceProvider.addNewArtist(artistName, artistInfo, artistArtworkFile, features);
            model.addObject("msg", "success");
        }catch ( ArtistExistException e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage() );
        }catch ( FileExistException e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage() );
        }

        return model;



    }
}
