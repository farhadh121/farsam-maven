package com.radio.svc.controllers.admin;

import com.radio.entity.hibernate.GenreEntity;
import com.radio.svc.serviceinterface.IGenreServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/31/14
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchGenreController extends AbstractController {

    IGenreServiceProvider genreServiceProvider;

    public IGenreServiceProvider getGenreServiceProvider() {
        return genreServiceProvider;
    }

    public void setGenreServiceProvider(IGenreServiceProvider genreServiceProvider) {
        this.genreServiceProvider = genreServiceProvider;
    }

    ///////////////////////////////////////////////////////

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView("/admin/genreadmin");
        String genreName = request.getParameter("genrename");

        try{
            GenreEntity genreEntity = genreServiceProvider.getGenreByName( genreName );
            modelAndView.addObject("msg", "success");
            modelAndView.addObject("genreobject", genreEntity);
        }catch (Exception e){
            modelAndView.addObject("msg", "failed");
            modelAndView.addObject("msgbody", e.getMessage());
            modelAndView.addObject("genreobject", null);
        }

        return modelAndView;

    }
}
