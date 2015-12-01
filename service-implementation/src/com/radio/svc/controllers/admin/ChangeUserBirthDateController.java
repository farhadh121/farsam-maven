package com.radio.svc.controllers.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.admin.jsonentities.ChangeBornDateRequest;
import com.radio.svc.controllers.admin.jsonentities.ChangeSongNameRequest;
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
public class ChangeUserBirthDateController {

    private IUserServiceProvider userServiceProvider;

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }

    @RequestMapping( value = "/changeUserBirthDate.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String changeUserBirthDate( @RequestBody String json ) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        ChangeBornDateRequest changeBornDateRequest = objectMapper.readValue(json, ChangeBornDateRequest.class);

        try{
            userServiceProvider.editBirthdate( changeBornDateRequest.getUserID(), changeBornDateRequest.getBornDate() );
            return toJson("success");
        }catch ( Exception e ){
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
