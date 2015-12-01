package com.radio.svc.controllers.admin;

import com.radio.svc.serviceinterface.IStationServiceProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by farhad on 10/20/14.
 */
public class AddStationController extends AbstractController {

    private IStationServiceProvider stationServiceProvider;

    public IStationServiceProvider getStationServiceProvider() {
        return stationServiceProvider;
    }

    public void setStationServiceProvider(IStationServiceProvider stationServiceProvider) {
        this.stationServiceProvider = stationServiceProvider;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws
            Exception {

        ModelAndView model = new ModelAndView("/admin/stationadmin");
        model.addObject("controller", "addstation");

        String name = httpServletRequest.getParameter( "stationname" );
        List<String> keys = new LinkedList<String>();
        List<String> values = new LinkedList<String>();

        // Extracting the features key,value
        int counter = 0;
        while( true ){
            String key = httpServletRequest.getParameter( "stationfeaturekey" + counter );
            String value = httpServletRequest.getParameter( "stationfeaturevalue" + counter );

            if( key == null || value == null )
                break;

            keys.add(key);
            values.add( value );
        }

        Map<String, String> features = new HashMap<String, String>();
        Iterator itrKeys = keys.iterator();
        Iterator itrValues = values.iterator();

        while( itrKeys.hasNext() ){

            String key = (String)itrKeys.next();
            String value = (String)itrValues.next();

            features.put( key,value );
        }

        try{
            // Inserting the features key,value
            stationServiceProvider.createNewStation( features, name, ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername() );
            model.addObject("msg", "success");
        }catch ( Exception e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }

        return model;

    }
}
