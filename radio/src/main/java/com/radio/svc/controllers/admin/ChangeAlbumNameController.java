package com.radio.svc.controllers.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.admin.jsonentities.ChangeAlbumNameRequest;
import com.radio.svc.controllers.admin.jsonentities.ChangeArtistInfoRequest;
import com.radio.svc.serviceinterface.IAlbumServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by farhad on 10/17/14.
 */


@Controller
public class ChangeAlbumNameController {

    private IAlbumServiceProvider albumServiceProvider;

    public IAlbumServiceProvider getAlbumServiceProvider() {
        return albumServiceProvider;
    }

    public void setAlbumServiceProvider(IAlbumServiceProvider albumServiceProvider) {
        this.albumServiceProvider = albumServiceProvider;
    }


    @RequestMapping( value = "/changeAlbumName.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String changeAlbumName( @RequestBody String json ) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        ChangeAlbumNameRequest changeAlbumNameRequest = objectMapper.readValue(json, ChangeAlbumNameRequest.class);

        try{
            String result = albumServiceProvider.changeAlbumName( changeAlbumNameRequest.getId(), changeAlbumNameRequest.getName() );
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
