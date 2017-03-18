package com.radio.svc.controllers.admin;

import com.radio.svc.exceptions.GenreExistException;
import com.radio.svc.serviceinterface.IGenreServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 5/22/14
 * Time: 11:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddGenreController extends AbstractController {

    IGenreServiceProvider genreServiceProvider;

    public IGenreServiceProvider getGenreServiceProvider() {
        return genreServiceProvider;
    }

    public void setGenreServiceProvider(IGenreServiceProvider genreServiceProvider) {
        this.genreServiceProvider = genreServiceProvider;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String genreName = null;

        // get genre name from request
        genreName = request.getParameter("genreName");

        ModelAndView model;
        model = new ModelAndView("/admin/genreadmin");
        model.addObject("controller", "addgenre");
        try{
            genreServiceProvider.addNewGenre(genreName);
            // Genre added successfully!
            model.addObject("msg", "success");
        }catch (GenreExistException e){
            model.addObject("msg", "failed");
            // Genre was already existed in the system
            model.addObject("msgbody", e.getMessage());
        }

        return model;

    }
}
