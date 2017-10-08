package com.radio.svc.facade;

import com.radio.svc.logic.SearchLogic;
import com.radio.svc.searchentities.SearchResult;
import com.radio.svc.serviceinterface.ISearchServiceProvider;


import java.util.List;

/**
 * Created by saman on 8/22/14.
 */
public class SearchFacade implements ISearchServiceProvider {

    private SearchLogic searchLogic;

    public SearchLogic getSearchLogic() {
        return searchLogic;
    }

    public void setSearchLogic(SearchLogic searchLogic) {
        this.searchLogic = searchLogic;
    }


    public List<SearchResult> searchByPartialName(String partialName) {

        return searchLogic.searchByPartialName( partialName );

    }
}
