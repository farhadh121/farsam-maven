package com.radio.svc.controllers.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.admin.jsonentities.ChangeSongNameRequest;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by farhad on 9/27/14.
 */

@Controller
public class editSongNameController {

    private ISongServiceProvider songServiceProvider;

    public ISongServiceProvider getSongServiceProvider() {
        return songServiceProvider;
    }

    public void setSongServiceProvider(ISongServiceProvider songServiceProvider) {
        this.songServiceProvider = songServiceProvider;
    }

    @RequestMapping( value = "/changeSongName.ajax", method = RequestMethod.POST )
    @ResponseBody
    private String changeSongName( @RequestBody String json ) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        ChangeSongNameRequest changeSongNameRequest = objectMapper.readValue(json, ChangeSongNameRequest.class);

        try{
            String name = songServiceProvider.changeSongName( changeSongNameRequest.getId(), changeSongNameRequest.getName() );
            String result = toJson( name );
            return result;
        }catch ( Exception e ){
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
