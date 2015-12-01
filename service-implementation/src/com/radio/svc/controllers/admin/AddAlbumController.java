package com.radio.svc.controllers.admin;

import com.radio.svc.serviceinterface.IAlbumServiceProvider;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/27/14
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddAlbumController extends AbstractController {

    IAlbumServiceProvider albumServiceProvider;

    public IAlbumServiceProvider getAlbumServiceProvider() {
        return albumServiceProvider;
    }

    public void setAlbumServiceProvider(IAlbumServiceProvider albumServiceProvider) {
        this.albumServiceProvider = albumServiceProvider;
    }

    ////////////////////////////////////////////////////////////////////////////////

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String albumName = null;
        String albumDateString = null;
        String recordLabelName = null;
        String recordLabelRelease = null;
        Date recordLabelReleaseDate = null;
        FileItem albumArtworkFile = null;
        Integer numberOfArtists = null;
        List<String> artistNames = new LinkedList<String>();
        int featurescount = 0;
        Map<String, String> features = new HashMap<String, String>();
        List<String> keys = new LinkedList<String>();
        List<String> values = new LinkedList<String>();

        if( ServletFileUpload.isMultipartContent(request) ){



            try{
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for( FileItem item : multiparts ){
                    if( !item.isFormField() ){

                        if( item.getFieldName().equals("albumupload") ){
                            albumArtworkFile = item;
                        }

                    }else{
                        if( item.getFieldName().equals("albumname") ){
                            albumName = item.getString();
                            //System.out.println( "Album Name  " + item.getString() );
                        }else if( item.getFieldName().equals("recordlabelname") ){
                            recordLabelName = item.getString();
                            //System.out.println( "Record Label Name " + item.getString() );
                        }else if( item.getFieldName().equals("recordlabelreleasedate") ){
                            recordLabelRelease = item.getString();
                            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                            recordLabelReleaseDate = formatter.parse(recordLabelRelease);
                        }else if( item.getFieldName().equals("count") ){
                            numberOfArtists = Integer.valueOf(item.getString());
                        }else if( item.getFieldName().startsWith("artistname") ){
                            String artistName = item.getString();
                            artistNames.add(artistName);
                        }else if( item.getFieldName().equals("textboxcount") ){
                            featurescount = Integer.valueOf( item.getString() );
                        }else if (item.getFieldName().startsWith("albumfeaturekey") ){
                            featurescount = 1;
                            int featureType = 0;
                           if ( item.getFieldName().equals("albumfeaturekey0"))
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
                        for( int i = 0; i < featurescount; i++ ){
                            if( item.getFieldName().equals("albumfeaturekey" + i) ){
                                keys.add( i, item.getString() );
                            }else if( item.getFieldName().equals("albumfeaturevalue" + i) ){
                                values.add( i, item.getString() );
                            }
                        }
                    }
                }

                for( int i = 0; i < featurescount; i++ ){
                    features.put( keys.get( i ), values.get( i ) );
                }

            }catch ( Exception e ){
                e.printStackTrace();
            }

        }

        ModelAndView model;
        model = new ModelAndView("/admin/albumadmin");
        model.addObject("controller", "addalbum");
        try{
            albumServiceProvider.addNewAlbum(albumName, recordLabelReleaseDate, recordLabelName, artistNames , albumArtworkFile, features);
            model.addObject("msg", "success");
        }catch ( Exception e ){
            e.printStackTrace();
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage() );
        }

        return model;

    }

}
