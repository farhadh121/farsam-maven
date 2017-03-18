package com.radio.svc.controllers.admin;

import com.radio.svc.serviceinterface.IAlbumServiceProvider;
import com.radio.svc.serviceinterface.IArtistServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/30/14
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteAlbumController extends AbstractController {

    IAlbumServiceProvider albumServiceProvider;

    public IAlbumServiceProvider getAlbumServiceProvider() {
        return albumServiceProvider;
    }

    public void setAlbumServiceProvider(IAlbumServiceProvider albumServiceProvider) {
        this.albumServiceProvider = albumServiceProvider;
    }

    ///////////////////////////////////////////////////////////////

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String albumName = null;
        albumName = request.getParameter("albumname");

        ModelAndView model = new ModelAndView("/admin/albumadmin");
        model.addObject("controller", "deletealbum");

        try{
            albumServiceProvider.deleteAlbum(albumName);
            model.addObject("msg", "success");
            model.addObject("msgbody", "Album " + albumName + " delete successfully!");
        }catch ( Exception e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }

        return model;

    }
}
