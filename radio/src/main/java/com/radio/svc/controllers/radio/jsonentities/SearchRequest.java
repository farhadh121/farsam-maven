package com.radio.svc.controllers.radio.jsonentities;

/**
 * Created by saman on 8/23/14.
 */
public class SearchRequest {

    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public SearchRequest(String search) {
        this.search = search;
    }

    public SearchRequest() {
    }

   
    
}
