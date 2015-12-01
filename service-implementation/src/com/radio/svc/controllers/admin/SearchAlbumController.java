package com.radio.svc.controllers.admin;

import com.radio.entity.hibernate.AlbumEntity;
import com.radio.svc.serviceinterface.IAlbumServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by saman on 10/19/14.
 */
public class SearchAlbumController extends AbstractController {


    private IAlbumServiceProvider albumServiceProvider;

    public IAlbumServiceProvider getAlbumServiceProvider() {
        return albumServiceProvider;
    }

    public void setAlbumServiceProvider(IAlbumServiceProvider albumServiceProvider) {
        this.albumServiceProvider = albumServiceProvider;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws
            Exception {

        ModelAndView model = new ModelAndView( "/admin/albumadmin" );
        model.addObject( "controller", "searchalbum" );
        String albumName = httpServletRequest.getParameter( "albumname" );

        try{
            AlbumEntity albumEntity = albumServiceProvider.getAlbumByName( albumName );
            model.addObject( "albumobject", albumEntity );
            model.addObject( "msg", "success" );
        }catch ( Exception e ){
            model.addObject( "msg", "failed" );
            model.addObject( "msgbody", e.getMessage() );
            model.addObject( "albumobject", null );
        }

        return model;

    }
}
