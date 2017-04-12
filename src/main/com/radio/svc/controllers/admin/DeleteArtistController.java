package com.radio.svc.controllers.admin;

import com.radio.svc.serviceinterface.IArtistServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/31/14
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteArtistController extends AbstractController {

    IArtistServiceProvider artistServiceProvider;

    public IArtistServiceProvider getArtistServiceProvider() {
        return artistServiceProvider;
    }

    public void setArtistServiceProvider(IArtistServiceProvider artistServiceProvider) {
        this.artistServiceProvider = artistServiceProvider;
    }

    //////////////////////////////////////////////////////////////////////

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView( "/admin/artistadmin" );
        model.addObject("controller", "deleteartist");

        String artistName = request.getParameter("artistname");

        try{
            artistServiceProvider.deleteArtist( artistName );
            model.addObject("msg", "success");
        }catch ( Exception e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }

        return model;

    }
}
