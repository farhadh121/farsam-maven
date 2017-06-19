package com.radio.svc.controllers.radio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.entity.hibernate.UserEntity;
import com.radio.svc.controllers.radio.jsonentities.FacebookLoginRequest;
import com.radio.svc.controllers.radio.jsonentities.FacebookLoginResult;
import com.radio.svc.controllers.radio.jsonentities.StationRequest;
import com.radio.svc.exceptions.UserExistsException;
import com.radio.svc.exceptions.UserNotExistsException;
import com.radio.svc.searchentities.SearchResult;
import com.radio.svc.serviceinterface.IUserServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 1/4/15
 * Time: 9:44 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class FacebookLoginController {
    private IUserServiceProvider userServiceProvider;

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }
    @RequestMapping( value = "/facebookLogin.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String facebookLogin(@RequestBody String json ) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        FacebookLoginRequest facebookLoginRequest = objectMapper.readValue(json, FacebookLoginRequest.class);

        UserEntity realUserEntity = null;

        try{
            realUserEntity = userServiceProvider.getUserByUsername( facebookLoginRequest.getEmail() );
            FacebookLoginResult facebookLoginResult = new FacebookLoginResult();
            facebookLoginResult.setUsername( realUserEntity.getEmail() );
            facebookLoginResult.setPassword( realUserEntity.getPassword() );
            return toJson(facebookLoginResult);

        }catch ( UserNotExistsException e ){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = facebookLoginRequest.getBirthday();
            Date date = new Date();
            /*
            try{
                date = simpleDateFormat.parse(birthday);

            }catch (ParseException parseException){
                parseException.printStackTrace();
            }
            */
            List<String> roles = new LinkedList<String>();
            roles.add("ROLE_USER");
            userServiceProvider.addUser(facebookLoginRequest.getEmail(), facebookLoginRequest.getId(), facebookLoginRequest.getName(),
                        facebookLoginRequest.getName(),date, roles);
            FacebookLoginResult facebookLoginResult = new FacebookLoginResult();
            facebookLoginResult.setUsername(facebookLoginRequest.getUsername());
            facebookLoginResult.setPassword(facebookLoginRequest.getId());

            return toJson(facebookLoginResult);

        }

    }

    private String toJson( FacebookLoginResult facebookLoginResult ){

        ObjectMapper mapper = new ObjectMapper();
        try{
            String value = mapper.writeValueAsString(facebookLoginResult);
            return value;
        }catch ( JsonProcessingException e ){
            return null;
        }

    }

}
