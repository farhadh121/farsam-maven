package com.radio.svc.controllers.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.admin.jsonentities.ChangeSongAlbumRequest;
import com.radio.svc.controllers.admin.jsonentities.ChangeSongNameRequest;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by saman on 10/13/14.
 */

@Controller
public class ChangeSongAlbumController {

    private ISongServiceProvider songServiceProvider;

    public ISongServiceProvider getSongServiceProvider() {
        return songServiceProvider;
    }

    public void setSongServiceProvider(ISongServiceProvider songServiceProvider) {
        this.songServiceProvider = songServiceProvider;
    }

    @RequestMapping( value = "/changeSongAlbumName.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String changeSongAlbum( @RequestBody String json ) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        ChangeSongAlbumRequest changeSongAlbumRequest = objectMapper.readValue(json, ChangeSongAlbumRequest.class);

        try{
            songServiceProvider.changeSongAlbum( changeSongAlbumRequest.getId(), changeSongAlbumRequest.getName() );
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
