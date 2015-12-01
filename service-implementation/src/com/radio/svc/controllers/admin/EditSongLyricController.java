package com.radio.svc.controllers.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.admin.jsonentities.ChangeSongAlbumRequest;
import com.radio.svc.controllers.admin.jsonentities.ChangeSongLyricRequest;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by saman on 10/1/14.
 */

@Controller
public class EditSongLyricController {

    private ISongServiceProvider songServiceProvider;

    public ISongServiceProvider getSongServiceProvider() {
        return songServiceProvider;
    }

    public void setSongServiceProvider(ISongServiceProvider songServiceProvider) {
        this.songServiceProvider = songServiceProvider;
    }

    @RequestMapping( value = "/changeSongLyric.ajax", method = RequestMethod.POST )
    @ResponseBody
    private String changeSongLyric( @RequestBody String json ) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        ChangeSongLyricRequest changeSongLyricRequest = objectMapper.readValue(json, ChangeSongLyricRequest.class);

        try{
            String name = songServiceProvider.changeSongLyric( changeSongLyricRequest.getId(), changeSongLyricRequest.getLyric() );
            return toJson( name );
        }catch (Exception e){
            e.printStackTrace();
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
