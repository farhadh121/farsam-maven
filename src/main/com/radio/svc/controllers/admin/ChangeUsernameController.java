package com.radio.svc.controllers.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.admin.jsonentities.ChangeSongNameRequest;
import com.radio.svc.controllers.admin.jsonentities.ChangeUsernameRequest;
import com.radio.svc.exceptions.EmailNotValidException;
import com.radio.svc.exceptions.TaghchehException;
import com.radio.svc.exceptions.UserNotExistsException;
import com.radio.svc.serviceinterface.IUserServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by MizhoO on 11/12/14.
 */


@Controller
public class ChangeUsernameController  {

    IUserServiceProvider userServiceProvider;

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }

    @RequestMapping( value="/changeUsernameController.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String changeUsername( @RequestBody String json ) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        ChangeUsernameRequest changeUsernameRequest = objectMapper.readValue(json, ChangeUsernameRequest.class);

        try{
            userServiceProvider.editUsername( Long.valueOf(changeUsernameRequest.getUserID()), changeUsernameRequest.getUsername() );
            return toJson("success");
        }catch (UserNotExistsException e){
            return toJson("failed");
        }
      /*  catch(EmailNotValidException e){
            return toJson("emailnotvalid");
        }  */

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
