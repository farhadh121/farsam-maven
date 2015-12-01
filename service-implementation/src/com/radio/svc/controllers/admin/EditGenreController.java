package com.radio.svc.controllers.admin;

import com.radio.svc.serviceinterface.IGenreServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/31/14
 * Time: 7:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditGenreController extends AbstractController {

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

        ModelAndView model = new ModelAndView("/admin/genreadmin");
        model.addObject("controller", "editgenre");
        String genreName = request.getParameter("genrenameedit");
        Long genreId = Long.valueOf(request.getParameter("genreid"));

        try{
            genreServiceProvider.modifyGenre( genreId, genreName );
            model.addObject("msg", "success");
        }catch ( Exception e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }

        return model;

    }
}
