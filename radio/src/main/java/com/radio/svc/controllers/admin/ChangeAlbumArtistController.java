package com.radio.svc.controllers.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.admin.jsonentities.ChangeAlbumArtistRequest;
import com.radio.svc.serviceinterface.IAlbumServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by farhad on 10/18/14.
 */


@Controller
public class ChangeAlbumArtistController {

    private IAlbumServiceProvider albumServiceProvider;

    public IAlbumServiceProvider getAlbumServiceProvider() {
        return albumServiceProvider;
    }

    public void setAlbumServiceProvider(IAlbumServiceProvider albumServiceProvider) {
        this.albumServiceProvider = albumServiceProvider;
    }

    @RequestMapping( value = "/changeAlbumArtist.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String changeAlbumArtist( @RequestBody String json ) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        ChangeAlbumArtistRequest changeAlbumArtistRequest = objectMapper.readValue(json, ChangeAlbumArtistRequest.class);

        try{
            return toJson( "success" );
        }catch ( Exception e ){
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
