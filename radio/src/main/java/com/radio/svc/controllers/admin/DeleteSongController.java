package com.radio.svc.controllers.admin;

import com.radio.svc.serviceinterface.ISongServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 6/14/14
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteSongController extends AbstractController {

    ISongServiceProvider songServiceProvider;

    public ISongServiceProvider getSongServiceProvider() {
        return songServiceProvider;
    }

    public void setSongServiceProvider(ISongServiceProvider songServiceProvider) {
        this.songServiceProvider = songServiceProvider;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("/admin/songadmin");
        model.addObject( "controller", "deletesong" );

        String songIdString = request.getParameter("songid");

        try{
            songServiceProvider.deleteSong( Long.valueOf( songIdString ) );
            model.addObject("msg", "success");
        }catch ( Exception e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }

        return model;

    }

}
