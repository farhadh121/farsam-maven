package com.radio.svc.controllers.admin;

import com.radio.svc.exceptions.GenreNotExistsException;
import com.radio.svc.serviceinterface.IGenreServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/23/14
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteGenreController extends AbstractController {

    IGenreServiceProvider genreServiceProvider;

    public IGenreServiceProvider getGenreServiceProvider() {
        return genreServiceProvider;
    }

    public void setGenreServiceProvider(IGenreServiceProvider genreServiceProvider) {
        this.genreServiceProvider = genreServiceProvider;
    }

    ////////////////////////////////////////////////////////////

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("/admin/genreadmin");
        String genreName = request.getParameter("genrename");
        model.addObject("controller", "deletegenre");

        try{
            genreServiceProvider.deleteGenre(genreName);
            model.addObject("msg", "success");
        }catch( GenreNotExistsException e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }

        return model;

    }
}
