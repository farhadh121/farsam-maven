package com.radio.svc.controllers.admin;

import com.radio.svc.serviceinterface.ISongServiceProvider;
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
 * Date: 5/11/14
 * Time: 6:40 PM
 * To change this template use CommonFile | Settings | CommonFile Templates.
 */

public class AddSongController extends AbstractController {

    ISongServiceProvider songServiceProvider;

    public ISongServiceProvider getSongServiceProvider() {
        return songServiceProvider;
    }

    public void setSongServiceProvider(ISongServiceProvider songServiceProvider) {
        this.songServiceProvider = songServiceProvider;
    }

    ///////////////////////////////////////////////////////////////

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("/admin/songadmin");
        model.addObject("controller", "addsong");

        String songName = null;
        Set<String> artistNames = new HashSet<String>();
        FileItem songFile = null;
        FileItem songArtwork = null;
        String lyrics = null;
        String genre = null;
        String album = null;
        int featurescount = 0;
        Map<String, String> features = new HashMap<String, String>();
        List<String> keys = new LinkedList<String>();
        List<String> values = new LinkedList<String>();


        if( ServletFileUpload.isMultipartContent(request) ){

            try{
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for( FileItem item : multiparts ){
                    if( !item.isFormField() ){

                        if( item.getFieldName().equals("uploadsong") ){
                            songFile = item;
                        }
                        else if( item.getFieldName().equals("uploadartwork") ){
                            songArtwork = item;
                        }

                    }else{
                        if( item.getFieldName().equals("songname") ){
                            songName = item.getString();
                            //System.out.println( "Album Name  " + item.getString() );
                        }else if( item.getFieldName().equals("albumname") ){
                            album = item.getString();
                        }else if( item.getFieldName().startsWith("artistname") ){
                            String artistName = item.getString();
                            artistNames.add(artistName);
                        }else if( item.getFieldName().equals("genre") ){
                            genre = item.getString();
                        }else if( item.getFieldName().equals("lyrics") ){
                            lyrics = item.getString();
                        }else if( item.getFieldName().equals("textboxcount") ){
                            featurescount = Integer.valueOf(item.getString());
                        }else if (item.getFieldName().startsWith("songfeaturekey") ){
                            featurescount = 1;
                            int featureType = 0;
                           if ( item.getFieldName().equals("songfeaturekey0"))
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
                            if( item.getFieldName().equals("songfeaturekey"+i) )  {
                                keys.add( item.getString() );
                            }else if( item.getFieldName().equals("songfeaturevalue"+i) ){
                                values.add( item.getString() );
                            }
                        }
                    }
                }

                for( int i = 0; i < featurescount; i++ ){
                    features.put( keys.get(i), values.get(i) );
                }
            }catch ( Exception e ){
                e.printStackTrace();
            }
        }

        try{
            songServiceProvider.addNewSong(songName, artistNames, lyrics, genre, album, songFile, songArtwork, features);
            model.addObject( "msg", "success" );
        }catch ( Exception e ){
            e.printStackTrace();
            model.addObject( "msg", "failed" );
            model.addObject( "msgbody", e.getMessage() );
        }

        return model;

    }
}
