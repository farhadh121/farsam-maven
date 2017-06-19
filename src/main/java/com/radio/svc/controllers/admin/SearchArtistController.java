package com.radio.svc.controllers.admin;

import com.radio.entity.hibernate.ArtistEntity;
import com.radio.svc.serviceinterface.IArtistServiceProvider;
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
 * User: saman
 * Date: 5/31/14
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchArtistController extends AbstractController {

    IArtistServiceProvider artistServiceProvider;

    public IArtistServiceProvider getArtistServiceProvider() {
        return artistServiceProvider;
    }

    public void setArtistServiceProvider(IArtistServiceProvider artistServiceProvider) {
        this.artistServiceProvider = artistServiceProvider;
    }

    ////////////////////////////////////////////////////////////

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView( "/admin/artistadmin" );
        model.addObject( "controller", "searchartist" );
        String artistName = request.getParameter( "artistname" );

        try{

            ArtistEntity artistEntity = artistServiceProvider.getArtist( artistName );
            model.addObject( "artistobject", artistEntity );
            model.addObject( "msg", "success" );
            return model;
        }catch ( Exception e ){
            e.printStackTrace();
            model.addObject( "msg", "failed" );
            model.addObject( "msgbody", e.getMessage() );
            model.addObject( "genreobject", null );
        }

        return model;

    }
}
