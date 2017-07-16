package com.radio.svc.controllers.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.admin.jsonentities.ChangeBornDateRequest;
import com.radio.svc.controllers.admin.jsonentities.ChangeUserFirstNameRequest;
import com.radio.svc.serviceinterface.IUserServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by saman on 11/12/14.
 */


@Controller
public class ChangeUserFirstNameController {

    private IUserServiceProvider userServiceProvider;

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }

    @RequestMapping( value = "/changeUserFirstName.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String changeUserFirstName( @RequestBody String json ) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        ChangeUserFirstNameRequest changeUserFirstNameRequest = objectMapper.readValue(json, ChangeUserFirstNameRequest.class);

        try{
            userServiceProvider.editUserFirstName( changeUserFirstNameRequest.getUserID(), changeUserFirstNameRequest.getFirstName() );
            return toJson( "success" );
        }catch (Exception e){
            return toJson( "failed" );
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
