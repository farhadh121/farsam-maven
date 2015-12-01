package com.radio.svc.controllers.radio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.radio.jsonentities.StationRequest;
import com.radio.svc.serviceinterface.IStationServiceProvider;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.userdetails.User;

import java.io.IOException;

/**
 * Created by farhad on 8/29/14.
 */


@Controller
public class CreateStationController {

    private IStationServiceProvider stationServiceProvider;

    public IStationServiceProvider getStationServiceProvider() {
        return stationServiceProvider;
    }

    public void setStationServiceProvider(IStationServiceProvider stationServiceProvider) {
        this.stationServiceProvider = stationServiceProvider;
    }

    /////////////////////////////////////////////////////////////////

    @RequestMapping( value = "/createStation.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String createStation( @RequestBody String json ) throws Exception{


        ObjectMapper objectMapper = new ObjectMapper();
        StationRequest stationRequest = objectMapper.readValue(json, StationRequest.class);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = null;

        if( !(authentication instanceof AnonymousAuthenticationToken) ){
            user = (User)authentication.getPrincipal();
        }

        String username = null;
        if( user != null )
            username = user.getUsername();

        try {
            Long stationID = stationServiceProvider.createNewStationBySearchEntity(stationRequest.getType(), stationRequest.getName(), stationRequest.getId(), username, stationRequest.getLyrics());
            String result = toJson( stationID );
            return result;
        }catch ( Exception e ){
            e.printStackTrace();
            return toJson(new Long(-1));
        }
    }

    private String toJson( Long result ){
        ObjectMapper mapper = new ObjectMapper();
        try{
            String value = mapper.writeValueAsString( result );
            return value;
        }catch ( JsonProcessingException e ){
            return null;
        }
    }

}
