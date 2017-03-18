package com.radio.svc.controllers.admin;

import com.radio.entity.hibernate.SongEntity;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by farhad on 9/23/14.
 */
public class SearchSongController extends AbstractController {

    private ISongServiceProvider songServiceProvider;

    public ISongServiceProvider getSongServiceProvider() {
        return songServiceProvider;
    }

    public void setSongServiceProvider(ISongServiceProvider songServiceProvider) {
        this.songServiceProvider = songServiceProvider;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws
            Exception {

        ModelAndView model = new ModelAndView("/admin/songadmin");
        model.addObject("controller", "getsong");
        String songName = request.getParameter("songname");

        try{
            SongEntity songEntity = songServiceProvider.getSongByName( songName );
            model.addObject("msg", "success");
            model.addObject("songobject", songEntity);
        }catch (Exception e){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }

        return model;

    }
}
