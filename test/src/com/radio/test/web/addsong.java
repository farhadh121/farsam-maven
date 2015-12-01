package com.radio.test.web;

import com.radio.svc.serviceinterface.ISongServiceProvider;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/16/14
 * Time: 6:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class addsong extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String songName = null;
        String artistName = null;
        String lyric = null;
        FileItem songFile = null;
        FileItem artworkFile = null;


        if( ServletFileUpload.isMultipartContent(req) ){

            try{
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);

                for( FileItem item : multiparts ){
                    if( !item.isFormField() ){
                        /*
                        name = new File( item.getName() ).getName();
                        System.out.println( name );
                        File outFile = new File( name);
                        item.write(outFile);
                        */

                        //System.out.println( "It is not a form field " + item.getName() + item.getFieldName() );

                        if( item.getName().equals("inputSongFile") ){
                            songFile = item;
                        }else if( item.getName().equals("inputArtworkFile") ){
                            artworkFile = item;
                        }

                    }else{
                        if( item.getFieldName().equals("inputSongName") ){
                            songName = item.getString();
                            System.out.println( "Song name " + item.getString() );
                        }else if( item.getFieldName().equals("inputArtistName") ){
                            artistName = item.getString();
                            System.out.println( "Artist name " + item.getString() );
                        }else if( item.getFieldName().equals("inputSongLyric") ){
                            lyric = item.getString();
                            System.out.println( "Lyric name " + item.getString() );
                        }
                    }
                }

                ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext( getServletContext() );
                ISongServiceProvider songServiceProvider = (ISongServiceProvider)context.getBean("songFacade");
                Set<String> artists = new HashSet<String>();
                artists.add(artistName);

                //songServiceProvider.addNewSong(songName, artists, lyric, songFile, artworkFile);


            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
