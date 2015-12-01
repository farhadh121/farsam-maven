package com.radio.svc.controllers.radio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.entity.hibernate.StationEntity;
import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.controllers.radio.jsonentities.StationDeleteRequest;
import com.radio.svc.controllers.radio.jsonentities.StationRequest;
import com.radio.svc.serviceinterface.IStationServiceProvider;
import com.radio.svc.serviceinterface.IUserServiceProvider;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 7/4/15
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class DeleteUserStationController {

    private IStationServiceProvider stationServiceProvider;
    private IUserServiceProvider userServiceProvider;

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }

    public IStationServiceProvider getStationServiceProvider() {
        return stationServiceProvider;
    }

    public void setStationServiceProvider(IStationServiceProvider stationServiceProvider) {
        this.stationServiceProvider = stationServiceProvider;
    }

    /////////////////////////////////////////////////////////////////

    @RequestMapping( value = "/deleteUserStation.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String deleteUserStation( @RequestBody String json ) throws Exception{


        ObjectMapper objectMapper = new ObjectMapper();
        StationDeleteRequest stationDeleteRequest = objectMapper.readValue(json, StationDeleteRequest.class);
        try {

            stationServiceProvider.deleteUserSationById(stationDeleteRequest.getStationid(), stationDeleteRequest.getUsername());
            String result =  "success" ;
            return toJson(result);
        }catch ( Exception e ){
            e.printStackTrace();
            return toJson("failed");
        }
    }

    private String toJson( String result ){
        ObjectMapper mapper = new ObjectMapper();
        try{
            String value = mapper.writeValueAsString( result );
            return value;
        }catch ( JsonProcessingException e ){
            return null;
        }
    }

}

