package com.radio.svc.controllers.radio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radio.svc.controllers.radio.jsonentities.SearchRequest;
import com.radio.svc.searchentities.SearchResult;
import com.radio.svc.serviceinterface.ISearchServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by farhad on 8/23/14.
 */

@Controller
public class SearchStationController{


    private ISearchServiceProvider searchServiceProvider;

    public ISearchServiceProvider getSearchServiceProvider() {
        return searchServiceProvider;
    }

    public void setSearchServiceProvider(ISearchServiceProvider searchServiceProvider) {
        this.searchServiceProvider = searchServiceProvider;
    }

    @RequestMapping( value = "/searchForStation.ajax", method = RequestMethod.POST )
    @ResponseBody
    public String searchFor( @RequestBody String json) throws IOException {
        //System.out.println( "hello" );
        ObjectMapper objectMapper = new ObjectMapper();
        //System.out.println( "hello2" );
        SearchRequest requestValue = objectMapper.readValue( json, SearchRequest.class );
        //System.out.println( "hello3" );

        List<SearchResult> result = null;
        try {
            result = searchServiceProvider.searchByPartialName(requestValue.getSearch());
        }catch( Exception e ){
            e.printStackTrace();
        }

        //System.out.println( "Pure result: " + result );

        //System.out.println( "To Json: " + toJson(result) );

        return toJson( result );

    }

    private String toJson( List<SearchResult> result ){

        ObjectMapper mapper = new ObjectMapper();
        try{
            String value = mapper.writeValueAsString(result);
            return value;
        }catch ( JsonProcessingException e ){
            return null;
        }

    }

}

