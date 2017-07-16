package com.radio.svc.controllers.admin;

import com.radio.svc.serviceinterface.IStationServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by saman on 9/18/14.
 */
public class DeleteStationController extends AbstractController {

    IStationServiceProvider stationServiceProvider;

    public IStationServiceProvider getStationServiceProvider() {
        return stationServiceProvider;
    }

    public void setStationServiceProvider(IStationServiceProvider stationServiceProvider) {
        this.stationServiceProvider = stationServiceProvider;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest Request, HttpServletResponse Response) throws
            Exception {

        ModelAndView model = new ModelAndView("/admin/stationadmin");
        model.addObject( "controller","deletestation" );

        String stationId = Request.getParameter( "stationid" );

        try{
            stationServiceProvider.deleteStationById( Long.valueOf( stationId ) );
            model.addObject( "msg", "success" );
        }catch ( Exception e ){
            model.addObject( "msg", "failed" );
            model.addObject( "msgbody", e.getMessage() );
        }

        return model;

    }
}
