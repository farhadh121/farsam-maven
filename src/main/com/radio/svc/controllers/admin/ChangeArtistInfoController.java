package com.radio.svc.controllers.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.admin.jsonentities.ChangeArtistInfoRequest;
import com.radio.svc.controllers.admin.jsonentities.ChangeArtistNameRequest;
import com.radio.svc.controllers.admin.jsonentities.ChangeSongAlbumRequest;
import com.radio.svc.serviceinterface.IArtistServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by farhad on 10/15/14.
 */


@Controller
public class ChangeArtistInfoController {

    private IArtistServiceProvider artistServiceProvider;

    public IArtistServiceProvider getArtistServiceProvider() {
        return artistServiceProvider;
    }

    public void setArtistServiceProvider(IArtistServiceProvider artistServiceProvider) {
        this.artistServiceProvider = artistServiceProvider;
    }


    @RequestMapping( value = "/changeArtistInfo.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String changeSongInfo( @RequestBody String json ) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        ChangeArtistInfoRequest changeArtistInfoRequest = objectMapper.readValue(json, ChangeArtistInfoRequest.class);

        try{
            artistServiceProvider.changeArtistInfo( changeArtistInfoRequest.getId(), changeArtistInfoRequest.getInfo() );
            return toJson( "succes" );
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
