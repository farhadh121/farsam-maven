package com.radio.svc.serviceinterface;

import com.radio.svc.searchentities.SearchResult;
import java.io.Serializable;
import java.util.List;

/**
 * Created by farhad on 8/22/14.
 */
public interface ISearchServiceProvider extends Serializable {

    /**
     * Searches for all objects, including artists, albums, and song, which contains this partial name.
     * @param partialName       The partial name that we are searching based on it.
     * @return          returns a list of search result
     */
    public List<SearchResult> searchByPartialName( String partialName );

}
