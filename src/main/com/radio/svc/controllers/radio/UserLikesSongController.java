package com.radio.svc.controllers.radio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.radio.jsonentities.LikeRequest;
import com.radio.svc.controllers.radio.jsonentities.SearchRequest;
import com.radio.svc.dalc.ISongDA;
import com.radio.svc.searchentities.SearchResult;
import com.radio.svc.serviceinterface.ISearchServiceProvider;
import com.radio.svc.serviceinterface.ISongServiceProvider;
import com.radio.svc.serviceinterface.IUserServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 12/18/14
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserLikesSongController {
    private IUserServiceProvider userServiceProvider;
    private ISongServiceProvider songServiceProvider;



    public ISongServiceProvider getSongServiceProvider() {

        return songServiceProvider;
    }

    public void setSongServiceProvider(ISongServiceProvider songServiceProvider) {
        this.songServiceProvider = songServiceProvider;
    }

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }


    @RequestMapping( value = "/userLikesSong.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String likedSong( @RequestBody String json) throws IOException {
        //System.out.println( "hello" );
        ObjectMapper objectMapper = new ObjectMapper();
        //System.out.println( "hello2" );
        LikeRequest requestValue = objectMapper.readValue( json, LikeRequest.class );
        System.out.println( "hello3" );
        System.out.println( requestValue.getSongid() + "and " + requestValue.getUserid());

        Long result = null;
        try {
            result = userServiceProvider.userLikeSongs(requestValue.getUserName(), requestValue.getSongid());
        }catch( Exception e ){
            e.printStackTrace();
        }

        //System.out.println( "Pure result: " + result );

        //System.out.println( "To Json: " + toJson(result) );

        return toJson( result );

    }

    private String toJson( Long result ){

        ObjectMapper mapper = new ObjectMapper();
        try{
            String value = mapper.writeValueAsString(result);
            return value;
        }catch ( JsonProcessingException e ){
            return null;
        }

    }
}
