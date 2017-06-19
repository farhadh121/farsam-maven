package com.radio.svc.controllers.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.admin.jsonentities.ChangeArtistNameRequest;
import com.radio.svc.controllers.admin.jsonentities.ChangeSongAlbumRequest;
import com.radio.svc.serviceinterface.IArtistServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by saman on 10/15/14.
 */

@Controller
public class ChangeArtistNameController {

    private IArtistServiceProvider artistServiceProvider;

    public IArtistServiceProvider getArtistServiceProvider() {
        return artistServiceProvider;
    }

    public void setArtistServiceProvider(IArtistServiceProvider artistServiceProvider) {
        this.artistServiceProvider = artistServiceProvider;
    }


    @RequestMapping( value = "/changeArtistName.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String changeArtistName( @RequestBody String json ) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        ChangeArtistNameRequest changeArtistNameRequest = objectMapper.readValue(json, ChangeArtistNameRequest.class);

        try{
            artistServiceProvider.changeArtistName( changeArtistNameRequest.getId(), changeArtistNameRequest.getName() );
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
