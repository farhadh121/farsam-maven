package com.radio.svc.controllers.admin;

import com.radio.svc.serviceinterface.IGenreServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/23/14
 * Time: 12:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class ListGenresController extends AbstractController {

    IGenreServiceProvider genreServiceProvider;

    public IGenreServiceProvider getGenreServiceProvider() {
        return genreServiceProvider;
    }

    public void setGenreServiceProvider(IGenreServiceProvider genreServiceProvider) {
        this.genreServiceProvider = genreServiceProvider;
    }

    ////////////////////////////////////////////////////////////////

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView("/admin/genreadmin");

        // insert all genres as a list attribute
        modelAndView.addObject("list", genreServiceProvider.getAllGenres());
        modelAndView.addObject("controller", "listgenres");

        return modelAndView;

    }
}
